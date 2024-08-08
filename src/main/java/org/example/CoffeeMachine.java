package org.example;

import org.example.History;
import org.example.IngredientManager;
import org.example.RecipeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {

    public boolean isOn;

    public IngredientManager ingredientManager;

    public RecipeManager recipeManager;

    public History history;


    public int countCup;

    public final int COUNT_CUP_TO_CLEAN;

    private List<Profile> profiles;


    public CoffeeMachine() {
        this.isOn = false;
        this.ingredientManager = new IngredientManager(900, 400, 90, 1000, 500, 100);
        this.recipeManager = new RecipeManager();
        this.history = new History();
        this.countCup = 0;
        this.profiles = new ArrayList<>();
        this.COUNT_CUP_TO_CLEAN = 15;
    }


    public void onOff() {
        if (!isOn) {
            System.out.println("Включить машину? Нажмите '1'");
            Scanner indikator = new Scanner(System.in);
            String buttom = indikator.nextLine();

            if (buttom.equals("1")) {
                isOn = true;
            } else {
                System.out.println("Неверный ввод, попробуйте снова (используйте заглавные английские буквы)");
            }
        } else {
            System.out.println("Выключить машину? Нажмите '0'");
            Scanner indikator = new Scanner(System.in);
            String buttom = indikator.nextLine();

            if (buttom.equals("0")) {
                isOn = false;
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
            }
        }
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!isOn) {
                onOff();
                if (!isOn) {
                    break;
                }
            }

            System.out.println("Чтобы выбрать тип напитка, нажмите '1'");
            System.out.println("Чтобы посмотреть уровень воды нажмите '2', уровень кофе '3', уровень молока '4'");
            System.out.println("Чтобы посмотреть историю напитков нажмите '5'");
            System.out.println("Чтобы добавить профиль нажмите '6'");
            System.out.println("Чтобы выбрать профиль и приготовить напиток нажмите '7'");
            System.out.println("Чтобы показать рецепт напитка нажмите '8'");

            System.out.println("Чтобы выключить кофемашину нажмите '0'");
            Scanner choice1 = new Scanner(System.in);

            int num1 = choice1.nextInt();

            switch (num1) {
                case 1:
                    choiceDrinks();
                    break;
                case 2:
                    ingredientManager.showWater();
                    break;
                case 3:
                    ingredientManager.showCoffee();
                    break;
                case 4:
                    ingredientManager.showMilk();
                    break;
                case 5:
                    history.showHistory();
                    break;
                case 6:
                    addProfile();
                    break;
                case 7:
                    chooseProfile();
                    break;
                case 8:
                    showRecipe();
                    break;
                case 0:
                    isOn = false;
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова");
                    break;
            }
        }
    }

    public void choiceDrinks() {
        System.out.println("Какой напиток приготовить? Введите номер");
        System.out.println("1 - Эспрессо" + "\n" + "2 - Капучино" + "\n" + "3 - Латте ");
        Scanner choice2 = new Scanner(System.in);
        int drink = choice2.nextInt();

        switch (drink) {
            case 1:
                cookCoffee(Drinks.ESPRESSO);
                break;
            case 2:
                cookCoffee(Drinks.CAPPUCHINO);
                break;
            case 3:
                cookCoffee(Drinks.LATTE);
                break;
            default:
                System.out.println("Неверный ввод, попробуйте снова");
                break;
        }
    }

    public void cookCoffee(Drinks drink) {
        int portions = choiceCountCup();
        int totalWater = drink.getWaterDrink() * portions;
        int totalMilk = drink.getMilkDrink() * portions;
        int totalCoffee = drink.getCoffeeDrink() * portions;
        if (ingredientManager.getWater() >= totalWater && ingredientManager.getCoffee() >= totalCoffee && ingredientManager.getMilk() >= totalMilk) {
            ingredientManager.setWater(ingredientManager.getWater() - totalWater);
            ingredientManager.setCoffee(ingredientManager.getCoffee() - totalCoffee);
            ingredientManager.setMilk(ingredientManager.getMilk() - totalMilk);
            countCup += portions;
            history.addAction("Порции: " + portions + "кофе" + drink.name());
            System.out.println("Приготовлено " + portions + " порций " + drink.name());

            if (countCup >= COUNT_CUP_TO_CLEAN) {
                cleanMachine();
            } else {
                System.out.println("Недостаточно ингредиентов. Проверьте уровень кофе, молока и воды");
            }
        }
    }

    //Внедрить в главный метод очистку
    public void cleanMachine () {
        System.out.println("Очистка кофемашины...");
        ingredientManager.useIngredients(100, 0, 0);
        countCup = 0;
        history.addAction("Очистка кофемашины выполнена.");
    }

    public int choiceCountCup() {
        System.out.println("Сколько порций?");
        Scanner num = new Scanner(System.in);
        return num.nextInt();
    }
    public void addProfile(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя профиля: ");
        String name = scanner.nextLine();
        Profile profile = new Profile(name);

        System.out.println("Добавьте напитки в профиль: ");
        while (true){
            System.out.println("Введите номер напитка");
            System.out.println("1 - Эспрессо" + "\n" + "2 - Капучино" + "\n" + "3 - Латте ");
            int drinkNum = scanner.nextInt();
            Drinks drink = null;

            switch (drinkNum) {
                case 1:
                    drink = Drinks.ESPRESSO;
                    break;
                case 2:
                    drink = Drinks.CAPPUCHINO;
                    break;
                case 3:
                    drink = Drinks.LATTE;
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова");
                    continue;
            }
            System.out.println("Введите количество порций:");
            int portions = scanner.nextInt();
            profile.addFavoriteDrink(drink, portions);

            System.out.println("Добавить еще напиток? (да/нет)");
            scanner.nextLine();  // Consume newline left-over
            String more = scanner.nextLine();
            if (!more.equalsIgnoreCase("да")) {
                break;
            }
        }

        profiles.add(profile);
        System.out.println("Профиль добавлен.");
    }

    public void chooseProfile() {
        if (profiles.isEmpty()) {
            System.out.println("Нет доступных профилей.");
            return;
        }

        System.out.println("Выберите профиль:");
        for (int i = 0; i < profiles.size(); i++) {
            System.out.println((i + 1) + " - " + profiles.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int profileIndex = scanner.nextInt() - 1;
        if (profileIndex < 0 || profileIndex >= profiles.size()) {
            System.out.println("Неверный выбор профиля.");
            return;
        }
        Profile profile = profiles.get(profileIndex);
        System.out.println("Выбран профиль: " + profile.getName());
        for (Map.Entry<Drinks, Integer> entry : profile.getFavoriteDrinks().entrySet()) {
            Drinks drink = entry.getKey();
            int portions = entry.getValue();
            for (int i = 0; i < portions; i++) {
                cookCoffee(drink);
            }
        }
    }

    public void showRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название напитка:");
        String drinkName = scanner.nextLine();
        recipeManager.showRecipe(drinkName);
    }
}

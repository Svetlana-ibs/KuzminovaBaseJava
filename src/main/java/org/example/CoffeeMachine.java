package org.example;

import java.util.*;

public class CoffeeMachine {

    public static boolean isOn;

    public IngredientManager ingredientManager;

    public RecipeManager recipeManager;

    public History history;

    public int countCup;

    public final int COUNT_CUP_TO_CLEAN;

    private List<Profile> profiles;

    public CoffeeMachine() {
        isOn = false;
        this.ingredientManager = new IngredientManager(900, 400, 90, 2000, 1000, 500);
        this.recipeManager = new RecipeManager();
        this.history = new History();
        this.countCup = 0;
        this.profiles = new ArrayList<>();
        this.COUNT_CUP_TO_CLEAN = 15;
    }

    public int getCountCup(){
        return countCup;
    }

    public int getCOUNT_CUP_TO_CLEAN(){
        return COUNT_CUP_TO_CLEAN;
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
            if (getCountCup() >= getCOUNT_CUP_TO_CLEAN()){
                cleanMachine();
            }
            System.out.println("Чтобы выбрать тип напитка, нажмите '1'");
            System.out.println("Чтобы посмотреть уровень воды нажмите '2', уровень кофе '3', уровень молока '4'");
            System.out.println("Чтобы посмотреть историю напитков нажмите '5'");
            System.out.println("Чтобы добавить профиль нажмите '6'");
            System.out.println("Чтобы выбрать профиль и приготовить напиток нажмите '7'");
            System.out.println("Чтобы показать рецепт напитка нажмите '8'");
            System.out.println("Выполнить вручную очистку, нажмите '9'");
            System.out.println("Чтобы выключить кофемашину нажмите '0'");
            Scanner choice1 = new Scanner(System.in);
           try {
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
                   case 9:
                       cleanMachine();
                       break;
                   case 0:
                       isOn = false;
                       break;
                   default:
                       System.out.println("Неверный ввод, попробуйте снова");
                       break;
               }
           } catch (InputMismatchException e ){
               System.out.println("Ошибка ввода.Пожалуйста введите число");
           }
        }
    }

    public void choiceDrinks() {
        System.out.println("Какой напиток приготовить? Введите номер");
        System.out.println("1 - Эспрессо" + "\n" + "2 - Капучино" + "\n" + "3 - Латте ");
        Scanner choice2 = new Scanner(System.in);

        try {
            int drink = choice2.nextInt();

            switch (drink) {
                case 1:
                    cookCoffee(Drinks.ESPRESSO,0);
                    break;
                case 2:
                    cookCoffee(Drinks.CAPPUCHINO,0);
                    break;
                case 3:
                    cookCoffee(Drinks.LATTE,0);
                    break;
                default:
                    System.out.println("Неверный ввод, попробуйте снова");
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("Ошибка ввода.Пожалуйста введите число");
        }
    }

    public void cookCoffee(Drinks drink, int portionsToCook) {
        int portions;
        if (portionsToCook == 0){
            portions = choiceCup();
        }else {
            portions = portionsToCook;
        }

        int totalWater = drink.getWaterDrink() * portions;
        int totalMilk = drink.getMilkDrink() * portions;
        int totalCoffee = drink.getCoffeeDrink() * portions;
        if (ingredientManager.getWater() >= totalWater && ingredientManager.getCoffee() >= totalCoffee && ingredientManager.getMilk() >= totalMilk) {
            ingredientManager.setWater(ingredientManager.getWater() - totalWater);
            ingredientManager.setCoffee(ingredientManager.getCoffee() - totalCoffee);
            ingredientManager.setMilk(ingredientManager.getMilk() - totalMilk);
            countCup += portions;
            history.addAction("Порции: " + portions + " Напиток: " + drink.name());
            System.out.println("Приготовлено " + portions + " порций " + drink.name());
        }else {
            System.out.println("Не хватает ингредиентов. Проверьте уровень воды, кофе и молока");
        }
    }

    public int choiceCup(){
        System.out.println("Если хотите одну порцию - введите '1', сразу приготовить 3 порции - '2', ввести вручную - '3'");
        while (true){
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                return 1;
            } else  if (choice.equals("2")){
                return 3;
            }else if (choice.equals("3")){
                return choiceCountCup();
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
            }
        }
    }

    public  void  cleanMachine() {
        if (getCountCup() == 0) {
            System.out.println("Очистка не нужна. Кофемашина чистая");
        } else if (getCountCup() >= getCOUNT_CUP_TO_CLEAN()) {
            System.out.println("Необходимо очистить кофемашину. Удалите мусор и промойте поддон для капель.");
            System.out.println("Когда завершите очистку, нажмите '1'");
            Scanner scanner = new Scanner(System.in);
            String choiceX = scanner.nextLine();
            if (choiceX.equals("1")) {
                cleanAutoMachine();
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
                cleanMachine();
            }
        } else {
            System.out.println("Уровень загрязнения небольшой." + "\n" + "Если всё же хотите очистить кофемашину, нажмите '1'" + "\n" + "Чтобы выйти из режима очистка, нажмите любой символ");
            Scanner scanner = new Scanner(System.in);
            String choiceX = scanner.nextLine();
            if (choiceX.equals("1")) {
                cleanAutoMachine();
            }
        }
    }

    private void cleanAutoMachine () {
        if (ingredientManager.getWater() >= 100) {
            System.out.println("Промывка кофемашины...");
            ingredientManager.useIngredients(100, 0, 0);
            countCup = 0;
            history.addAction("Очистка кофемашины выполнена.");
            System.out.println("Очистка кофемашины выполнена");
        } else {
            System.out.println("Недостаточно воды. Проверьте её уровень");
        }
    }

    public int choiceCountCup() {
        Scanner scanner = new Scanner(System.in);
        int portions;

        do {
            System.out.println("Сколько порций?");
            while (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите целое число больше нуля.");
                scanner.next();
            }
            portions = scanner.nextInt();
            if (portions <= 0) {
                System.out.println("Количество порций должно быть больше нуля. Попробуйте снова.");
            }
        } while (portions <= 0);
        return portions;
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
        history.addAction("Добавлен профиль: " + profile.getName() + " " + profile.getFavoriteDrinks());
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
            cookCoffee(drink,portions);
        }
    }

    public void showRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название напитка:");
        String drinkName = scanner.nextLine();
        recipeManager.showRecipe(drinkName);
    }
}

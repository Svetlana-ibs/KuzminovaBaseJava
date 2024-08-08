package org.example;

public class History {
    private String ACTION;
    private int countDrinks;

    public History(String ACTION,int countDrinks){
        this.ACTION = ACTION;
        this.countDrinks = countDrinks;
    }
    @Override
    public String toString(){
        return "История напитков:" + "\n" + "операция:" + ACTION + "Количество порций: " + countDrinks;
    }
}

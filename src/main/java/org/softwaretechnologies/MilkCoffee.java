package org.softwaretechnologies;


public class MilkCoffee implements CoffeeInterface {

    private final CoffeeInterface baseCoffee; // Базовый напиток

    public MilkCoffee(CoffeeInterface baseCoffee) {
        this.baseCoffee = baseCoffee;
    }

    @Override
    public int getCost() {
        return baseCoffee.getCost() + 10; // Стоимость базового кофе + молоко
    }

    @Override
    public String description() {
        return baseCoffee.description() + " + milk"; // Описание с добавлением молока
    }
}
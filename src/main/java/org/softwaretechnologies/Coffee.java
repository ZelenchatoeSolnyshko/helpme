package org.softwaretechnologies;

public class Coffee implements CoffeeInterface {
    @Override
    public int getCost() {
        return 50; // Стоимость базового кофе
    }

    @Override
    public String description() {
        return "only coffee"; // Описание базового кофе
    }

}
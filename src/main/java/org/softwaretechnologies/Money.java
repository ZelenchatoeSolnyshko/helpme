package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Money равны, если одинаковый тип валют и одинаковое число денег до 4 знака после запятой.
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @param o объект для сравнения
     * @return true - равно, false - иначе
     */
    @Override
    public boolean equals(Object o) {
        // TODO: реализуйте вышеуказанную функцию
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass() {
            return false;
        }
        if (type != money.type) {
            return false;
        }
        BigDecimal first = (amount == null) ? BigDecimal.ZERO : amount.setScale(4, RoundingMode.HALF_UP);
        BigDecimal second = (money.amount == null) ? BigDecimal.ZERO : money.amount.setScale(4, RoundingMode.HALF_UP);

        return first.equals(second);


    }

    /**
     * Формула:
     * (Если amount null 10000, иначе количество денег окрукленные до 4х знаков * 10000) + :
     * если USD , то 1
     * если EURO, то 2
     * если RUB, то 3
     * если KRONA, то 4
     * если null, то 5
     * Если amount округленный до 4х знаков * 10000 >= (Integer.MaxValue - 5), то хеш равен Integer.MaxValue
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @return хеш код по указанной формуле
     */
    @Override
    public int hashCode() {
        // TODO: реализуйте вышеуказанную функцию
        if(this.amount == null) {
            return 10000;
        }
        BigDecimal money = this.amount.setScale(4,RoundingMode.HALF_UP);
        BigDecimal moneyMaxValue;
        moneyMaxValue = money.multiply(BigDecimal.valueOf(10_000));
        money = money.multiply(BigDecimal.valueOf(10_000));
        switch (type){
            case USD -> money = money.multiply(BigDecimal.valueOf(1));
            case EURO -> money = money.multiply(BigDecimal.valueOf(2));
            case RUB -> money = money.multiply(BigDecimal.valueOf(3));
            case KRONA -> money = money.multiply(BigDecimal.valueOf(4));
            default -> money = money.multiply(BigDecimal.valueOf(5));
        }
        int res = moneyMaxValue.compareTo(BigDecimal.valueOf(MAX_VALUE-5));
        if(res > 0 || res == 0){
            return MAX_VALUE;
        }
        return  money.intValue();
    }

    /**
     * Верните строку в формате
     * Тип_ВАЛЮТЫ: количество.XXXX
     * Тип_валюты: USD, EURO, RUB или KRONA
     * количество.XXXX - округленный amount до 4х знаков.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     * <p>
     * Если тип валюты null, то вернуть:
     * null: количество.XXXX
     * Если количество денег null, то вернуть:
     * Тип_ВАЛЮТЫ: null
     * Если и то и то null, то вернуть:
     * null: null
     *
     * @return приведение к строке по указанному формату.
     */
    @Override
    public String toString() {
        // TODO: реализуйте вышеуказанную функцию
        if(type == null && amount == null){
            return "null: null";
        }
        if(type == null){
            return "null: " + amount.setScale(4, RoundingMode.HALF_UP);
        }
        if(amount == null){
            return type + ": null";
        }
        return type+": "+amount.setScale(4,RoundingMode.HALF_UP);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyType getType() {
        return type;
    }

    public static void main(String[] args) {
        Money money = new Money(MoneyType.EURO, BigDecimal.valueOf(10.00012));
        Money money1 = new Money(MoneyType.USD, BigDecimal.valueOf(10.5000));
        System.out.println(money1.toString());
        System.out.println(money1.hashCode());
        System.out.println(money.equals(money1));
    }
}

/*if(this == o) return true;//если один и тоже объект
        if(o == null || getClass() != o.getClass())return false;//проверка является ли объект экземпляром класса Money

        Money object = (Money) o;//поняли, что объект это экземпляр Money и привели тип

        //округляем в большую или в меньшую сторону
        BigDecimal thisMoney = this.amount.setScale(4,RoundingMode.HALF_UP);
        BigDecimal objectMoney = object.amount.setScale(4,RoundingMode.HALF_UP);

        return thisMoney.equals(objectMoney) && this.type == object.type;


        if(this.amount == null)return 10000;

        BigDecimal money = this.amount.setScale(4,RoundingMode.HALF_UP);
        BigDecimal moneyMaxValue;

        moneyMaxValue = money.multiply(BigDecimal.valueOf(10_000));
        money = money.multiply(BigDecimal.valueOf(10_000));
        switch (type){
            case RUB -> money = money.multiply(BigDecimal.valueOf(3));
            case USD -> money = money.multiply(BigDecimal.valueOf(1));
            case EURO -> money = money.multiply(BigDecimal.valueOf(2));
            case KRONA -> money = money.multiply(BigDecimal.valueOf(4));
            default -> money = money.multiply(BigDecimal.valueOf(5));
        }


        int res = moneyMaxValue.compareTo(BigDecimal.valueOf(MAX_VALUE-5));
        if(res > 0 || res == 0){
            return MAX_VALUE;
        }

        return  money.intValue();


    }


    }
*/

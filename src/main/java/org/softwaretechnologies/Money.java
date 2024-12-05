package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static org.softwaretechnologies.MoneyType.*;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {

        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        if (type != money.type) {
            return false;
        }
        BigDecimal scaledAmount = (amount!= null )? amount.setScale(4, RoundingMode.HALF_UP) : BigDecimal.ZERO;
        BigDecimal otherScaledAmount = (money.amount != null) ?  money.amount.setScale(4, RoundingMode.HALF_UP): BigDecimal.ZERO;

        return scaledAmount.equals(otherScaledAmount);


    }


    @Override
    public int hashCode() {

        BigDecimal scaledAmount = (amount == null ) ? BigDecimal.valueOf(10000) : amount.setScale(4 , RoundingMode.HALF_UP);


        int scaledAmountHash = scaledAmount.multiply(BigDecimal.valueOf(10000)).intValue();

        int typeHash;

        if (USD.equals(type)){
            typeHash = 1;
        }
        else if (EURO.equals(type)){
            typeHash = 2;
        } else if (RUB.equals(type)) {
            typeHash = 3;
        } else if (KRONA.equals(type)) {
            typeHash = 4;
        } else {
            typeHash = 5;
        }

        int hash = scaledAmountHash + typeHash;

        if (hash >= MAX_VALUE -5){
            return MAX_VALUE ;
        }
        else {
            return hash;
        }
    }


    @Override
    public String toString() {
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
        Money money = new Money(EURO, BigDecimal.valueOf(10.00012));
        Money money1 = new Money(USD, BigDecimal.valueOf(10.5000));
        System.out.println(money1.toString());
        System.out.println(money1.hashCode());
        System.out.println(money.equals(money1));
    }
}



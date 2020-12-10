package com.company;

import java.time.LocalDate;

public class Juice extends Drinks{

    public Juice(double cost, LocalDate PD) {
        super("Juice",cost,PD,2);
    }

    @Override
    public String toString() {
        return "Juice{" +
                "Name='" + Name + '\'' +
                ", Cost=" + Cost +
                ", PD=" + PD +
                ", EXP=" + EXP +
                '}';
    }
}

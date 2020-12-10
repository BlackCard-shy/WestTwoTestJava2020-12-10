package com.company;

import java.time.LocalDate;

public class Beer extends Drinks{
    protected float Alcohol_degree;//酒精度数
    public Beer(double cost, LocalDate PD,float Alcohol_degree) {
        super("Beer",cost,PD,30);
        this.Alcohol_degree=Alcohol_degree;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "Name='" + Name + '\'' +
                ", Cost=" + Cost +
                ", PD=" + PD +
                ", EXP=" + EXP +
                '}';
    }
}

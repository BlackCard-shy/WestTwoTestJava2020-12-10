package com.company;

import java.time.LocalDate;

abstract public class Drinks {
    protected String Name;
    protected double Cost;
    protected LocalDate PD;//生产日期
    protected int EXP;//保质期

    public Drinks(String name, double cost, LocalDate PD, int EXP) {
        Name = name;
        Cost = cost;
        this.PD = PD;
        this.EXP = EXP;
    }
    public static boolean ifoverdue(Drinks t){
        LocalDate nowtime= LocalDate.now();
        return t.PD.isBefore(nowtime.plusDays(-t.EXP));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

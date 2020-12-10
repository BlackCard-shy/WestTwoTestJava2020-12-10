package com.company;

public class SetMeal {
    protected String mealname;//套餐名
    protected double mealprice;//套餐价格
    protected String chickenname;//炸鸡名
    protected Drinks fix;//饮料

    public SetMeal(String mealname, double mealprice, String chickenname, Drinks fix) {
        this.mealname = mealname;
        this.mealprice = mealprice;
        this.chickenname = chickenname;
        this.fix = fix;
    }

    @Override
    public String toString() {
        return "SetMeal{" +
                "mealname='" + mealname + '\'' +
                ", mealprice=" + mealprice +
                ", chickenname='" + chickenname + '\'' +
                ", fix=" + fix.toString() +
                '}';
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public double getMealprice() {
        return mealprice;
    }

    public void setMealprice(double mealprice) {
        this.mealprice = mealprice;
    }

    public String getChickenname() {
        return chickenname;
    }

    public void setChickenname(String chickenname) {
        this.chickenname = chickenname;
    }

    public Drinks getFix() {
        return fix;
    }

    public void setFix(Drinks fix) {
        this.fix = fix;
    }
}


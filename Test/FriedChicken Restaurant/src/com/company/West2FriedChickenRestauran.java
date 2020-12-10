package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

//西二炸鸡店类
public class West2FriedChickenRestauran implements FriedChickenRestaurant{
    protected double overbalance;//餐厅账目余额（判断是否买的起原料）
    protected ArrayList<Beer> listBeer = new ArrayList<>();//啤酒列表
    protected ArrayList<Juice> listJuice = new ArrayList<>();//果汁列表
    static protected ArrayList<SetMeal> listSetMea = new ArrayList<>();//套餐列表
    private void use(Beer e) throws OverdraftBalanceException{
        if(Drinks.ifoverdue(e))
            throw new IngredientSortOutException(e.Name+"过期了");
        if (!listBeer.remove(e)) {
            throw new IngredientSortOutException(e.Name+"卖完了");
        }
    }

    private void use(Juice e) throws OverdraftBalanceException{
        if(Drinks.ifoverdue(e))
            throw new IngredientSortOutException(e.Name+"过期了");
        if (!listJuice.remove(e)) {
            throw new IngredientSortOutException(e.Name+"卖完了");
        }
    }
    //实现炸鸡店接口

    @Override
    public void restock(SetMeal e,int nums) throws OverdraftBalanceException {//进货
        if(e.getFix() instanceof Beer){
            if(e.getFix().Cost*nums>overbalance)
                throw new OverdraftBalanceException("您的余额不足");
            else
            {
                for(int i=0;i<nums;i++) {
                    listBeer.add((Beer)e.getFix());
                    overbalance-=e.getFix().Cost;
                }

            }

        }
        else if(e.getFix() instanceof Juice){
            if(e.getFix().Cost*nums>overbalance)
                throw new OverdraftBalanceException("您的余额不足");
            else{
                for(int i=0;i<nums;i++) {
                    listJuice.add((Juice) e.getFix());
                    overbalance -= e.getFix().Cost;
                }
            }
        }
    }

    @Override
    public void sell(SetMeal e) {
        overbalance += e.mealprice;
        if (e.getFix() instanceof Beer) {
            use((Beer) e.getFix());
        }
        else if (e.getFix() instanceof Juice) {
            use((Juice) e.getFix());
        }
    }

    public double getOverbalance() {
        return overbalance;
    }

    public void setOverbalance(double overbalance) {
        this.overbalance = overbalance;
    }

    public ArrayList<Beer> getListBeer() {
        return listBeer;
    }

    public void setListBeer(ArrayList<Beer> listBeer) {
        this.listBeer = listBeer;
    }

    public ArrayList<Juice> getListJuice() {
        return listJuice;
    }

    public void setListJuice(ArrayList<Juice> listJuice) {
        this.listJuice = listJuice;
    }

    public static ArrayList<SetMeal> getListSetMea() {
        return listSetMea;
    }

    public static void setListSetMea(ArrayList<SetMeal> listSetMea) {
        West2FriedChickenRestauran.listSetMea = listSetMea;
    }

    static {
        SetMeal zero = new SetMeal("0号简餐", 12.7, "Original Recipe",
                new Juice(6.6,LocalDate.of(2000, 12, 12)));
        SetMeal one = new SetMeal("1号简餐", 13.13, "Original Recipe",
                new Juice( 7.7, LocalDate.of(2020, 12, 12)));
        SetMeal two = new SetMeal("2号简餐", 14.14, "Original Recipe",
                new Beer( 8.8, LocalDate.of(2020, 12, 12), (float) 52));
        listSetMea.add(zero);
        listSetMea.add(one);
        listSetMea.add(two);
    }
}

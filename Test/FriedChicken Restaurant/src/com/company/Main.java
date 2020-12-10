package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        West2FriedChickenRestauran restaurant = new West2FriedChickenRestauran();//初始化
        restaurant.setOverbalance(250.52);//初始基金
        // 此时还未进货,两表为空，余额为初始基金
        System.out.println("余额：" + restaurant.getOverbalance());
        System.out.println("listBeer：" + restaurant.listBeer.toString());
        System.out.println("listJuice：" + restaurant.listJuice.toString());

        //按照套餐进行进货   套餐名字   进货数量
        try {
            restaurant.restock(restaurant.listSetMea.get(0), 1);//2000年进货，测试过期处理
            restaurant.restock(restaurant.listSetMea.get(2), 2);//新进货，测试买入卖出
            System.out.println("买入成功");
        } catch (OverdraftBalanceException e) {
            System.out.println(e.getMessage());
        }

        //进货完成  查看余额 和库存
        System.out.println("进货后余额：" + restaurant.getOverbalance());
        System.out.println("listBeer：" + restaurant.listBeer.toString());
        System.out.println("listJuice：" + restaurant.getListJuice().toString());

        //成功卖出
        try {
            restaurant.sell(restaurant.listSetMea.get(2));
            System.out.println("卖出成功");
        } catch (IngredientSortOutException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("卖出后余额：" + restaurant.getOverbalance());
        System.out.println("listBeer：" + restaurant.listBeer.toString());
        System.out.println("listJuice：" + restaurant.getListJuice().toString());


        //下一句执行会抛出过期异常
        try {
            restaurant.sell(restaurant.listSetMea.get(0));
            System.out.println("卖出成功");
        } catch (IngredientSortOutException e) {
            System.out.println(e.getMessage());
        }

        //下一句执行会抛出余额不足异常
        try {
            restaurant.restock(restaurant.listSetMea.get(1), 500);
            System.out.println("买入成功");
        } catch (OverdraftBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

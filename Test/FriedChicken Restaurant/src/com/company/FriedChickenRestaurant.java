package com.company;

public interface FriedChickenRestaurant {
   //批量进货
   public abstract void restock(SetMeal things,int nums)throws OverdraftBalanceException;
   //卖出
   public abstract  void sell(SetMeal e) throws IngredientSortOutException ;
}

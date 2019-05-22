package com.builderPatTrain;

import com.builderPatTrain.items.burger.ChickenBurger;
import com.builderPatTrain.items.burger.VegBurger;
import com.builderPatTrain.items.drink.Coke;
import com.builderPatTrain.items.drink.Pepsi;
import com.builderPatTrain.meal.Meal;

public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

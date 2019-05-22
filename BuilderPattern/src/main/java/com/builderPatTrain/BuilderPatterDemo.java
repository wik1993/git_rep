package com.builderPatTrain;

import com.builderPatTrain.meal.Meal;

public class BuilderPatterDemo {

    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost is: " + vegMeal.getCost());

        Meal nonVeg = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Veg Meal");
        nonVeg.showItems();
        System.out.println("Total cost is: " + nonVeg.getCost());
    }
}

package com.builderPatTrain.meal;

import com.builderPatTrain.items.Item;

import java.util.ArrayList;
import java.util.List;


public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        items.forEach(x -> {
            System.out.print("Item: " + x.name());
            System.out.print(", Packing: " + x.packing().pack());
            System.out.println(", Price: " + x.price());
        });
    }
}

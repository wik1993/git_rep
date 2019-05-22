package com.builderPatTrain.items.drink;

import com.builderPatTrain.packing.Bottle;
import com.builderPatTrain.items.Item;
import com.builderPatTrain.packing.Packing;

public abstract class ColdDrink implements Item {

    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}

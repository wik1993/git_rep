package com.builderPatTrain.items.burger;

import com.builderPatTrain.items.Item;
import com.builderPatTrain.packing.Packing;
import com.builderPatTrain.packing.Wrapper;

public abstract class Burger implements Item {

    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();

}

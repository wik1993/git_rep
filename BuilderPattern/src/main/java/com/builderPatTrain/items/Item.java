package com.builderPatTrain.items;

import com.builderPatTrain.packing.Packing;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}

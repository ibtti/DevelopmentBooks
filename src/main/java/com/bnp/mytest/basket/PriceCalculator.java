package com.bnp.mytest.basket;

import com.bnp.mytest.models.BasketItems;
import java.util.List;

@FunctionalInterface
public interface PriceCalculator {
    Double calculate(List<BasketItems> cartItems);
}

package com.bnp.mytest.basket;

import java.util.List;

public interface IPriceCalculator {
    Double calculate(List<BasketItems> cartItems);
}

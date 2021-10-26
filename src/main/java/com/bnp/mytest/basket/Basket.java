package com.bnp.mytest.basket;

import com.bnp.mytest.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<BasketItems> cartItems = new ArrayList<>();

    private IPriceCalculator priceCalculator;


    public Basket(IPriceCalculator priceCalculator){
        this.priceCalculator = priceCalculator;
    }

    public void add(Book book) {

        BasketItems existedItem = null;

        for (BasketItems item:cartItems){
            if (item.getBook().equals(book))
                existedItem = item;
        }

        if (existedItem != null)
            existedItem.changeQuantity(existedItem.getQuantity() + 1);
        else
            cartItems.add(new BasketItems(book, 1));
    }

    public double getTotalPrice(){
        return priceCalculator.calculate(cartItems);
    }


}

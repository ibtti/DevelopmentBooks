package com.bnp.mytest.basket;

import com.bnp.mytest.models.BasketItems;
import com.bnp.mytest.models.Book;
import com.bnp.mytest.utils.BooksSet;
import com.bnp.mytest.utils.BooksSetFactory;
import java.util.List;

public class Price implements PriceCalculator {

    private BooksSetFactory booksSetFactory;

    public Price(BooksSetFactory booksSetFactory){
        this.booksSetFactory = booksSetFactory;
    }

    @Override
    public Double calculate(List<BasketItems> basketItems) {
        List<BooksSet> setsOfDifferentBooks =
                booksSetFactory.getDifferentBooksSetsWithMaxTotalDiscount(basketItems);

        double totalPrice =0.0;
        double newPrice =0.0;

        for (BooksSet booksSet:setsOfDifferentBooks){
            for (Book book:booksSet.getBooks()) {
                newPrice += book.getPrice();
            }

            newPrice = newPrice * (1.0 - (booksSet.getDiscount()/100.0));
            totalPrice +=newPrice;
            newPrice = 0;
        }

        return totalPrice;
    }
}

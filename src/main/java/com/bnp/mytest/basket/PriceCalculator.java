package com.bnp.mytest.basket;

import com.bnp.mytest.book.Book;
import com.bnp.mytest.utils.BooksSet;
import com.bnp.mytest.utils.BooksSetFactory;

import java.util.List;

public class PriceCalculator implements IPriceCalculator{

    private BooksSetFactory booksSetFactory;

    public PriceCalculator(BooksSetFactory booksSetFactory){
        this.booksSetFactory = booksSetFactory;
    }

    @Override
    public Double calculate(List<BasketItems> shoppingCartItems) {
        List<BooksSet> setsOfDifferentBooks =
                booksSetFactory.getDifferentBooksSetsWithMaxTotalDiscount(shoppingCartItems);

        double totalPrice =0.0;
        double setPrice =0.0;

        for (BooksSet booksSet:setsOfDifferentBooks){
            for (Book book:booksSet.getBooks()) {
                setPrice += book.getPrice();
            }

            setPrice = setPrice * (1.0 - (booksSet.getDiscount()/100.0));
            totalPrice +=setPrice;
            setPrice = 0;
        }

        return totalPrice;
    }
}

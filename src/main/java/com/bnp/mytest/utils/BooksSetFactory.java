package com.bnp.mytest.utils;

import com.bnp.mytest.models.BasketItems;
import com.bnp.mytest.models.Book;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BooksSetFactory {

    List<BooksSetDiscount> discounts;

    public BooksSetFactory(List<BooksSetDiscount> discounts){
        this.discounts = discounts;
    }


    public List<BooksSet> getDifferentBooksSetsWithMaxTotalDiscount(List<BasketItems> basketItems) {

        List<BooksSet> optimizeSetList;

        optimizeSetList = getBestCombinationBooksSets(basketItems);

        return optimizeSetList;
    }

    private List<BooksSet> getBestCombinationBooksSets(List<BasketItems> basketItems) {
        List<List<BooksSet>> differentBooksSetsCombinations = new ArrayList<>();

        for (int i = basketItems.size();i>=1;i--){
            differentBooksSetsCombinations.add(calculateDifferentBooksSetsByMaxSize(basketItems,i));
        }

        List<BooksSet> optimizeSetList;

        if(differentBooksSetsCombinations.size() > 1)
            optimizeSetList = selectBooksSetsWithMaxDiscount(differentBooksSetsCombinations);
        else
            optimizeSetList = differentBooksSetsCombinations.get(0);
        return optimizeSetList;
    }

    private List<BooksSet> calculateDifferentBooksSetsByMaxSize(List<BasketItems> basketItems, int maxSizeSet) {
        List<BasketItems> remainingBasketItems = cloneBasketItems(basketItems);
        List<BooksSet> setsOfDifferentBooks = new ArrayList<>();

        while (remainingBasketItems.size() > 0) {
            final BooksSet oneSetOfDifferentBooks = createNextSet(remainingBasketItems,maxSizeSet);
            setsOfDifferentBooks.add(oneSetOfDifferentBooks);
        }

        return setsOfDifferentBooks;
    }

    private BooksSet createNextSet(List<BasketItems> remainingBasketItems, int maxSizeSet) {
        HashSet<Book> books = new HashSet<>();

        for (BasketItems item:new ArrayList<>(remainingBasketItems)) {

            books.add(item.getBook());

            if (item.getQuantity() == 1)
                remainingBasketItems.remove(item);
            else
                item.changeQuantity(item.getQuantity() - 1);

            if (books.size() == maxSizeSet)
                break;
        }

        BooksSet booksSet = new BooksSet(books,getDiscount(books.size()));

        return booksSet;
    }

    private List<BooksSet> selectBooksSetsWithMaxDiscount(List<List<BooksSet>> booksSetsCombinations) {
        List<BooksSet> maxDiscountBooksSets = null;
        int maxBooksSetsDiscount = 0;
        int totalBooksSetsDiscount = 0;

        for (List<BooksSet> booksSets:booksSetsCombinations) {
            for (BooksSet booksSet:booksSets) {
                totalBooksSetsDiscount += booksSet.getDiscount();
            }

            if (maxBooksSetsDiscount < totalBooksSetsDiscount) {
                maxDiscountBooksSets = booksSets;
                maxBooksSetsDiscount = totalBooksSetsDiscount;
            }

            totalBooksSetsDiscount = 0;
        }

        return maxDiscountBooksSets;
    }


    private List<BasketItems> cloneBasketItems (List<BasketItems> basketItems){
        List<BasketItems> basketItemsCopy = new ArrayList<>();

        for (BasketItems item:basketItems) {
            basketItemsCopy.add(new BasketItems(item.getBook(), item.getQuantity()));
        }

        return basketItemsCopy;
    }

    private int getDiscount(int differentBooksCount){
        int defaultDiscount = 0;

        for (BooksSetDiscount discount:discounts){
            if (differentBooksCount == discount.getDifferentCopies())
                return discount.getDiscount();
        }

        return defaultDiscount;
    }
}

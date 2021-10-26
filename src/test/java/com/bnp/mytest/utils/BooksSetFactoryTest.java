package com.bnp.mytest.utils;

import com.bnp.mytest.basket.BasketItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BooksSetFactoryTest {

    BooksSetFactory booksSetFactory;

    @BeforeEach
    public void setup(){
        List<BooksSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();

        byDifferentCopiesDiscountList.add(new BooksSetDiscount(2,5));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(3,10));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(4,20));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(5,25));

        booksSetFactory = new BooksSetFactory(byDifferentCopiesDiscountList);
    }

    // extract one set of four books when cart items are one copy for first four books
    @Test
    public void extractOneSetOfFourBooks(){
        //Given
        List<BasketItems> shoppingCartItems = GivenABasketItems(1,1,1,1,0);
        //When
        List<BooksSet> booksSets = booksSetFactory.getDifferentBooksSetsWithMaxTotalDiscount(shoppingCartItems);
        //Then
        assertThat(booksSets.size(), is(1));
        assertThat(booksSets.get(0).getBooks().size(), is(4));
    }

    private List<BasketItems> GivenABasketItems(int quantityBookI, int quantityBookII, int quantityBookIII,
                                                           int quantityBookIV,int quantityBookV ){
        List<BasketItems> shoppingCartItems = new ArrayList<>();

        if (quantityBookI > 0)
            shoppingCartItems.add(new BasketItems(Catalog.GivenACleanArchitectureBook(),quantityBookI));

        if (quantityBookII > 0)
            shoppingCartItems.add(new BasketItems(Catalog.GivenAWorkingEffectivelyWithLegacyCodeBook(),quantityBookII));

        if (quantityBookIII > 0)
            shoppingCartItems.add(new BasketItems(Catalog.GivenACleanCodeBook(),quantityBookIII));

        if (quantityBookIV > 0)
            shoppingCartItems.add(new BasketItems(Catalog.GivenATestDrivenDevelopmentByExampleBook(),quantityBookIV));

        if (quantityBookV > 0)
            shoppingCartItems.add(new BasketItems(Catalog.GivenATheCleanCoderBook(),quantityBookV));

        return shoppingCartItems;
    }

}

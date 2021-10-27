package com.bnp.mytest.utils;

import com.bnp.mytest.models.BasketItems;
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
        List<BooksSetDiscount> differentCopiesDiscountList = new ArrayList<>();

        differentCopiesDiscountList.add(new BooksSetDiscount(2,5));
        differentCopiesDiscountList.add(new BooksSetDiscount(3,10));
        differentCopiesDiscountList.add(new BooksSetDiscount(4,20));
        differentCopiesDiscountList.add(new BooksSetDiscount(5,25));

        booksSetFactory = new BooksSetFactory(differentCopiesDiscountList);
    }

    @Test
    public void extractOneSetOfFourBooks(){
        //Given
        List<BasketItems> basketItems = GivenABasketItems(1,1,1,1,0);
        //When
        List<BooksSet> booksSets = booksSetFactory.getDifferentBooksSetsWithMaxTotalDiscount(basketItems);
        //Then
        assertThat(booksSets.size(), is(1));
        assertThat(booksSets.get(0).getBooks().size(), is(4));
    }

    private List<BasketItems> GivenABasketItems(int quantityFirstBook, int quantitySecondBook, int quantityThirdBook,
                                                           int quantityFourthBook,int quantityFifthBook ){
        List<BasketItems> basketItems = new ArrayList<>();

        if (quantityFirstBook > 0)
            basketItems.add(new BasketItems(Catalog.GivenACleanArchitectureBook(),quantityFirstBook));

        if (quantitySecondBook > 0)
            basketItems.add(new BasketItems(Catalog.GivenAWorkingEffectivelyWithLegacyCodeBook(),quantitySecondBook));

        if (quantityThirdBook > 0)
            basketItems.add(new BasketItems(Catalog.GivenACleanCodeBook(),quantityThirdBook));

        if (quantityFourthBook > 0)
            basketItems.add(new BasketItems(Catalog.GivenATestDrivenDevelopmentByExampleBook(),quantityFourthBook));

        if (quantityFifthBook > 0)
            basketItems.add(new BasketItems(Catalog.GivenATheCleanCoderBook(),quantityFifthBook));

        return basketItems;
    }

}

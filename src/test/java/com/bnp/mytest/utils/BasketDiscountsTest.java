package com.bnp.mytest.utils;

import com.bnp.mytest.basket.Basket;
import com.bnp.mytest.basket.PriceCalculator;
import com.bnp.mytest.book.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasketDiscountsTest {

    BooksSetFactory booksSetFactory;

    Basket basket;

    @BeforeEach
    public void setup(){
        List<BooksSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();

        byDifferentCopiesDiscountList.add(new BooksSetDiscount(2,5));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(3,10));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(4,20));
        byDifferentCopiesDiscountList.add(new BooksSetDiscount(5,25));

        BooksSetFactory booksSetFactory = new BooksSetFactory(byDifferentCopiesDiscountList);
        basket = new Basket(new PriceCalculator(booksSetFactory));
    }

    @Test
    public void oneCopy(){
        //Given
        Book CleanCode = Catalog.GivenACleanCodeBook();
        //When
        basket.add(CleanCode);
        //Then
        assertThat(basket.getTotalPrice(), is(50.0));

    }

    //2 copies of the same book , no discount

    @Test
    public void twoCopiesOfTheSameBook(){
        //Given
        Book CleanCode = Catalog.GivenACleanCodeBook();
        //When
        basket.add(CleanCode);
        basket.add(CleanCode);
        //Then
        assertThat(basket.getTotalPrice(), is(100.0));

    }

    //5% of discount for two different books

    @Test
    public void twoDifferentBooks(){
        //Given
        Book cleanCode = Catalog.GivenACleanCodeBook();
        Book cleanArchitecture = Catalog.GivenACleanArchitectureBook();
        //When
        basket.add(cleanCode);
        basket.add(cleanArchitecture);
        //Then
        assertThat(basket.getTotalPrice(), is(95.0));

    }

    //10% of discount for three different books

    @Test
    public void threeDifferentCopies(){
        //Given
        Book cleanCode = Catalog.GivenACleanCodeBook();
        Book cleanArchitecture = Catalog.GivenACleanArchitectureBook();
        Book testDrivenDevelopmentByExample = Catalog.GivenATestDrivenDevelopmentByExampleBook();
        //When
        basket.add(cleanCode);
        basket.add(cleanArchitecture);
        basket.add(testDrivenDevelopmentByExample);
        //Then
        assertThat(basket.getTotalPrice(), is(135.0));

    }

    //20% of discount for four different books

    @Test
    public void fourDifferentCopies(){
        //Given

        Book cleanCode = Catalog.GivenACleanCodeBook();
        Book cleanArchitecture = Catalog.GivenACleanArchitectureBook();
        Book testDrivenDevelopmentByExample = Catalog.GivenATestDrivenDevelopmentByExampleBook();
        Book workingEffectivelyWithLegacyCode = Catalog.GivenAWorkingEffectivelyWithLegacyCodeBook();
        //When
        basket.add(cleanCode);
        basket.add(cleanArchitecture);
        basket.add(testDrivenDevelopmentByExample);
        basket.add(workingEffectivelyWithLegacyCode);
        //Then
        assertThat(basket.getTotalPrice(), is(160.0));

    }

    //25% of discount for five different books

    @Test
    public void fiveDifferentCopies(){
        //Given

        Book cleanCode = Catalog.GivenACleanCodeBook();
        Book cleanArchitecture = Catalog.GivenACleanArchitectureBook();
        Book testDrivenDevelopmentByExample = Catalog.GivenATestDrivenDevelopmentByExampleBook();
        Book workingEffectivelyWithLegacyCode = Catalog.GivenAWorkingEffectivelyWithLegacyCodeBook();
        Book theCleanCoder = Catalog.GivenATheCleanCoderBook();
        //When
        basket.add(cleanCode);
        basket.add(cleanArchitecture);
        basket.add(testDrivenDevelopmentByExample);
        basket.add(workingEffectivelyWithLegacyCode);
        basket.add(theCleanCoder);
        //Then
        assertThat(basket.getTotalPrice(), is(187.50));
    }

    //10% of discount for 4 books and 3 are different

    @Test
    public void fourCopiesAndThreeAreDifferent(){
        //Given
        Book cleanCode = Catalog.GivenACleanCodeBook();
        Book cleanCodeII = Catalog.GivenACleanCodeBook();
        Book cleanArchitecture = Catalog.GivenACleanArchitectureBook();
        Book testDrivenDevelopmentByExample = Catalog.GivenATestDrivenDevelopmentByExampleBook();
        //When
        basket.add(cleanCode);
        basket.add(cleanCodeII);
        basket.add(cleanArchitecture);
        basket.add(testDrivenDevelopmentByExample);
        //Then
        assertThat(basket.getTotalPrice(), is(185.00));

    }

    //40% of discount for 2 sets of 4 different books

    @Test
    public void twoSetOfFourDifferentCopies(){
        //Given
        Book cleanCode = Catalog.GivenACleanCodeBook();
        Book cleanCodeII = Catalog.GivenACleanCodeBook();
        Book cleanArchitecture = Catalog.GivenACleanArchitectureBook();
        Book cleanArchitectureII = Catalog.GivenACleanArchitectureBook();
        Book testDrivenDevelopmentByExample = Catalog.GivenATestDrivenDevelopmentByExampleBook();
        Book testDrivenDevelopmentByExampleII = Catalog.GivenATestDrivenDevelopmentByExampleBook();
        Book workingEffectivelyWithLegacyCode = Catalog.GivenAWorkingEffectivelyWithLegacyCodeBook();
        Book theCleanCoder = Catalog.GivenATheCleanCoderBook();
        //When
        basket.add(cleanCode);
        basket.add(cleanCodeII);
        basket.add(cleanArchitecture);
        basket.add(cleanArchitectureII);
        basket.add(testDrivenDevelopmentByExample);
        basket.add(testDrivenDevelopmentByExampleII);
        basket.add(workingEffectivelyWithLegacyCode);
        basket.add(theCleanCoder);
        //Then
        assertThat(basket.getTotalPrice(), is(320.00));

    }
}

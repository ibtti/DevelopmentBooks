package com.bnp.mytest.basket;

import com.bnp.mytest.book.Book;

public class BasketItems {
    private Book book;
    private int quantity;

    public BasketItems(Book book, int quantity){
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }
}

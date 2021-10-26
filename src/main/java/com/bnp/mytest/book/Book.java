package com.bnp.mytest.book;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String date;
    private int price;


    public Book() {
    }

    public Book(String name, String author, String date) {
        this.title = name;
        this.author = author;
        this.date = date;
        this.price=50;
    }

    public Book(Long id, String name, String author, String date) {
        this.id = id;
        this.title = name;
        this.author = author;
        this.date = date;
        this.price=50;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Book)) return false;

        Book other = (Book) o;
        return this.title == other.getTitle();
    }

    public int hashCode(){
        return title.hashCode();
    }
}

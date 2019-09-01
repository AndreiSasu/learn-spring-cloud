package com.example.bookservice;

public class Book {

    public Book(Long id, String title, String author) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String author;
    private String title;

}

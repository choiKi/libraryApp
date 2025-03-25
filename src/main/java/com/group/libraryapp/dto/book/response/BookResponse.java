package com.group.libraryapp.dto.book.response;

import com.group.libraryapp.domain.book.Book;

public class BookResponse {


    private long id;
    private String name;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.name = book.getName();
    }

    public BookResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}

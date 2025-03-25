package com.group.libraryapp.dto.book.response;

public class BookLoanResponse {

    private int userID;
    private String bookName;
    private boolean isReturn;

    public int getUserID() {
        return userID;
    }

    public boolean getIsReturn() {
        return isReturn;
    }

    public String getBookName() {
        return bookName;
    }
}

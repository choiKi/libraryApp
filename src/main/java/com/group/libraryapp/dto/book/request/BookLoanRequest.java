package com.group.libraryapp.dto.book.request;

public class BookLoanRequest {


    private int userID;
    private String userName;
    private String bookName;
    private boolean isReturn;

    public String getBookName() {
        return bookName;
    }

    public int getUserID() {
        return userID;
    }

    public boolean getIsReturn() {
        return isReturn;
    }

    public String getUserName() {
        return userName;
    }
}

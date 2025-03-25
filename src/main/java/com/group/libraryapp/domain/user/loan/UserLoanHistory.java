package com.group.libraryapp.domain.user.loan;


import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

//    @Column(nullable = false, name = "user_ID")
    @ManyToOne
    private User user;

    @Column(nullable = false, name = "book_name")
    private String bookName;

    @Column(nullable = false, name = "is_return")
    private boolean isReturn;

    protected UserLoanHistory() {}

    public UserLoanHistory(User user, String bookName) {
        if (user == null) {
            throw new IllegalArgumentException("사용자 이름을 입력하세요");
        }
        if (bookName == null || bookName.isBlank()) {
            throw new IllegalArgumentException("대여할 책 이름을 입력해주새요");
        }
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn() {
        this.isReturn = true;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean getIsReturn() {
        return isReturn;
    }
}

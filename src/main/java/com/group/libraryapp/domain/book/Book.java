package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 255, name = "name")
    private String name;

    protected Book() {}

    public Book(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("책 제목을 입력해주세요.");
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

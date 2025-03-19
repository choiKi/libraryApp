package com.group.libraryapp.domain.user;

public class User {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("이름을 잘못 입력했습니다 :", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}

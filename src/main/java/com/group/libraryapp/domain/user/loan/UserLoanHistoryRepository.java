package com.group.libraryapp.domain.user.loan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    Optional<UserLoanHistory> findByUser_idAndBookName(long userId, String bookName);
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
}

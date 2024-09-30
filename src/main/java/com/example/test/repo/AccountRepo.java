package com.example.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entitys.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}

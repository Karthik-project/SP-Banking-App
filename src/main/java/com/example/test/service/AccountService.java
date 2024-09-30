package com.example.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.entitys.Account;
import com.example.test.repo.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepository;

	 public Account createAccount(Account account) {
	        return accountRepository.save(account);
	    }

	    public Optional<Account> getAccount(long id) {
	        return accountRepository.findById(id);
	    }

	    public Account deposit(long id, long amount) {
	        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
	        account.setBalance(account.getBalance() + amount);
	        return accountRepository.save(account);
	    }

	    public Account withdraw(long id, long amount) {
	        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
	        if (account.getBalance() < amount) {
	            throw new RuntimeException("Insufficient funds");
	        }
	        account.setBalance(account.getBalance() - amount);
	        return accountRepository.save(account);
	    }

	
	
	
}

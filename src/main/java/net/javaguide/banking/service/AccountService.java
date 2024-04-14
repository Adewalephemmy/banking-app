package net.javaguide.banking.service;

import java.util.List;

import net.javaguide.banking.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdrawl (Long id, double amount);
	
	List<AccountDto> getAllAccount();
	
	void deleteAccount(Long id);

}

package net.javaguide.banking.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import net.javaguide.banking.Entity.Account;
import net.javaguide.banking.Mapper.AccountMapper;
import net.javaguide.banking.dto.AccountDto;
import net.javaguide.banking.repository.AccountRepository;
import net.javaguide.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private  AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account  saveAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.
				findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
		return AccountMapper.mapToAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.
				findById(id).orElseThrow(() -> new RuntimeException("Account does not exits"));
		
		double total = account.getBalance()+ amount;
		account.setBalance(total);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}


	@Override
	public AccountDto withdrawl(Long id, double amount) {
	    // Find the account by id or throw exception if not found
	    Account account = accountRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Account does not exist"));

	    // Check if the account has sufficient balance
	    if (account.getBalance() < amount) {
	        throw new RuntimeException("Insufficient Balance");
	    }

	    // Deduct the amount from the account balance
	    double newBalance = account.getBalance() - amount;
	    account.setBalance(newBalance);

	    // Save the updated account entity
	    Account savedAccount = accountRepository.save(account);

	    // Return the DTO for the updated account
	    return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public List<AccountDto> getAllAccount() {
		// TODO Auto-generated method stub
		List<Account >accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.
				mapToAccountDto(account)).collect(Collectors.toList());
	}


	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		accountRepository.deleteById(id);
		
	}

		
}

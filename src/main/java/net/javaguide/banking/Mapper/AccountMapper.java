package net.javaguide.banking.Mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.javaguide.banking.Entity.Account;
import net.javaguide.banking.dto.AccountDto;

@Data
@AllArgsConstructor
public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getAccountHolderName(),
				accountDto.getBalance(),
				accountDto.getId()
				);
		
		return account;
	}

	public static AccountDto mapToAccountDto (Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountDto;
	}
}

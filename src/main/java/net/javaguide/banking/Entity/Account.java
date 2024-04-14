package net.javaguide.banking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@AllArgsConstructor
@Table (name = "accounts")
@Entity
public class Account {
	
	public Account(String accountHolderName, double balance, Long id) {
		// TODO Auto-generated constructor stub
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.id = id;
		
	}
	 public Account() {
	        // You can initialize default values or leave it empty
	    }
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	private double balance;
	
	public long getId() 
	{
		return id;
	}
	
	public String getAccountHolderName() 
	{
		return accountHolderName;
	}
	
	public double getBalance() 
	{
		return balance;
	}
	public double setBalance(double total) 
	{
		return balance;
	}
	
}

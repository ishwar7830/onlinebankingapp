package com.OnlineBankingapp.dto;

public class OnlineaccountsDto {
	 private Long  id;
	 
	 private String accountHoldername;
	 
	 public OnlineaccountsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OnlineaccountsDto(Long id, String accountHoldername, double balance) {
		super();
		this.id = id;
		this.accountHoldername = accountHoldername;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHoldername() {
		return accountHoldername;
	}

	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	private double balance;

}

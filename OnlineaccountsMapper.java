package com.OnlineBankingapp.mapper;

import com.OnlineBankingapp.dto.OnlineaccountsDto;
import com.OnlineBankingapp.entity.Onlineaccounts;

public class OnlineaccountsMapper {
	public static Onlineaccounts mapToOnlineaccounts(OnlineaccountsDto onlineaccountsDto ) {
		Onlineaccounts onlineaccounts =new Onlineaccounts(
				onlineaccountsDto.getId(),
				onlineaccountsDto.getAccountHoldername(),
				onlineaccountsDto.getBalance()
				);
		return onlineaccounts;
	}
	public static OnlineaccountsDto mapToOnlineaccountsDto(Onlineaccounts onlineaccounts) {
		OnlineaccountsDto	onlineaccountsDto=new OnlineaccountsDto(
				onlineaccounts.getId(),
				onlineaccounts.getAccountHoldername(),
				onlineaccounts.getBalance()
				
				);
		return onlineaccountsDto;
	}

}

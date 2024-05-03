package com.OnlineBankingapp.service;

import java.util.List;

import com.OnlineBankingapp.dto.OnlineaccountsDto;


public interface OnlineaccountsService {
      OnlineaccountsDto createOnlineaccounts(OnlineaccountsDto onlineaccounts);
      OnlineaccountsDto getOnlineaccountsById(Long id);
      OnlineaccountsDto deposit(Long id,double amount);
      OnlineaccountsDto withdraw(Long id,double amount);
      List<OnlineaccountsDto>getAllOnlineaccounts();
       public  void deleteOnlineaccounts(Long id); 
    	
    
}

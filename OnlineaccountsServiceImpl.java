package com.OnlineBankingapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.OnlineBankingapp.dto.OnlineaccountsDto;
import com.OnlineBankingapp.entity.Onlineaccounts;
import com.OnlineBankingapp.mapper.OnlineaccountsMapper;
import com.OnlineBankingapp.repository.OnlineaccountsRepository;

import com.OnlineBankingapp.service.OnlineaccountsService;
@Service
public class OnlineaccountsServiceImpl implements OnlineaccountsService {
	
    private OnlineaccountsRepository onlineaccountsRepository;
	public OnlineaccountsServiceImpl(OnlineaccountsRepository onlineaccountsRepository) {
		super();
		this.onlineaccountsRepository = onlineaccountsRepository;
	}
	@Override
	public OnlineaccountsDto createOnlineaccounts(OnlineaccountsDto onlineaccountsDto) {
		
		Onlineaccounts onlineaccounts=OnlineaccountsMapper.mapToOnlineaccounts(onlineaccountsDto);
		Onlineaccounts savedOnlineaccounts=onlineaccountsRepository.save(onlineaccounts);
		return OnlineaccountsMapper.mapToOnlineaccountsDto(savedOnlineaccounts);
	}
	
	@Override
	public OnlineaccountsDto getOnlineaccountsById(Long id) {
		Onlineaccounts onlineaccounts=onlineaccountsRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		return OnlineaccountsMapper.mapToOnlineaccountsDto(onlineaccounts);
	}
	@Override
	public    OnlineaccountsDto deposit(Long id,double amount) {
		Onlineaccounts onlineaccounts=onlineaccountsRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		double totolBalance=onlineaccounts.getBalance()+amount;
		onlineaccounts.setBalance(totolBalance);
		Onlineaccounts savedOnlineaccounts=onlineaccountsRepository.save(onlineaccounts);
		return OnlineaccountsMapper.mapToOnlineaccountsDto(savedOnlineaccounts);
	}
	@Override
	public OnlineaccountsDto withdraw(Long id, double amount) {
		Onlineaccounts onlineaccounts=onlineaccountsRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		if(onlineaccounts.getBalance()<amount) {
			throw new RuntimeException("Insufficient Balance");
		}
		double totolBalance=onlineaccounts.getBalance()-amount;
		onlineaccounts.setBalance(totolBalance);
		Onlineaccounts savedOnlineaccounts=	onlineaccountsRepository.save(onlineaccounts);
		return OnlineaccountsMapper.mapToOnlineaccountsDto(savedOnlineaccounts);
	}
	@Override
	public List<OnlineaccountsDto> getAllOnlineaccounts() {
		return 	onlineaccountsRepository.findAll().stream().map((onlineaccounts)->OnlineaccountsMapper.mapToOnlineaccountsDto(onlineaccounts)).collect(Collectors.toList());
		
	}
	@Override
	public void deleteOnlineaccounts(Long id) {
		Onlineaccounts onlineaccounts=onlineaccountsRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		onlineaccountsRepository.delete(onlineaccounts);
	}
	
	
}

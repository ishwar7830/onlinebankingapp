package com.OnlineBankingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineBankingapp.dto.OnlineaccountsDto;
import com.OnlineBankingapp.service.OnlineaccountsService;

@RestController
@RequestMapping("/api/onlineaccounts")
public class OnlineaccountsController {
	private OnlineaccountsService onlineaccountsService;
	
	public OnlineaccountsController(OnlineaccountsService onlineaccountsService) {
		super();
		this.onlineaccountsService = onlineaccountsService;
	}
	//add account  rest api
    @PostMapping
	public ResponseEntity<OnlineaccountsDto> addOnlineaccounts(@RequestBody OnlineaccountsDto onlineaccountsDto){
    	System.out.println("OnlineaccountsDto");
     return new ResponseEntity<>(onlineaccountsService.createOnlineaccounts(onlineaccountsDto),HttpStatus.CREATED);
}
    @	GetMapping("/{id}")
    public ResponseEntity<OnlineaccountsDto> getOnlineaccountsById(@PathVariable Long id){
    	
    	OnlineaccountsDto  onlineaccountsDto=onlineaccountsService.getOnlineaccountsById(id);
    	
    	return ResponseEntity.ok(onlineaccountsDto);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<OnlineaccountsDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double>request){
    	Double amount=request.get("amount");
    	OnlineaccountsDto onlineaccountsDto= 	onlineaccountsService.deposit(id,request.get("amount"));
    	return ResponseEntity.ok(onlineaccountsDto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<OnlineaccountsDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request){
    	Double amount=request.get("amount");
    	OnlineaccountsDto onlineaccountsDto= 	onlineaccountsService.withdraw(id,request.get("amount"));
    	return ResponseEntity.ok(onlineaccountsDto);
    }
    @GetMapping
    public ResponseEntity<List<OnlineaccountsDto>>getAllOnlineaccounts(){
    	List<OnlineaccountsDto> onlineaccountsDto=	onlineaccountsService.getAllOnlineaccounts();
    	return ResponseEntity.ok(onlineaccountsDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteOnlineaccounts(@PathVariable Long id){
    	onlineaccountsService.deleteOnlineaccounts(id);
    	return ResponseEntity.ok("Account deleted sucessfully !!");
    }
    
}

package com.upbank.controllers;


import com.upbank.domain.deposit.Deposit;
import com.upbank.dtos.DepositDTO;
import com.upbank.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposits")
public class DepositController
{
    @Autowired
    private DepositService depositService;

    @PostMapping
    public ResponseEntity<Deposit> createDeposit(@RequestBody DepositDTO deposit) throws Exception {
        Deposit newDeposit = this.depositService.createDeposit(deposit);
        return new ResponseEntity<>(newDeposit, HttpStatus.OK);

    }
}

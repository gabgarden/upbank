package com.upbank.services;

import com.upbank.domain.deposit.Deposit;
import com.upbank.domain.user.User;
import com.upbank.dtos.DepositDTO;
import com.upbank.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class DepositService
{
    @Autowired
    private UserService userService;

    @Autowired
    private DepositRepository depositRepository;


    public Deposit createDeposit(DepositDTO deposit) throws Exception {

        User accountHolder = this.userService.findUserById(deposit.accountHolderId());

        Deposit newDeposit = new Deposit();
        newDeposit.setAmount(deposit.value());
        newDeposit.setAccountHolder(accountHolder);
        newDeposit.setTimestamp(LocalDateTime.now());

        accountHolder.setBalance(accountHolder.getBalance().add(deposit.value()));

        this.depositRepository.save(newDeposit);
        this.userService.saveUser(accountHolder);

        return newDeposit;

    }
}

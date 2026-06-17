package com.example.demoAutowire.service;

import com.example.demoAutowire.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankServiceImpl implements BankService{


    private BankRepository repository;

    @Autowired
    public BankServiceImpl(@Qualifier("secondaryBankRepositoryImpl")BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public void withdraw(int accountNumber, double amount) {
        log.info("withdraw...");
        repository.withdrawFromDB(accountNumber, amount);
    }

    @Override
    public void deposit(int accountNumber, double amount) {
        log.info("deposit...");
        repository.depositToDB(accountNumber, amount);
    }

    @Override
    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        log.info("transfer...");
        repository.transferToDB(fromAccountNumber, toAccountNumber, amount);
    }
}

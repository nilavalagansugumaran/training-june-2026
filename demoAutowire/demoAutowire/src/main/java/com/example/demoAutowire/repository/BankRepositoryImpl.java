package com.example.demoAutowire.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class BankRepositoryImpl implements BankRepository {

    @Override
    public void withdrawFromDB(int accountNumber, double amount) {
        log.info("withdrawFromDB accountNumber = {}, amount = {}", accountNumber, amount);
    }

    @Override
    public void depositToDB(int accountNumber, double amount) {
        log.info("depositToDB accountNumber = {}, amount = {}", accountNumber, amount);
    }

    @Override
    public void transferToDB(int fromAccountNumber, int toAccountNumber, double amount) {
        log.info("transferToDB fromAccountNumber = {},, toAccountNumber = {} amount = {}", fromAccountNumber, toAccountNumber, amount);
    }
}

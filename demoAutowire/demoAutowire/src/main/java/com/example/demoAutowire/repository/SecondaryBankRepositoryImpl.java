package com.example.demoAutowire.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class SecondaryBankRepositoryImpl implements BankRepository {

    @Override
    public void withdrawFromDB(int accountNumber, double amount) {
        log.info("Secondary withdrawFromDB accountNumber = {}, amount = {}", accountNumber, amount);
    }

    @Override
    public void depositToDB(int accountNumber, double amount) {
        log.info("Secondary depositToDB accountNumber = {}, amount = {}", accountNumber, amount);
    }

    @Override
    public void transferToDB(int fromAccountNumber, int toAccountNumber, double amount) {
        log.info("Secondary transferToDB fromAccountNumber = {},, toAccountNumber = {} amount = {}", fromAccountNumber, toAccountNumber, amount);
    }
}

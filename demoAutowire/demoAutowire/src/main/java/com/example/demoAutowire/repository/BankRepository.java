package com.example.demoAutowire.repository;

public interface BankRepository {

    void withdrawFromDB(int accountNumber, double amount);
    void depositToDB(int accountNumber, double amount);
    void transferToDB(int fromAccountNumber, int toAccountNumber, double amount);
}

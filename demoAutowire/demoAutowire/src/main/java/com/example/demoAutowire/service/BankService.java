package com.example.demoAutowire.service;

public interface BankService {

    void withdraw(int accountNumber, double amount);
    void deposit(int accountNumber, double amount);
    void transfer(int fromAccountNumber, int toAccountNumber, double amount);
}

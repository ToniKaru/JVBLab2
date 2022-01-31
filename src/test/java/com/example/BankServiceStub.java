package com.example;

public class BankServiceStub implements BankService     {

    @Override
    public void pay(String id, double amount) throws RuntimeException {
        throw new RuntimeException();
    }
}

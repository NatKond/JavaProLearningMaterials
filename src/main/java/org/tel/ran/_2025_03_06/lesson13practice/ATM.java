package org.tel.ran._2025_03_06.lesson13practice;

public class ATM {

    public double viewAccountBalance(Account account) {
        return account.getBalance();
    }

    public void depositToAccount(Account account, int amount) {
        account.deposit(amount);
    }

    public void withdrawFromAccount(Account account, int amount) {
        account.withdraw(amount);
    }
}

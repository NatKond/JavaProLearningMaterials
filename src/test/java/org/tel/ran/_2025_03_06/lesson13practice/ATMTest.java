package org.tel.ran._2025_03_06.lesson13practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ATMTest {

    private final Account ACCOUNT = new Account("John Doh", 100);

    private static final ATM ATM = new ATM();

    @Test
    void viewAccountBalanceTest() {
        // given
        double expected = 100;
        // when
        double actual = ATM.viewAccountBalance(ACCOUNT);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void withdrawFromAccountPositiveTest() {
        // given
        Account expected = new Account("John Doh", 0);
        //when
        ATM.withdrawFromAccount(ACCOUNT, 100);
        // then
        Assertions.assertEquals(expected, ACCOUNT);
    }

    @Test
    void withdrawFromAccountNegativeTest() {
        Assertions.assertThrows(InsufficientFundException.class, () -> ATM.withdrawFromAccount(ACCOUNT, 1000));
    }

    @Test
    void depositToAccountPositiveTest() {
        // given
        Account expected = new Account("John Doh", 200);
        //when
        ATM.depositToAccount(ACCOUNT, 100);
        // then
        Assertions.assertEquals(expected, ACCOUNT);
    }

    @Test
    void depositToAccountNegativeTest() {
        Assertions.assertThrows(InvalidAmountException.class, () -> ACCOUNT.deposit(-100));
    }
}
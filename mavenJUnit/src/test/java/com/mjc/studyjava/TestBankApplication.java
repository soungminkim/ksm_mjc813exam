package com.mjc.studyjava;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestBankApplication {
    @Test
    public void TestAccount() {
        Account acc1 = new Account("11111", "홍길동");
        assertThat(acc1.getAccountNumber()).isEqualTo("11111");
        assertThat(acc1.getAccountName()).isEqualTo("홍길동");
        assertThat(acc1.getBalance()).isEqualTo(0);

        Account acc2 = new Account("2222222", "이순신");
        assertThat(acc2.getAccountNumber()).isEqualTo("2222222");
        assertThat(acc2.getAccountName()).isEqualTo("이순신");
        assertThat(acc2.getBalance()).isEqualTo(0);

        acc1.addMoney(100);
        assertThat(acc1.getBalance()).isEqualTo(100);
        acc1.addMoney(200);
        assertThat(acc1.getBalance()).isEqualTo(300);
        acc1.addMoney(1000);
        assertThat(acc1.getBalance()).isEqualTo(1300);;
        acc1.subMoney(200);
        assertThat(acc1.getBalance()).isEqualTo(1100);
        acc1.subMoney(500);
        assertThat(acc1.getBalance()).isEqualTo(600);

        /*
        balance 에 -음수 값이나 백만 초과 되는 값 저장하는 테스트 만들어 보세요
         */
    }

    @Test
    public void TestBankApplication() {
        BankApplication ba = new BankApplication();
        assertThat(ba.getAccountSize()).isEqualTo(0);
        ba.addAccount("12345678", "김길동", 100);
        ba.addAccount("24680246", "홍길동", 200);
        ba.addAccount("35791357", "이길명", 300);
        assertThat(ba.getAccountSize()).isEqualTo(3);
        assertThat(ba.getBalanceFromAccountNumber("12345678")).isEqualTo(100);
        assertThat(ba.getBalanceFromAccountNumber("24680246")).isEqualTo(200);
        assertThat(ba.getBalanceFromAccountNumber("35791357")).isEqualTo(300);
        ba.deposit("12345678", 1000);
        ba.deposit("24680246", 2000);
        ba.deposit("35791357", 3000);
        assertThat(ba.getBalanceFromAccountNumber("12345678")).isEqualTo(1100);
        assertThat(ba.getBalanceFromAccountNumber("24680246")).isEqualTo(2200);
        assertThat(ba.getBalanceFromAccountNumber("35791357")).isEqualTo(3300);
        ba.draw("12345678", 500);
        ba.draw("24680246", 600);
        ba.draw("35791357", 700);
        assertThat(ba.getBalanceFromAccountNumber("12345678")).isEqualTo(600);
        assertThat(ba.getBalanceFromAccountNumber("24680246")).isEqualTo(1600);
        assertThat(ba.getBalanceFromAccountNumber("35791357")).isEqualTo(2600);
    }
}

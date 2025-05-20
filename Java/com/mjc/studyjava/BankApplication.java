package com.mjc.studyjava;

import java.util.Scanner;

public class BankApplication {
//    BankApplication : 동작 { 계좌생성(addAccount), 계좌목록(printAccounts)
//            , 예금(deposit), 출금(draw), 종료(exit) }

    /**
     * 계좌정보 배열 100개, 나중에는 ArrayList 로 변환해 보세요.
     */
    private Account[] accounts = new Account[100];

    /**
     * Account 배열의 실제 길이를 리턴한다.
     * 즉 전체 100개 이지만 3개만 있을경우에는 3을 리턴한다.
     *
     * @return
     */
    public int getAccountSize() {
        int count = 0;
        for (Account account : accounts) {
            if (account != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * 계좌번호, 계좌주, 초기금액으로 Account 클래스를 생성한다.
     * 생성된 계좌정보를 멤버변수 배열에 추가한다.
     */
    public void addAccount(String accountNumber, String accountName, int money) {
        Account account = new Account(accountNumber, accountName, money);

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                System.out.println("결과: 계좌가 생성되었습니다.");
                break;
            }
        }

    }

    /**
     * 계좌정보 배열의 내용을 출력한다.
     */
    public void printAccounts() {
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] != null) {
                System.out.printf("%s \t %s \t %d \n"
                        , this.accounts[i].getAccountNumber()
                        , this.accounts[i].getAccountName()
                        , this.accounts[i].getBalance()
                );
            }
        }
    }

    /**
     * 계좌정보배열에서 accountNumber 가 맞는 계좌번호를 찾아서 money 돈을 계좌금액에 더한다.
     *
     * @param accountNumber
     * @param money
     */
    public void deposit(String accountNumber, int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i].addMoney(money);
                break;
            }
        }
    }

    /**
     * 계좌정보배열에서 accountNumber 가 맞는 계좌번호를 찾아서 money 돈을 계좌금액에서 뺀다.
     *
     * @param accountNumber
     * @param money
     */
    public void draw(String accountNumber, int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i].subMoney(money);
                break;
            }
        }

    }

    /**
     * JUnit 단위테스트를 위한 메소드
     * accountNumber 계좌번호에 해당하는 계좌금액을 리턴한다.
     *
     * @param accountNumber
     * @return
     */
    public int getBalanceFromAccountNumber(String accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i].getBalance();
            }
        }
        return 0;
    }

    /*
    키보드 입력하고 명령어 판별하여 1,2,3,4,5 번에 따라서 생성, 목록, 예금, 출금, 종료한다
    생성메뉴는 계좌번호, 계좌주, 초기금액을 입력 받고 결과를 출력한다.
    목록메뉴는 계좌들을 모두 출력한다.
    예금메뉴는 계좌번호, 입금액을 입력 받아서 계좌번호 계좌금액에 더한다.
    출금메뉴는 계좌번호, 입금액을 입력 받아서 계좌번호 계좌금액에서 뺀다.
    종료메뉴는 프로그램을 종료한다. 종료하기 전까지는 무한루프이다.
     */
    public static void main(String[] args) {
        BankApplication bank = new BankApplication();
        Scanner sc = new Scanner(System.in);

        String accountNumber;
        String accountName;
        int money;

        while (true) {
            int scc = 0;
            System.out.println("-------------------------------------");
            System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택> ");
            scc = sc.nextInt();

            if (scc == 5) {
                System.out.println("프로그램 종료");
                break;
            }

            switch (scc) {
                case 1:
                    System.out.println("-------");
                    System.out.println("계좌생성");
                    System.out.println("-------");

                    System.out.print("계좌 번호: ");
                    accountNumber = sc.next();

                    System.out.print("계좌 주: ");
                    accountName = sc.next();

                    System.out.print("초기입금액: ");
                    money = sc.nextInt();
                    bank.addAccount(accountNumber, accountName, money);
                    break;

                case 2:
                    System.out.println("-------");
                    System.out.println("계좌목록");
                    System.out.println("-------");
                    bank.printAccounts();
                    break;

                case 3:
                    System.out.println("---");
                    System.out.println("예금");
                    System.out.println("---");

                    System.out.print("계좌 번호: ");
                    accountNumber = sc.next();

                    System.out.print("예금액: ");
                    money = sc.nextInt();

                    bank.deposit(accountNumber, money);
                    break;

                case 4:
                    System.out.println("---");
                    System.out.println("출금");
                    System.out.println("---");

                    System.out.print("계좌번호: ");
                    accountNumber = sc.next();

                    System.out.print("출금액: ");
                    money = sc.nextInt();
                    bank.draw(accountNumber, money);
                    break;
                default:
                    System.out.println("잘못된 입력 입니다. 다시 입력해주세요.(1~5)");
            }
        }
    }
}

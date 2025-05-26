package com.mjc.studyjava;

public class Account {
    //    Account : 속성{ 계좌번호(accountNumber), 계좌주(accountName), 금액(money) }
    //    동작{ 생성자(계좌번호,계좌주), addMoney(금액), subMoney(금액) }
    private String accountNumber;
    private String accountName;
    private int money;

    /**
     * Account 비기본 생성자 (계좌번호, 계좌주)
     *
     * @param accountNumber
     * @param accountName
     */
    public Account(String accountNumber, String accountName) {
        this(accountNumber, accountName, 0);
    }
    /**
     * Account 비기본 생성자 (계좌번호, 계좌주, 초기금액)
     * @param accountNumber
     */
    public Account(String accountNumber, String accountName, int money) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.money = money;
    }

    /**
     * m 을 금액에 더한다.
     * @param m
     */
    void addMoney(int m) {
        this.money += m;
    }
    /**
     * m 을 금액에서 뺀다.
     * @param m
     */
    void subMoney(int m) {
        this.money -= m;
    }

    /**
     * 계좌번호 정보를 가져온다.
     * @return
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }
    /**
     * 계좌번호 정보를 저장한다.
     * @param accoutNumber
     */
    public void setAccountNumber(String accoutNumber) {
        this.accountNumber = accoutNumber;
    }

    /**
     * 계좌주 정보를 가져온다.
     * @return
     */
    public String getAccountName() {
        return this.accountName;
    }
    /**
     * 계좌주 정보를 저장한다.
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 금액 정보를 가져온다.
     * @return
     */
    public int getBalance() {
        return money;
    }

    /**
     * 금액 정보를 저장한다.
     * @param money
     */
    public void setBalance(int money) {
        this.money = money;
    }
}
package com.mjc.studyjava;

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
     * @return
     */
    public int getAccountSize() {
        return 0;
    }

    /**
     * 계좌번호, 계좌주, 초기금액으로 Account 클래스를 생성한다.
     * 생성된 계좌정보를 멤버변수 배열에 추가한다.
     * @param accountNumber
     * @param accountName
     * @param money
     * @return
     */
    public void addAccount(String accountNumber, String accountName, int money) {
    }

    /**
     * 계좌정보 배열의 내용을 출력한다.
     */
    public void printAccounts() {
        for ( int i = 0; i < this.accounts.length; i++ ) {
            if( this.accounts[i] != null ) {
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
     * @param accountNumber
     * @param money
     */
    public void deposit(String accountNumber, int money) {

    }

    /**
     * 계좌정보배열에서 accountNumber 가 맞는 계좌번호를 찾아서 money 돈을 계좌금액에서 뺀다.
     * @param accountNumber
     * @param money
     */
    public void draw(String accountNumber, int money) {

    }

    /*
    키보드 입력하고 명령어 판별하여 1,2,3,4,5 번에 따라서 생성, 목록, 예금, 출금, 종료한다
    생성메뉴는 계좌번호, 계좌주, 초기금액을 입력 받고 결과를 출력한다.
    목록메뉴는 계좌들을 모두 출력한다.
    예금메뉴는 계좌번호, 입금액을 입력 받아서 계좌번호 계좌금액에 더한다.
    출금메뉴는 계좌번호, 입금액을 입력 받아서 계좌번호 계좌금액에서 뺀다.
    종료메뉴는 프로그램을 종료한다. 종료하기 전까지는 무한루프이다.
     */

    /**
     * JUnit 단위테스트를 위한 메소드
     * accountNumber 계좌번호에 해당하는 계좌금액을 리턴한다.
     * @param accountNumber
     * @return
     */
    public int getBalanceFromAccountNumber(String accountNumber) {
        return 0;
    }
}

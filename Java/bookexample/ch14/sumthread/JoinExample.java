package bookexample.ch14.sumthread;

public class JoinExample {
    public static void main(String[] args) {
        SumTherad sumTherad = new SumTherad();
        sumTherad.start();
        try{
            sumTherad.join();
        } catch (InterruptedException e){
        }
        System.out.println("1~100 합: "+ sumTherad.getSum());
    }
}

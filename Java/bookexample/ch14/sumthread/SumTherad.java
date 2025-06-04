package bookexample.ch14.sumthread;

public class SumTherad extends Thread{
    private long sum;

    public long getSum() {
        return sum;
    }
    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(sum - i + " + " + i + " = " + sum);
        }
    }
}

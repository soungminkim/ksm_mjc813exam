package bookexample.ch14.yield;

public class YieldExample {
    public static void main(String[] args) {
        WorkThread workThreadA = new WorkThread("WorkThreadA");
        WorkThread workThreadB = new WorkThread("WorkThreadB");
        workThreadA.start();
        workThreadB.start();

        try{ Thread.sleep(5000); } catch (Exception e){}
        workThreadA.work = false;

        try{ Thread.sleep(10000); } catch (Exception e) {}
        workThreadB.work = true;
    }
}

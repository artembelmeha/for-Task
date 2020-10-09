//You need to create Accountant class with a static sum(...) method that takes two
// parameters of type int and returns their sum. Use ParallelCalculator for this.
// The sum(...) method doesn't throw any checked exceptions.
//The sum must be evaluated in a separate thread  (please, do not call run() method
// of ParallelCalculator. Use start() method on object of type Thread).
//Using Thread.sleep() method is unwelcomed in this task.


public class Accountant {
    public static int sum(int x, int y)  {
        ParallelCalculator parallelCalculator = new ParallelCalculator((a,b)->a+b,x,y);
        Thread thread = new Thread(parallelCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e){

        }
        return parallelCalculator.result;
    }

    public static void main(String[] args) {
        System.out.println(Accountant.sum(115,2095));
        System.out.println(4444);
    }
}

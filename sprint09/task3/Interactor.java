import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Interactor {
    int x;

    public static void main(String[] args) {
        threadExample.threadRun();
    }
    public void serve(UnaryOperator<Integer> uo, int initializer)throws InterruptedException{
        synchronized (this) {
            System.out.println("Serving thread running");
            x = uo.apply(initializer);
            System.out.println("Serving thread initializes the key");
            System.out.println("key = " + x);
            this.notify();
            this.wait();
        }
        System.out.println("Serving thread resumed");
    }

    public void consume(BinaryOperator<Integer> bo, int operand2)throws InterruptedException{
        if (x==0)
            try {
                synchronized (this) {
                    this.wait(3000);
                }
            } catch (InterruptedException e) {

            }
        synchronized (this) {
            System.out.println("Consuming thread received the key. key = " + x);
            x = bo.apply(x, operand2);
            System.out.println("Consuming thread changed the key. key = " + x);
            this.notify();
        }
    }
}
class threadExample {
    public static void threadRun() {
        Interactor interactor = new Interactor();
        Thread t1 = new Thread(()->{
            try {
                interactor.serve(x-> -x+4, 11);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                interactor.consume((a,b)-> a+2*b, 20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        try {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
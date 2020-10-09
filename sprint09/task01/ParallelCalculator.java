import java.util.function.BinaryOperator;

//Create ParallelCalculator class that will be able to execute an operation in parallel thread.
//Use the implementation of Runnable interface for this.
//Constructor of ParallelCalculator should take 3 parameters:
//The BinaryOperator<Integer> to define an operation that will be executed,
//he operand1 of type int and operand2 of type int.
//The ParallelCalculator class should have not  private result field of type int where the
// result of the operation will be written when it's executed.
public class ParallelCalculator implements Runnable{
    public int result;
    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2 ) {
        Thread thread = new Thread(()->result = binaryOperator.apply(operand1,operand2));
        thread.run();
    }

    @Override
    public void run() {

    }

}

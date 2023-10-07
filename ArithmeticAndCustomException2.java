import java.util.Scanner;

public class ArithmeticAndCustomException2 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the First Number: ");
        double a = input.nextDouble();
        System.out.print("Enter the Second Number: ");
        double b = input.nextDouble();
        input.close();

        try {
            if (a > (Math.pow(2, 31) - 1) || b > (Math.pow(2, 31) - 1) || a < -(Math.pow(2, 31) - 1) || b < -(Math.pow(2, 31) - 1)) {
                throw new CustomException();
            }
        } catch (CustomException e) {
            System.out.println("An Exception Occurred: " + e.getMessage());
            return;
        }

        try {
            if(b==0){
                throw new ArithmeticException();
            }
            int d = (int) (a / b);
            int sum = (int) (a + b);
            int sub = (int) (a - b);
            int m = (int) (a * b);
            System.out.println("Addition: " + sum);
            System.out.println("Subtraction: " + sub);
            System.out.println("Multiplication: " + m);
            System.out.println("Division: " + d);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }

    static class CustomException extends Exception {
        public CustomException() {
            super("Out of range for integer value");
        }
    }
}
package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        double result = 0;

        try{
            result = a / b;
        }catch (ArithmeticException ae){
            System.out.println("Division by zero not allowed! Error: " + ae);
        }finally {
            if(b == 0){
                return 0;
            }else {
                return result;
            }
        }
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);
    }
}

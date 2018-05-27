package com.kodilla.exception.test;

public class ExceptionHandling {
    public String handleProbablyIWillThrowException(double x, double y){
        SecondChallenge secondChallenge = new SecondChallenge();
        String res = "Done!";

        try{
            res = secondChallenge.probablyIWillThrowException(x, y);
        }catch(Exception e){
            new InvalidNumberException("number is not valid");
        }finally {
            return res;
        }
    }
}

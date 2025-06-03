package com.muskan.PrimeChecker;

public class PrimeModel {
    private int number;
    private boolean isPrime;

    public PrimeModel(int number, boolean isPrime) {
        this.number = number;
        this.isPrime = isPrime;
    }

    // Getter for 'number'
    public int getNumber() {
        return number;
    }

    // Setter
    public void setNumber(int number) {
        this.number = number;
    }

    // Getter for 'isPrime'
    public boolean isIsPrime() {
        return isPrime;
    }

    // Setter
    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }
}

package com.example;

public class Lion {

    private Feline feline;
    private String sex;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            this.sex = sex;
        } else if ("Самка".equals(sex)) {
            this.sex = sex;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return "Самец".equals(sex);
    }

    public java.util.List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}


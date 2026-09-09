package com.example;

import java.util.List;

public class Lion {
    private Feline feline;
    private boolean hasMane;
    private String sex;

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;

        // Переводим входную строку в нижний регистр, чтобы избежать проблем с кодировкой первой буквы
        if (sex != null && "самец".equalsIgnoreCase(sex.trim())) {
            this.hasMane = true;
            this.sex = sex;
        } else if (sex != null && "самка".equalsIgnoreCase(sex.trim())) {
            this.hasMane = false;
            this.sex = sex;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public String getSex() {
        return sex;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}





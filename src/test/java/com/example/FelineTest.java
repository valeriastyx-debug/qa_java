package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgumentsReturnsOne() {
        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void getKittensWithArgumentsReturnsPassedValue(int count) {
        Feline feline = new Feline();

        assertEquals(count, feline.getKittens(count));
    }
}


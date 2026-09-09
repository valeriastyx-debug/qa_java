package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    @Test
    public void getFoodReturnsCorrectListForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Трава", "Различные растения");

        assertEquals(expectedFood, animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodReturnsCorrectListForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, animal.getFood("Хищник"));
    }

    @Test
    public void getFoodThrowsExceptionOnUnknownAnimalKind() {
        Animal animal = new Animal();

        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Неизвестно")
        );

        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyReturnsCorrectMessage() {
        Animal animal = new Animal();

        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}

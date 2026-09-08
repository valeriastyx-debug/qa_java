package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void getSoundReturnsCorrectValue() {
        Cat cat = new Cat(felineMock);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Мясо", "Птица"));

        List<String> expectedFood = List.of("Мясо", "Птица");

        assertEquals(expectedFood, cat.getFood());
    }
}

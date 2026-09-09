package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    public static Object[][] getLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @ParameterizedTest
    @MethodSource("getLionData")
    public void doesHaveManeReturnsCorrectValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(felineMock, sex);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void lionConstructorThrowsExceptionOnInvalidSex() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion(felineMock, "Чужой")
        );

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion(felineMock, "Самка");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Мясо"));

        assertEquals(List.of("Мясо"), lion.getFood());
    }
}



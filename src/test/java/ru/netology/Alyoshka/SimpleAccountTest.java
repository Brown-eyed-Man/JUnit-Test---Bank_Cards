package ru.netology.Alyoshka;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleAccountTest {
    private SimpleAccount debitCard;

    @BeforeEach
    public void setUp() {
        debitCard = new SimpleAccount();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "-500, false",
            "0, false",
    })
    public void testDebitCardAddOperation (int sum, boolean expected) {
        boolean result = debitCard.add(sum);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "-500, false",
            "501, false",
            "0, false",
    })
    public void testDebitCardPayOperation (int sum, boolean expected) {
        debitCard.balance = 500;
        boolean result = debitCard.pay(sum);
        Assertions.assertEquals(result, expected);
    }
}
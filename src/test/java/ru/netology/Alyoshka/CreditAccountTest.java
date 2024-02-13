package ru.netology.Alyoshka;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreditAccountTest {
    private CreditAccount creditCard;

    @BeforeEach
    public void setUp() {
        creditCard = new CreditAccount(50_000);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "501, false",
            "-500, false",
            "0, false"
    })
    public void testCreditCardAddOperation (int sum, boolean expected) {
        creditCard.balance = -500;
        boolean result = creditCard.add(sum);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "-500, false",
            "0, false"
    })
    public void testCreditCardPayOperation (int sum, boolean expected) {
        boolean result = creditCard.pay(sum);
        Assertions.assertEquals(result, expected);
    }
}
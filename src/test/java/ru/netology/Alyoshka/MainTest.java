package ru.netology.Alyoshka;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class MainTest {
    private CreditAccount creditCard;
    private SimpleAccount debitCard;

    @BeforeEach
    public void setUp() {
        creditCard = new CreditAccount(50_000);
        debitCard = new SimpleAccount();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "-500, false",
            "0, false",
            })
    public void DebitCardAddOperation (int sum, boolean expected) {
        boolean result = debitCard.add(sum);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "501, false",
            "-500, false",
            "0, false"
    })
    public void CreditCardAddOperation (int sum, boolean expected) {
        creditCard.balance = -500;
        boolean result = creditCard.add(sum);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "-500, false",
            "501, false",
            "0, false",
    })
    public void DebitCardPayOperation (int sum, boolean expected) {
        debitCard.balance = 500;
        boolean result = debitCard.pay(sum);
        Assertions.assertEquals(result, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "500, true",
            "-500, false",
            "0, false"
    })
    public void CreditCardPayOperation (int sum, boolean expected) {
        boolean result = creditCard.pay(sum);
        Assertions.assertEquals(result, expected);
    }
}
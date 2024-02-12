package ru.netology.Alyoshka;

public class Main {
    public static void main(String[] args) {
        CreditAccount creditCard = new CreditAccount(50_000);
        SimpleAccount debitCard = new SimpleAccount();

        creditCard.add(500);
        System.out.println(creditCard.getBalance());
        creditCard.pay(5_000);
        System.out.println(creditCard.getBalance());
        creditCard.pay(45_001);  //Проверка на выход за пределы кредитного лимита
        System.out.println(creditCard.getBalance());
        creditCard.pay(5_000);
        System.out.println(creditCard.getBalance());
        creditCard.transfer(debitCard, 5_500); //Перевод на дебетовую карту
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());

        debitCard.add(500);
        System.out.println(debitCard.getBalance());
        debitCard.pay(15000); //Проверка на плату сверх баланса дебетовой карты.
        System.out.println(debitCard.getBalance());
        debitCard.pay(5000);
        System.out.println(debitCard.getBalance());
        debitCard.add(50_000); // Для проверки перевода суммы, превышающей задолженность по кредитной карте.
        System.out.println(debitCard.getBalance());
        debitCard.transfer(creditCard, 45_000); //Перевод на кредитную карту (Проверка)
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
        debitCard.transfer(creditCard, 15_501); //Перевод на кредитную карту сверх суммы долга (Проверка)
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
        debitCard.transfer(creditCard, 15_500); //Успешное погашение долга на кредитной карте
        System.out.println("Баланс кредитной карты: " + creditCard.getBalance());
        System.out.println("Баланс дебетовой карты: " + debitCard.getBalance());
    }
}
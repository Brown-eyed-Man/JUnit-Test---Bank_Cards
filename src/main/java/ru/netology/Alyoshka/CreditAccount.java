package ru.netology.Alyoshka;

public class CreditAccount extends Account {
    private long creditLimit;
    public CreditAccount(long creditLimit) {
        super(creditLimit);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            balance += amount;
            System.out.println("Вы успешно пополнили баланс");
            return true;
        } else {
            System.out.println("Произошла ошибка");
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount >= -creditLimit) {
            balance -= amount;
            System.out.println("Покупка прошла успешно!");
            return true;
        } else {
            System.out.println("Превышен кредитный лимит. Операция не произведена.");
            return false;
        }
    }

    @Override
    public boolean transfer(Account account, long amount) {
        if (balance - amount >= -creditLimit) {
            balance -= amount;
            account.add(amount);
            System.out.println("Перевод прошёл успешно!");
            return true;
        } else {
            System.out.println("Операция не произведена: Превышен кредитный лимит.");
            return false;
        }
    }
}
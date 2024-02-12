package ru.netology.Alyoshka;

public class SimpleAccount extends Account {
    public SimpleAccount() {
    }

    @Override
    public boolean add(long amount) {
        if (amount > 0) {
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
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Покупка прошла успешно!");
            return true;
        } else {
            System.out.println("Операция не произведена: Недостаточно средств на счете.");
            return false;
        }
    }

    @Override
    public boolean transfer(Account account, long amount) {
        // Баланс на кредитной карте не может быть положительным исходя из задания, поэтому вторая проверка.
        if ((balance - amount >= 0) && (account.balance + amount <= 0)) {
            balance -= amount;
            account.add(amount);
            System.out.println("Перевод прошёл успешно!");
            return true;
        } else {
            System.out.println("Операция не произведена: Попытка перевести сумму, превышающую баланс.");
            return false;
        }
    }
}
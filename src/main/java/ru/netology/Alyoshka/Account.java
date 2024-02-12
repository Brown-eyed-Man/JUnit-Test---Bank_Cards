package ru.netology.Alyoshka;

public abstract class Account {
    protected long balance = 0;

    public Account() {
    }
    public Account(long creditLimit) {
    }

    public abstract boolean add(long amount);
    public abstract boolean pay(long amount);
    public abstract boolean transfer(Account account, long amount);

    long getBalance(){
        return balance;
    }
}

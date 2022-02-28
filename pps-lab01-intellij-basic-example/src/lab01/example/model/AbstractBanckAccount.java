package lab01.example.model;

public class AbstractBanckAccount implements BankAccount {
    private final AccountHolder holder;
    private double balance;
    private ComputeFee computeFee;

    public AbstractBanckAccount(final double balance, final AccountHolder holder, ComputeFee computefee) {
        this.balance = balance;
        this.holder = holder;
        this.computeFee = computefee;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance = this.balance + amount - this.computeFee.calculateFee();
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - this.computeFee.calculateFee();
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}

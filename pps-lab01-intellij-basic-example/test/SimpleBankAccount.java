import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccountTest{

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
       super.testInitialBalance(bankAccount);
    }

    @Test
    void testDeposit() {
        int deposit = 100;
        bankAccount.deposit(accountHolder.getId(), deposit);
        assertEquals(deposit, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int firstDeposit = 100;
        int secondDeposit = 50;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), firstDeposit);
        bankAccount.deposit(wrongUserId, secondDeposit);
        assertEquals(firstDeposit, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int deposit = 100;
        int withdraw = 70;
        bankAccount.deposit(accountHolder.getId(), deposit);
        bankAccount.withdraw(accountHolder.getId(), withdraw);
        assertEquals(deposit - withdraw, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int deposit = 100;
        int withdraw = 70;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), deposit);
        bankAccount.withdraw(wrongUserId, withdraw);
        assertEquals(deposit, bankAccount.getBalance());
    }
}
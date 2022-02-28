import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest{

    private static final int FEE_SIMPLE_ACCOUNT_WITH_ATM = 1;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        super.testInitialBalance(bankAccount);
    }

    @Test
    void testDeposit() {
        int deposit = 100;
        bankAccount.deposit(accountHolder.getId(), deposit);
        assertEquals(deposit - FEE_SIMPLE_ACCOUNT_WITH_ATM, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int firstDeposit = 100;
        int secondDeposit = 50;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), firstDeposit);
        bankAccount.deposit(wrongUserId, secondDeposit);
        assertEquals(firstDeposit - FEE_SIMPLE_ACCOUNT_WITH_ATM, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int deposit = 100;
        int withdraw = 70;
        int numberOfOperations = 2;
        bankAccount.deposit(accountHolder.getId(), deposit);
        bankAccount.withdraw(accountHolder.getId(), withdraw);
        assertEquals(deposit - withdraw - (FEE_SIMPLE_ACCOUNT_WITH_ATM * numberOfOperations), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int deposit = 100;
        int withdraw = 70;
        int wrongUserId = 2;
        bankAccount.deposit(accountHolder.getId(), deposit);
        bankAccount.withdraw(wrongUserId, withdraw);
        assertEquals(deposit - FEE_SIMPLE_ACCOUNT_WITH_ATM, bankAccount.getBalance());
    }
}
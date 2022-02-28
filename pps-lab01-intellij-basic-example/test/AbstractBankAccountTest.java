import lab01.example.model.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {

    @Test
    void testInitialBalance(BankAccount bankAccount) {
        assertEquals(0, bankAccount.getBalance());
    }

}

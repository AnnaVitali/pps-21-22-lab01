package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractBanckAccount{

    private static final int FEE_SIMPLE_ACCOUNT_WITH_ATM = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(balance, holder, ()->FEE_SIMPLE_ACCOUNT_WITH_ATM);
    }
}

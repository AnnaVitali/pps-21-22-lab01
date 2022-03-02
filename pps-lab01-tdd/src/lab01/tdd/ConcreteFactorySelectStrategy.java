package lab01.tdd;

public class ConcreteFactorySelectStrategy implements AbstractFactorySelectStrategy{

    private static final int MULTIPLE_NUMBER = 2;
    private static final int EQUALS_NUMBER = 3;

    @Override
    public SelectStrategy createEvenStrategy() {
        return element -> element % 2 == 0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy() {
        return element -> element % MULTIPLE_NUMBER == 0;
    }

    @Override
    public SelectStrategy createEqualsStrategy() {
        return element -> element == EQUALS_NUMBER;
    }
}

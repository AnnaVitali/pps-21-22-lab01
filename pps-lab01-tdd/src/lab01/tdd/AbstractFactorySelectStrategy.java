package lab01.tdd;

public interface AbstractFactorySelectStrategy {

    SelectStrategy createEvenStrategy();

    SelectStrategy createMultipleOfStrategy();

    SelectStrategy createEqualsStrategy();
}

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class functionalInterfacesSyntax {
    public static void main(String[] args) {
        /**
         * 1. Consumer<T>:
         * Syntax: Consumer<T> or (T t) -> { implementation }
         * Definition: Represents an operation that accepts a single input of type T and
         * performs some action on it without returning any result.
         */
        Consumer<String> printMessage = (message) -> System.out.println(message);
        printMessage.accept("Consumer() Hello, world!");

        /**
         * 2. Supplier<T>:
         * Syntax: Syntax: Supplier<T> or () -> { implementation }
         * Definition: Represents a supplier of results of type T. It has no input
         * arguments and provides a value when requested.
         */
        Supplier<Double> randomValue = () -> Math.random();
        double SupplierValue = randomValue.get();
        System.out.println("Supplier() Random value: " + SupplierValue);

        /**
         * 3. Function<T, R>:
         * Syntax: Function<T, R> or (T t) -> { implementation returning R }
         * Definition: Represents a function that takes an input of type T and produces
         * an output of type R. It applies a transformation to the input and returns the
         * result.
         */
        Function<Integer, String> stringify = (num) -> "The number is: " + num;
        String FunctionResult = stringify.apply(42);
        System.out.println("Function() " + FunctionResult);

        /**
         * Predicate<T>:
         * Syntax: Predicate<T> or (T t) -> { boolean condition }
         * Definition: Represents a function that takes an input of type T and returns a
         * boolean result. It tests whether the input satisfies a given condition.
         */
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        boolean PredicateResult = isEven.test(10);
        System.out.println("Predicate() Is even? " + PredicateResult);

        /**
         * UnaryOperator<T>:
         * Syntax: UnaryOperator<T> or (T t) -> { implementation returning T }
         * Definition: Represents an operation on a single input of type T that produces
         * a result of the same type T. It combines the functionality of Function<T, R>
         * where the input and output types are the same.
         */
        UnaryOperator<Integer> square = (num) -> num * num;
        int UnaryOperatorResult = square.apply(5);
        System.out.println("UnaryOperator() Square: " + UnaryOperatorResult);

        /**
         * BinaryOperator<T>:
         * Syntax: BinaryOperator<T> or (T t1, T t2) -> { implementation returning T }
         * Definition: Represents an operation on two inputs of type T that produces a
         * result of the same type T. It combines the functionality of BiFunction<T, U,
         * R> where the input and output types are the same.
         */
        BinaryOperator<Integer> add = (num1, num2) -> num1 + num2;
        int binaryOperatorResult = add.apply(3, 4);
        System.out.println("BinaryOperator() Sum: " + binaryOperatorResult);

    }
}

package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Delimiter delimiter = new Delimiter();
        Parser parser = new Parser(delimiter);
        Validator validator = new Validator();
        Converter converter = new Converter();
        Adder adder = new Adder();

        String input = Input.receiveInput();

        String[] parts = parser.parse(input);

        validator.validate(parts);

        List<Integer> numbers = converter.convertParts(parts);

        int result = adder.addParts(numbers);

        Output.printResult(result);
    }
}

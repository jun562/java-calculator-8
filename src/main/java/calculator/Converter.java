package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public Converter() {

    }

    public List<Integer> convertParts(String[] parts) {
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            if (part.isEmpty()) {
                numbers.add(0);
                continue;
            }
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}

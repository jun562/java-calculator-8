package calculator;

import java.util.List;

public class Adder {
    public Adder() {
    }

    public int addParts(List<Integer> convertedParts) {
        int sum = 0;
        for (int part : convertedParts) {
            sum += part;
        }
        return sum;
    }
}

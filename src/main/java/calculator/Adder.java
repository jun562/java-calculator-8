package calculator;

import java.util.List;

/**
 * 숫자들을 더하는 클래스
 */
public class Adder {
    public Adder() {
    }

    /**
     * 정수형 리스트의 각 요소들의 합 계산
     */
    public int addParts(List<Integer> convertedParts) {
        int sum = 0;
        for (int part : convertedParts) {
            sum += part;
        }
        return sum;
    }
}

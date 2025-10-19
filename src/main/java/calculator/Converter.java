package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 형태의 숫자들을 정수형으로 변환하는 클래스
 */
public class Converter {
    public Converter() {

    }

    /**
     * 문자열 배열을 정수형 배열로 변환
     */
    public List<Integer> convertParts(String[] parts) {
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            // 배열 요소가 빈 문자열인 경우 0으로 변환
            if (part.isEmpty()) {
                numbers.add(0);
                continue;
            }
            numbers.add(Integer.parseInt(part));
        }
        return numbers;
    }
}

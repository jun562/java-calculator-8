package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public Delimiter() {
    }

    public String extractCustomDelimiter(String input) {
        int endIndex = findCustomDelimiterEndIndex(input);

        if (endIndex != -1) {
            addCustomDelimiter(input, endIndex);
            return processInput(input, endIndex);
        }
        return input;
    }

    private int findCustomDelimiterEndIndex(String input) {
        if (!(input.startsWith("//")) || !(input.contains("\\n"))) {
            return -1;
        }

        int endIndex = input.indexOf("\\n");

        if (endIndex == 2) {
            throw new IllegalArgumentException("커스텀 구분자는 비어있을 수 없습니다.");
        }

        if (endIndex != 3) {
            throw new IllegalArgumentException("커스텀 구분자는 문자만 지정해야 합니다.");
        }

        return endIndex;
    }

    private void addCustomDelimiter(String input, int endIndex) {
        delimiters.add(input.substring(2, endIndex));
    }

    private String processInput(String input, int endIndex) {
        return input.substring(endIndex + 2);
    }

    /**
     * 외부 수정 방지
     */
    public List<String> getDelimiters() {
        return new ArrayList<>(this.delimiters);
    }
}

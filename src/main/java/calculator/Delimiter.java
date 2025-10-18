package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<String> delimiters = new ArrayList<String>(List.of(",", ":"));

    public Delimiter() {
    }

    public void extractCustomDelimiter(String input) {
        if (!(input.startsWith("//")) || !(input.contains("\\n"))) {
            return;
        }

        int endIndex = input.indexOf("\\n");

        if (endIndex == 2) {
            throw new IllegalArgumentException("커스텀 구분자는 비어있을 수 없습니다.");
        }

        if (endIndex != 3) {
            throw new IllegalArgumentException("커스텀 구분자는 문자만 지정해야 합니다.");
        }

        delimiters.add(input.substring(2, 3));
    }

    /**
     * 외부 수정 방지
     */
    public List<String> getDelimiters() {
        return new ArrayList<>(this.delimiters);
    }
}

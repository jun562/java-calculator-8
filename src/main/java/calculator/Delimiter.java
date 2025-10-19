package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 구분자 모음 관리와 커스텀 구분자 여부에 따라 입력된 값을 가공하는 클래스
 */
public class Delimiter {
    // 기본 구분자
    private final List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public Delimiter() {
    }

    /**
     * Delimiter의 기능들을 호출하여, 구분자 처리 및 문자열 반환
     */
    public String extractCustomDelimiter(String input) {
        int endIndex = findCustomDelimiterEndIndex(input);

        if (endIndex != -1) {
            addCustomDelimiter(input, endIndex);
            return processInput(input, endIndex);
        }
        return input;
    }

    /**
     * 커스텀 구분자 선언 부(문자열)가 존재하면, 해당 커스텀 구분자 직후 인덱스를 반환
     */
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

    /**
     * 커스텀 구분자를 구분자 모음(리스트)에 추가
     */
    private void addCustomDelimiter(String input, int endIndex) {
        delimiters.add(input.substring(2, endIndex));
    }

    /**
     * 커스텀 구분자 선언부 제외 입력값 반환
     */
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

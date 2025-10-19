package calculator;

/**
 * 파싱된 문자열 형식을 검사하는 클래스
 */
public class Validator {
    public Validator() {

    }

    /**
     * 문자열 배열의 각 문자열이 입력 형식에 맞는지 검사 실제로는 문자이지만, 검사 단순화를 위해 문자열로 처리
     */
    public void validate(String[] parts) {
        for (String part : parts) {
            if (!isValid(part)) {
                throw new IllegalArgumentException("입력값은 1~9 사이의 한 자리 숫자 또는 빈 값만 가능합니다.");
            }
        }
    }

    /**
     * 문자열 형식 체크
     */
    private boolean isValid(String part) {
        if (part.isEmpty()) {
            return true;
        }
        // 1~9 사이의 숫자인지 검사
        return part.matches("[1-9]");
    }
}

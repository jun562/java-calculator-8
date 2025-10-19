package calculator;

public class Validator {
    public Validator() {

    }

    public void validate(String[] parts) {
        for (String part : parts) {
            if (!isValid(part)) {
                throw new IllegalArgumentException("입력값은 1~9 사이의 한 자리 숫자 또는 빈 값만 가능합니다.");
            }
        }
    }

    private boolean isValid(String part) {
        if (part.isEmpty()) {
            return true;
        }
        // 1~9 사이의 숫자인지 검사
        return part.matches("[1-9]");
    }
}

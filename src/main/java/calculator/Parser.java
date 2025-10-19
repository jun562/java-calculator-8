package calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 구분자를 통해 문자열 파싱하여, 문자열 배열로 반환하는 클래스
 */
public class Parser {
    // 구분자 및 가공된 입력을 사용하기 위해 의존성 주입
    private final Delimiter delimiter;

    public Parser(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * 문자열 파싱
     */
    public String[] parse(String input) {
        String processedInput = delimiter.extractCustomDelimiter(input);
        // 구분자 모음
        List<String> allDelimiters = delimiter.getDelimiters();
        // 정규 표현식으로 문자열 분리
        String regex = buildRegex(allDelimiters);
        String[] parts = processedInput.split(regex);
        // 공백 제거된 문자열 배열 반환
        return trimParts(parts);
    }

    /**
     * 구분자 모음(리스트) 정규 표현식으로 변환
     */
    private String buildRegex(List<String> delimiters) {
        // 스트림 생성 (List)
        Stream<String> delimiterStream = delimiters.stream();
        // 특수문자 이스케이프 처리
        Stream<String> quotedDelimiters = delimiterStream.map(Pattern::quote);
        // "|" 로 Regex 생성
        return quotedDelimiters.collect(Collectors.joining("|"));
    }

    /**
     * 문자열 공백 제거
     */
    private String[] trimParts(String[] parts) {
        // 스트림 생성 (Array)
        Stream<String> partStream = Stream.of(parts);
        // 각 요소 공백 제거
        Stream<String> trimmedStream = partStream.map(String::trim);
        // 문자열 배열로 변환
        return trimmedStream.toArray(String[]::new);
    }
}

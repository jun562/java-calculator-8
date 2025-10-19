package calculator;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private final Delimiter delimiter;

    public Parser(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parse(String input) {
        String processedInput = delimiter.extractCustomDelimiter(input);

        List<String> allDelimiters = delimiter.getDelimiters();
        String regex = buildRegex(allDelimiters);

        String[] parts = processedInput.split(regex);

        return trimParts(parts);
    }

    private String buildRegex(List<String> delimiters) {
        // 스트림 생성 (List)
        Stream<String> delimiterStream = delimiters.stream();
        // 특수문자 이스케이프 처리
        Stream<String> quotedDelimiters = delimiterStream.map(Pattern::quote);
        // "|" 로 Regex 생성
        return quotedDelimiters.collect(Collectors.joining("|"));
    }

    private String[] trimParts(String[] parts) {
        // 스트림 생성 (Array)
        Stream<String> partStream = Stream.of(parts);
        // 각 요소 공백 제거
        Stream<String> trimmedStream = partStream.map(String::trim);
        // 문자열 배열로 변환
        return trimmedStream.toArray(String[]::new);
    }
}

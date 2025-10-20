# 프리코스 1주차 과제

## 구현 기능 목록

### ✅ 기능

- 구분자와 양수로 구성된 문자열을 입력 받는다. (Input)
- 입력 받은 문자열에서 “//\n”사이의 문자가 존재하면, 구분자 모음에 해당 커스텀 구분자를 추가한다. (Delimiter)
    - 이때 문자는, 숫자, 공백, 이스케이프 문자도 포함한다.
- 구분자 모음에서 특수문자가 존재하는 경우, 이스케이프 처리 한다. (Parser)
- 구분자 모음을 통해, 문자열을 분리하여 문자열 배열로 반환한다. (Parser)
- 입력받은 문자열 배열에서 공백 문자가 존재하면 제거한다. (Parser)
- 문자열 배열의 요소에 대해 유효성 검사를 실시한다. (Validator)
- 문자열 배열을 정수형(숫자) 배열로 변환한다. (Converter)
- 변환된 정수형(숫자) 배열의 각 요소를 더하여 반환한다. (Adder)
- 반환된 결과(계산값)를 문자열로 출력한다. (Output)

### ⚠️ 예외

`IllegalArgumentException`을 발생시킨다.

- “//\n” 사이에 커스텀 구분자가 없는 경우
- “//\n” 사이에 문자열이 포함되는 경우 (예: ##, 35, -1 등)
- 구분자가 존재하지 않는 경우
    - 단, 문자열의 앞뒤 공백을 제거한 결과가, 하나의 양의 정수이거나 완전히 비어있는 경우만 허용한다. (예: “ 3”, “”)
- “구분자가 아닌 문자가 포함된” 문자열을 입력 받는 경우
- “음수가 포함된” 문자열을 입력 받는 경우
- “0이 포함된” 문자열을 입력 받는 경우
    - 단, 커스텀 구분자가 0일 때는 허용한다.
- 숫자(일의 자리 수)가 아닌 수를 입력 받는 경우

## 기능(모듈) 명세

| Class     | Method                      | Input           | Output          | Description                                                 |
|-----------|-----------------------------|-----------------|-----------------|-------------------------------------------------------------|
| Input     | receiveInput                |                 | String          | 사용자로부터 입력 값을 받는다.                                           |
| Delimiter | extractCustomDelimiter      | String          | String          | 아래 4개의 메소드를 호출하여, 구분자 처리를 수행한 후, 문자열을 반환한다.                 |
|           | findCustomDelimiterEndIndex | String          | int             | 커스텀 구분자 선언 문자열(”//{문자}\n)이 존재한다면, 해당 선언 문자열의 마지막 인덱스를 반환한다. |
|           | addCustomDelimiter          | String, int     |                 | 구분자 모음에 커스텀 문자를 추가한다.                                       |
|           | processInput                | String, int     | String          | 커스텀 구분자 선언 문자열을 제외한 나머지 문자열을 반환한다.                          |
|           | getDelimiters               |                 | String          | 구분자 모음을 반환한다.                                               |
| Parser    | parse                       | String          | String []       | 구분자 모음을 통해 문자열을 문자열 배열로 반환한다.                               |
|           | buildRegex                  | List\<String\>  | String          | 구분자 모음을 하나의 정규 표현식으로 변환하여 반환한다.                             |
|           | trimParts                   | String []       | String []       | 문자열 배열의 각 요소들의 공백을 제거한 후 반환한다.                              |
| Validator | validate                    |                 |                 | 각 문자열 배열의 요소의 유효성 검사를 시행하고, 예외를 발생시킨다.                      |
|           | isValid                     | String          | boolean         | 해당 문자가 1~9사이의 숫자인지 검사한다.                                    |
| Converter | convertParts                | String []       | List\<Integer\> | 문자열 배열의 요소들을 숫자로 변환하여 정수형 배열을 반환한다.                         |
| Adder     | addParts                    | List\<Integer\> | int             | 정수형 배열의 각 요소들을 더하여 반환한다.                                    |
| Output    | printResult                 | int             |                 | 더한 결과 값을 출력한다.                                              |

## 커밋 컨벤션

> **AngularJS 커밋 컨벤션** 참고
>

| Type     | Description                   |
|----------|-------------------------------|
| feat     | 기능 (새로운 기능)                   |
| fix      | 버그 (버그 수정)                    |
| docs     | 문서 수정 (문서 추가, 수정, 삭제, README) |
| style    | 스타일 (코드 형식(포맷), 세미클론 누락 수정)   |
| refactor | 리팩토링                          |
| test     | 테스트 (테스트 코드 추가, 수정, 삭제)       |
| chore    | 기타 변경사항 (빌드 작업 및 도구 관련 변경)    |

## 체크 리스트

### **진행 방식**

- [x]  기능을 구현하기 전에 **기능 목록**을 만들고, 기능 단위로 커밋한다.
- [x]  기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.
- [x]  요구 사항에 명시된 출력 형식을 따라야한다.

### 과제 진행 요구 사항

- [x]  미션은[문자열 덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-8)저장소를 포크하고 클론하는 것으로 시작한다.
- [x]  **기능을 구현하기 전`README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [x]  Git의 커밋 단위는 앞 단계에서`README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를 작성한다.

### 기능 요구 사항

- [x]  쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- [x]  앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [x]  사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- [x]  구분자와 양수로 구성된 문자열을 입력받는다.

### 프로그래밍 요구 사항

- [x]  JDK 21 버전에서 실행 가능해야 한다.
- [x]  프로그램 실행의 시작점은`Application`의`main()`이다.
- [x]  `build.gradle`파일은 변경할 수 없으며,**제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- [x]  프로그램 종료 시`System.exit()`를 호출하지 않는다.
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x]  자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로[Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.
- [x]  `camp.nextstep.edu.missionutils`에서 제공하는`Console`API를 사용하여 구현해야 한다.
- [x]  사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용한다.
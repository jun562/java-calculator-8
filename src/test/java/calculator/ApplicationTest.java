package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    //    성공 케이스

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 엔터만_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 탭만_입력() {
        assertSimpleTest(() -> {
            run("\t");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 스페이스만_입력() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 양수만_입력() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 구분자만_입력() {
        assertSimpleTest(() -> {
            run(",:");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_포함된_숫자_입력() {
        assertSimpleTest(() -> {
            run(" 3\t");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 공백_포함된_문자열_입력() {
        assertSimpleTest(() -> {
            run(" 3 \t,2");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 연속된_구분자_포함된_문자열_입력() {
        assertSimpleTest(() -> {
            run("2,,:2");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 커스텀_구분자가_숫자인_문자열_입력1() {
        assertSimpleTest(() -> {
            run("//2\\n324");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 커스텀_구분자가_숫자인_문자열_입력2() {
        assertSimpleTest(() -> {
            run("//2\\n2,2");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자가_0인_문자열_입력() {
        assertSimpleTest(() -> {
            run("//0\\n102");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자가_공백인_문자열_입력() {
        assertSimpleTest(() -> {
            run("// \\n2 3,3");
            assertThat(output()).contains("결과 : 8");
        });
    }

//    실페 케이스 (Exception)

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_포함된_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-2:3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_문자가_아닌_0이_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0:3,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_미포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_문자가_아닌_문자가_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1#2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀할_문자가_미포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀할_문자가_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//&&\\n3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

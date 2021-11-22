package hello.advanced.trace.strategy;

import hello.advanced.trace.template.Callback;
import hello.advanced.trace.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("익명 내부 클래스1의 로직 실행");
                log.info("익명 내부 클래스1의 로직 실행{}", this.getClass());
            }
        });
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("익명 내부 클래스2의 로직 실행");
                log.info("익명 내부 클래스2의 로직 실행{}", this.getClass());
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("익명 내부 클래스1의 로직 실행"));
        template.execute(() -> log.info("익명 내부 클래스2의 로직 실행"));
    }
}

package hello.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 내부 클래스1의 로직 실행");
            }
        });

        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 내부 클래스2의 로직 실행");
            }
        });
    }

    /**
     * 전략 패턴 람다
     */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("익명 내부 클래스1의 로직 실행"));
        context.execute(() -> log.info("익명 내부 클래스2의 로직 실행"));
    }
}

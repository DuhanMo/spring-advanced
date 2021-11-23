package hello.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

    private final ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        log.info("TimeProxy.operation 실행");
        long start = System.currentTimeMillis();
        String result = concreteLogic.operation();
        long resultTime = System.currentTimeMillis() - start;
        log.info("TimeDecoratorComponent 종료 -> 걸린 시간{}ms", resultTime);
        return result;
    }
}

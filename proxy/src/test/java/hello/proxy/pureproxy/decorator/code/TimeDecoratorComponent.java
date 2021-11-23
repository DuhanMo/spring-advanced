package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecoratorComponent implements Component{

    private final Component component;

    public TimeDecoratorComponent(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecoratorComponent 호출");
        long start = System.currentTimeMillis();
        String result = component.operation();
        long resultTime = System.currentTimeMillis() - start;
        log.info("TimeDecoratorComponent 종료 -> 걸린 시간{}ms", resultTime);
        return result;
    }
}

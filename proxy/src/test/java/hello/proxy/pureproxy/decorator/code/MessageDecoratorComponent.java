package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecoratorComponent implements Component{

    private Component component;

    public MessageDecoratorComponent(Component component) {
        this.component = component;
    }


    @Override
    public String operation() {
        log.info("MessageDecoratorComponent 호출");
        String result = component.operation();
        String decoResult = "*****" + result + "*****";
        log.info("메시지 데코 전={}, 데코 후={}", result, decoResult);
        return decoResult;
    }
}

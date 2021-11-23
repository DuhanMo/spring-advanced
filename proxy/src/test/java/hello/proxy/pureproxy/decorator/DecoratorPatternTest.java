package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import hello.proxy.pureproxy.decorator.code.MessageDecoratorComponent;
import hello.proxy.pureproxy.decorator.code.RealComponent;
import hello.proxy.pureproxy.decorator.code.TimeDecoratorComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void messageDecorator() {
        RealComponent realComponent = new RealComponent();
        MessageDecoratorComponent messageDecoratorComponent = new MessageDecoratorComponent(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecoratorComponent);
        client.execute();
    }

    @Test
    void time_message_deco() {
        RealComponent realComponent = new RealComponent();
        MessageDecoratorComponent messageDecoratorComponent = new MessageDecoratorComponent(realComponent);
        TimeDecoratorComponent timeDecoratorComponent = new TimeDecoratorComponent(messageDecoratorComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecoratorComponent);
        client.execute();
    }
}

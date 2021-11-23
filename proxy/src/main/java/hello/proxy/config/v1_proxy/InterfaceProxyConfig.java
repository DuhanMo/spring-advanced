package hello.proxy.config.v1_proxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import hello.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController() {
        OrderControllerV1 orderController = new OrderControllerV1Impl(orderService());
        return new OrderControllerInterfaceProxy(orderController, logTrace());
    }

    @Bean
    public OrderServiceV1 orderService() {
        OrderServiceV1 orderService = new OrderServiceV1Impl(orderRepository());
        return new OrderServiceInterfaceProxy(orderService, logTrace());
    }

    @Bean
    public OrderRepositoryV1 orderRepository() {
        OrderRepositoryV1 orderRepository = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepository, logTrace());
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}

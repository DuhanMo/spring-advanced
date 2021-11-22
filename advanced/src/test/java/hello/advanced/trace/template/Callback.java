package hello.advanced.trace.template;

/**
 * 콜백 로직을 전달할 인터페이스
 * 전략 패턴중 컨텍스트에 파라미터로 넘겨주는 [전략]
 */
public interface Callback {
    void call();
}

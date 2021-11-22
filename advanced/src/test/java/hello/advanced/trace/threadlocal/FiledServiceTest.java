package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class FiledServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() throws InterruptedException {
        log.info("main start");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable userA = () -> {
            fieldService.logic("userA");
            countDownLatch.countDown();
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
            countDownLatch.countDown();
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);
        threadB.start();

        countDownLatch.await();
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

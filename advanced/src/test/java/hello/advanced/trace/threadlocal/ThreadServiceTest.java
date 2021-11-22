package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ThreadServiceTest {

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field() throws InterruptedException {
        log.info("main start");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable userA = () -> {
            threadLocalService.logic("userA");
            countDownLatch.countDown();
        };

        Runnable userB = () -> {
            threadLocalService.logic("userB");
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

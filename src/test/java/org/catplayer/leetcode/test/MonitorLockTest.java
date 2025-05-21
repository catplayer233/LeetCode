package org.catplayer.leetcode.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

public class MonitorLockTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorLockTest.class);

    private final Object lockTarget = new Object();

    @Test
    public void test() {
        // using the cached thread pool make sure all tasks run on a new thread
        try (var executor = Executors.newCachedThreadPool()) {
            executor.submit(() -> errorFreeCall(this::enterAndWait));
            executor.submit(() -> errorFreeCall(this::enterAndNotify));
        }
    }

    private void enterAndWait() throws InterruptedException {
        synchronized (lockTarget) {
            LOGGER.info("hold the lock, try to wait until notify");
            lockTarget.wait();
            LOGGER.info("notified");
        }
    }

    private void enterAndNotify() throws InterruptedException {
        // wait a while
        Thread.sleep(1000);
        synchronized (lockTarget) {
            LOGGER.info("hold the lock, try to notify other thread which is waiting for that");
            // notify the waited thread to resume execution, but only when current thread returned the lock
            // after synchronized block
            lockTarget.notify();
            LOGGER.info("still hold the lock: {}", Thread.holdsLock(lockTarget));
            Thread.sleep(1000);
        }
        LOGGER.info("finish notify");
    }

    private void errorFreeCall(ThrowableRunnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            LOGGER.error("something wrong happened", e);
        }
    }

}

@FunctionalInterface
interface ThrowableRunnable {
    void run() throws Exception;
}

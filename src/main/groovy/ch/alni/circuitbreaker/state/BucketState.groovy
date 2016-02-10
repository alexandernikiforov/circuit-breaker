package ch.alni.circuitbreaker.state

import java.util.concurrent.ExecutorService
import java.util.concurrent.atomic.AtomicInteger

/**
 * TODO: javadoc 
 *
 * @author $Author$
 * @version $Revision$
 */


class BucketState {
    private final ExecutorService executorService;
    private final int maxNumberOfAttemts;
    private final AtomicInteger countedEvents = new AtomicInteger(0);

    BucketState(ExecutorService executorService, int maxNumberOfAttemts) {
        this.executorService = executorService
        this.maxNumberOfAttemts = maxNumberOfAttemts
    }

    void increment() {
        executorService.submit({ -> countedEvents.incrementAndGet() });
    }

    boolean isLeaking() {
        countedEvents.get() >= maxNumberOfAttemts;
    }
}

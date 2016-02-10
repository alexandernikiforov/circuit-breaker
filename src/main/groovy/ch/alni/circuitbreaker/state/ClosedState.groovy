package ch.alni.circuitbreaker.state

import ch.alni.circuitbreaker.CircuitBreaker
import ch.alni.circuitbreaker.CircuitBreakerState

import java.util.concurrent.Callable

/**
 * Implementation of the CLOSED state of a circuit breaker.
 *
 * @author $Author$
 * @version $Revision$
 */
class ClosedState implements CircuitBreakerState {

    private final CircuitBreaker circuitBreaker;

    private final List<Bucket> buckets;

    ClosedState(CircuitBreaker circuitBreaker, List<Bucket> buckets) {
        this.circuitBreaker = circuitBreaker
        this.buckets = buckets
    }

    @Override
    <T> T call(Callable<T> method) throws Exception {
        try {
            return method.call();
        }
        catch (Exception e) {
            // set to a new state?
            if (isOverflowedWith(e)) {
                circuitBreaker.trip();
            }

            throw e;
        }
    }

    private boolean isOverflowedWith(Exception e) {
        buckets.findResult(false, { bucket ->
            bucket.emit(e);
            bucket.isLeaking() ? true : null
        })
    }
}

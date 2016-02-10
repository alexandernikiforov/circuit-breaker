package ch.alni.circuitbreaker;

import java.util.concurrent.Callable;

/**
 * State of a circuit breaker.
 *
 * @author $Author$
 * @version $Revision$
 */

public interface CircuitBreakerState {
  <T> T call(Callable<T> method) throws Exception;

}

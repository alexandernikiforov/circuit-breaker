package ch.alni.circuitbreaker;

import java.util.concurrent.Callable;

/**
 * This interface describes a typical circuit breaker.
 */
public class CircuitBreaker {

  enum State {
    CLOSED,
    OPEN,
    HALF_OPEN
  }

  /**
   * Trips this circuit breaker to its OPEN state.
   */
  public void trip() {

  }

  /**
   * Resets this circuit breaker to its CLOSED state.
   */
  public void reset() {

  }

  /**
   * Sets this breaker to half-closed state.
   */
  public void tryClose() {

  }

  /**
   * Returns the current state of this circuit breaker.
   */
  State getState() {
    return State.CLOSED;
  }

  /**
   * Calls the given method via this circuit breaker.
   *
   * @param method the method to be called
   * @param <T>    the type of the object
   * @return the object of the specified type
   * @throws OperationException if the called method has thrown a checked exception, it will be
   *                            wrapped into this unchecked exception
   */
  <T> T call(Callable<T> method) {
    try {
      return method.call();
    } catch (Exception e) {
      throw new OperationException(e);
    }
  }
}

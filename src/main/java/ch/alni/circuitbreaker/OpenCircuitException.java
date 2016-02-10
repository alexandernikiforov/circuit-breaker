package ch.alni.circuitbreaker;

/**
 * Exception thrown if the circuit breaker is open and cannot serve requests.
 *
 * @since 28.04.14
 */
public class OpenCircuitException extends RuntimeException {

  public OpenCircuitException() {
  }

}

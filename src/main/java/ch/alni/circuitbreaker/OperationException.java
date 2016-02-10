package ch.alni.circuitbreaker;

/**
 * Exception thrown if the call to the external system has failed with a checked exception.
 *
 * @since 28.04.14
 */
public class OperationException extends RuntimeException {

  public OperationException(String message) {
    super(message);
  }

  public OperationException(String message, Throwable cause) {
    super(message, cause);
  }

  public OperationException(Exception cause) {
    super(cause);
  }
}

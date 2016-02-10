package ch.alni.circuitbreaker;

/**
 * Configuration of a circuit breaker.
 *
 * @since 28.04.14
 */
public class Configuration {

  public static class Builder {
    public Builder setMaxNumberOfTimeouts(int maxNumberOfTimeouts) {
      this.maxNumberOfTimeouts = maxNumberOfTimeouts;
      return this;
    }

    public Builder setMaxNumberOfFailures(int maxNumberOfFailures) {
      this.maxNumberOfFailures = maxNumberOfFailures;
      return this;
    }

    /**
     * Sets the timeout for a circuit breaker to try reset in the CLOSED-state.
     */
    public Builder setResetTimeoutInMilliseconds(long resetTimeoutInMilliseconds) {
      this.resetTimeoutInMilliseconds = resetTimeoutInMilliseconds;
      return this;
    }

    public Builder setTimeoutFilter(ExceptionFilter timeoutFilter) {
      this.timeoutFilter = timeoutFilter;
      return this;
    }

    public Builder setFailureFilter(ExceptionFilter failureFilter) {
      this.failureFilter = failureFilter;
      return this;
    }

    private int maxNumberOfTimeouts;

    private int maxNumberOfFailures;

    private long resetTimeoutInMilliseconds;

    private ExceptionFilter timeoutFilter = e -> false;
    private ExceptionFilter failureFilter = e -> true;
  }

  private final int maxNumberOfTimeouts;

  private final int maxNumberOfFailures;

  private final long resetTimeoutInMilliseconds;

  private final ExceptionFilter timeoutFilter;
  private final ExceptionFilter failureFilter;

  protected Configuration(Builder builder) {
    failureFilter = builder.failureFilter;
    timeoutFilter = builder.timeoutFilter;
    resetTimeoutInMilliseconds = builder.resetTimeoutInMilliseconds;
    maxNumberOfFailures = builder.maxNumberOfFailures;
    maxNumberOfTimeouts = builder.maxNumberOfTimeouts;
  }

  public int getMaxNumberOfTimeouts() {
    return maxNumberOfTimeouts;
  }

  public int getMaxNumberOfFailures() {
    return maxNumberOfFailures;
  }

  public long getResetTimeoutInMilliseconds() {
    return resetTimeoutInMilliseconds;
  }

  public ExceptionFilter getTimeoutFilter() {
    return timeoutFilter;
  }

  public ExceptionFilter getFailureFilter() {
    return failureFilter;
  }
}

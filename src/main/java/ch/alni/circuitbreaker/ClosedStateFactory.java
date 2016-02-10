package ch.alni.circuitbreaker;

import java.util.concurrent.ExecutorService;

import ch.alni.circuitbreaker.state.Bucket;
import ch.alni.circuitbreaker.state.BucketState;
import ch.alni.circuitbreaker.state.ClosedState;

import static java.util.Arrays.asList;

/**
 * TODO: javadoc
 *
 * @author $Author$
 * @version $Revision$
 */


public class ClosedStateFactory {
  private final ExecutorService executorService;

  public ClosedStateFactory(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public ClosedState create(final CircuitBreaker circuitBreaker, final Configuration configuration) {
    return new ClosedState(circuitBreaker,
        asList(
            new Bucket(new BucketState(executorService, configuration.getMaxNumberOfFailures()))
        ));
  }
}

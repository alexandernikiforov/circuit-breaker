package ch.alni.circuitbreaker;

/**
 * Filter to find out whether this is of particular interest.
 *
 * @author $Author$
 * @version $Revision$
 */

@FunctionalInterface
public interface ExceptionFilter {
  boolean isInteresting(Exception e);
}

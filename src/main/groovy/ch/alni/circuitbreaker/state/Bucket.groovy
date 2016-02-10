package ch.alni.circuitbreaker.state

import ch.alni.circuitbreaker.ExceptionFilter

/**
 * A bucket that can be overflowed.
 */
class Bucket {
    private final int maxNumberOfAttempts;
    private final ExceptionFilter filter;

    private int countedEvents = 0;

    Bucket(int maxNumberOfAttempts, ExceptionFilter filter) {
        this.maxNumberOfAttempts = maxNumberOfAttempts
        this.filter = filter
    }

    /**
     * Throws a new exception in this bucket.
     *
     * @param e exception to be analysed
     */
    void emit(Exception e) {
        if (filter.isInteresting(e)) {
            countedEvents++;
        }
    }

    boolean isLeaking() {
        countedEvents >= maxNumberOfAttempts;
    }

    int getCountedEvents() {
        return countedEvents
    }
}

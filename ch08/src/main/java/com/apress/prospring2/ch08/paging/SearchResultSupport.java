package com.apress.prospring2.ch08.paging;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author janm
 */
public abstract class SearchResultSupport<T> implements Iterable<T> {
    private Collection<? super T> result;
    private long totalResults;

    @SuppressWarnings({"unchecked"})
    public Iterator<T> iterator() {
        return (Iterator<T>) this.result.iterator();
    }

    public Collection<? super T> getResult() {
        return result;
    }

    public void setResult(Collection<? super T> result) {
        this.result = result;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }
}

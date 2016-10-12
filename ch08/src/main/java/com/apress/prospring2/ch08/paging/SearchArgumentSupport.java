package com.apress.prospring2.ch08.paging;

/**
 * @author janm
 */
public abstract class SearchArgumentSupport {
    private int firstResult;
    private Integer maxResults;

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}

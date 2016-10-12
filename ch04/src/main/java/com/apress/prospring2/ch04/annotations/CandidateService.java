package com.apress.prospring2.ch04.annotations;

/**
 * @author janm
 */
public class CandidateService {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CandidateService");
        sb.append("{}");
        return sb.toString();
    }
}

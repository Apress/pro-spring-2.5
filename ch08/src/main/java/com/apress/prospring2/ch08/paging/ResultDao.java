package com.apress.prospring2.ch08.paging;

/**
 * @author janm
 */
public interface ResultDao {

    SearchResultSupport search(ResultSearchArgument a);

}

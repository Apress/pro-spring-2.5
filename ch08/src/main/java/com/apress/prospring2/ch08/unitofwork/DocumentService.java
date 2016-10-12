package com.apress.prospring2.ch08.unitofwork;

import java.util.List;

/**
 * @author janm
 */
public interface DocumentService {

    Long begin();

    DocumentUploadResult upload(long id, byte[] content);

    DocumentUploadResult setCategories(long id, List<Category> categories);

    DocumentUploadResult setHeadline(long id, String headline);

    DocumentUploadResult commit(long id, boolean synchronous);

    void abandon(long id);

}

package com.apress.prospring2.ch08.unitofwork;

import java.util.List;

/**
 * @author janm
 */
public interface DocumentUploadTransactionDao {

    void save(DocumentUploadTransaction transaction);

    void delete(long id);

    DocumentUploadTransaction getById(long id);

    List<DocumentUploadTransaction> getAllUnprocessed();

}

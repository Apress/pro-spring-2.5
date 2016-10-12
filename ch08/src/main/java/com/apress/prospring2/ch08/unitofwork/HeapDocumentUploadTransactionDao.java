package com.apress.prospring2.ch08.unitofwork;

import java.util.*;

/**
 * @author janm
 */
public class HeapDocumentUploadTransactionDao implements DocumentUploadTransactionDao {
    private Map<Long, DocumentUploadTransaction> data =
            Collections.synchronizedMap(new HashMap<Long, DocumentUploadTransaction>());

    public void save(DocumentUploadTransaction transaction) {
        long id = this.data.size() + 1;
        transaction.setId(id);
        this.data.put(id, transaction);
    }

    public void delete(long id) {
        this.data.remove(id);
    }

    public DocumentUploadTransaction getById(long id) {
        return this.data.get(id);
    }

    public synchronized List<DocumentUploadTransaction> getAllUnprocessed() {
        List<DocumentUploadTransaction> result = new LinkedList<DocumentUploadTransaction>();
        for (DocumentUploadTransaction t : this.data.values()) {
            if (t.isUnprocessed()) result.add(t);
        }
        return result;
    }
}

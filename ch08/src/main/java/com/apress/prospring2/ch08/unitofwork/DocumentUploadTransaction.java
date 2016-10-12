package com.apress.prospring2.ch08.unitofwork;

import java.util.List;

/**
 * @author janm
 */
public class DocumentUploadTransaction {
    private Long id;
    private byte[] content;
    private String headline;
    private List<Category> categories;
    private boolean unprocessed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public boolean isUnprocessed() {
        return unprocessed;
    }

    public void setUnprocessed(boolean unprocessed) {
        this.unprocessed = unprocessed;
    }
}

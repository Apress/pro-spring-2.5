package com.apress.prospring2.ch17.web.product;

import com.apress.prospring2.ch17.domain.Product;

/**
 * @author Aleksa Vukotic
 */
public class ProductImageForm extends Product {

    private String name;
    private byte[] contents;

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
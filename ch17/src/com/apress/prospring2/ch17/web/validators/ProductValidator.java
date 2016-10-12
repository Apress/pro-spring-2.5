package com.apress.prospring2.ch17.web.validators;

import com.apress.prospring2.ch17.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Aleksa Vukotic
 */
public class ProductValidator implements Validator {

    public boolean supports(Class clazz) {
        return clazz.isAssignableFrom(Product.class);
    }

    public void validate(Object obj, Errors errors) {
        Product product = (Product) obj;
        if (product.getName() == null || product.getName().length() == 0) {
            errors.rejectValue("name", "required", "");
        }
    }

}
package com.apress.prospring2.ch17.web.product;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aleksa Vukotic
 */
public class ProductImageFormController extends SimpleFormController {

    public ProductImageFormController() {
        super();
        setCommandClass(ProductImageForm.class);
        setFormView("products-image");
        setCommandName("product");
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
                                    HttpServletResponse response, Object command,
                                    BindException errors) throws Exception {
        ProductImageForm form = (ProductImageForm) command;

        System.out.println(form.getName());
        byte[] contents = form.getContents();
        for (int i = 0; i < contents.length; i++) {
            System.out.print(contents[i]);
        }

        return new ModelAndView("products-index-r");
    }

    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(byte[].class,
                new ByteArrayMultipartFileEditor());
    }

}
package com.apress.prospring2.ch17.web.product;

import com.apress.prospring2.ch17.domain.Product;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Aleksa Vukotic
 */
public class ProductFormController extends SimpleFormController {

    public ProductFormController() {
        super();
        setCommandClass(Product.class);
        setCommandName("product");
        setFormView("products-edit");
    }

    protected ModelAndView onSubmit(HttpServletRequest request,
                                    HttpServletResponse response, Object command,
                                    BindException errors) throws Exception {
        System.out.println(command);

        return new ModelAndView("products-index-r");
    }

    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,
                new CustomDateEditor(dateFormat, false));
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Product command = new Product();
        Long productId = ServletRequestUtils.getLongParameter(request, "productId", 0);
        if (productId != 0) {
            // load the product
            command.setId(productId);
            command.setName("loaded");
        }

        return command;
    }

}
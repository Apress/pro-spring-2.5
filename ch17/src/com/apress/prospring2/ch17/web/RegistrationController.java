package com.apress.prospring2.ch17.web;

import com.apress.prospring2.ch17.domain.Product;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springframework.validation.Errors;
import org.springframework.validation.BindException;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationController extends AbstractWizardFormController {

    public RegistrationController() {
        setPages(new String[] {"registration-step1", "registration-step2",
            "registration-finish"});
        setSessionForm(true);
        setCommandClass(Product.class);
    }

    protected ModelAndView processFinish(HttpServletRequest request,
        HttpServletResponse response, Object command,
        BindException errors) throws Exception {
        Product product = (Product)command;

        System.out.println("Register " + product);
        return null;
    }

    protected void initBinder(HttpServletRequest request,
        ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,
            new CustomDateEditor(dateFormat, false));
    }

    protected void validatePage(Object command, Errors errors, int page,
        boolean finish) {
        getValidator().validate(command, errors);
    }
}


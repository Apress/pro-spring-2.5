package com.apress.prospring2.ch17.web.product;

import com.apress.prospring2.ch17.domain.Product;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Aleksa Vukotic
 */
public class ProductController extends MultiActionController {

    public ModelAndView view(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        response.getOutputStream().print("Viewing product " +
                request.getParameter("productId"));

        return null;
    }


    private List products;

    private Product createProduct(Long productId, String name, Date expirationDate) {
        Product product = new Product();
        product.setId(productId);
        product.setName(name);
        product.setExpirationDate(expirationDate);

        return product;
    }

    public ProductController() {
        products = new ArrayList();
        Date today = new Date();
        products.add(createProduct(1L, "test", today));
        products.add(createProduct(2L, "Pro Spring 2", today));
        products.add(createProduct(3L, "Pro Velocity", today));
        products.add(createProduct(4L, "Pro Ajax", today));
    }

    public ModelAndView index(HttpServletRequest request,
                              HttpServletResponse response) {

        return new ModelAndView("products-index", "products", products);
    }

    public ModelAndView indexHandler(HttpServletRequest request,
                              HttpServletResponse response) {

        return new ModelAndView("products-index", "products", products);
    }

    public ModelAndView reportHandler(HttpServletRequest request,
                              HttpServletResponse response) {
        String format = request.getParameter("format");  
        Map model = new HashMap();

           JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(products);
		model.put("products", source);
        model.put("format", format);
        return new ModelAndView("products-report", model);
    }
    public ModelAndView viewHandler(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        return new ModelAndView("products-view", "product", products.get(0));
    }
}
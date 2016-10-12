package com.apress.prospring2.ch17.web.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import com.apress.prospring2.ch17.domain.Product;

/**
 * Created by aleksav
**/

@Controller
@RequestMapping("/product/edit.html")
@SessionAttributes("product")
public class ProductFormController2 {


//	@Autowired
//	private ProductService productService;

	@ModelAttribute("types")
	public Collection<String> populateProductTypes() {
        List<String> types = new ArrayList<String>();
        types.add("Books");
        types.add("CDs");
        types.add("MP3 Players");

        return types;
    }

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("productId") int productId, ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "products-edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("product")Product product, BindingResult result,
			SessionStatus status) {

	    System.out.println(product);

        return "products-index";
	}

}

package com.apress.prospring2.ch21.web;

import com.apress.prospring2.ch17.web.product.ProductImageFormController;
import junit.framework.TestCase;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author aleksav
 */
public class ProductImageFormControllerTests extends TestCase {
    private ProductImageFormController controller;

    public void testOnSubmit()throws Exception{
        controller = new ProductImageFormController();
        MockMultipartHttpServletRequest mockRequest = new MockMultipartHttpServletRequest();
        mockRequest.setMethod("POST");

        MockMultipartFile file = new MockMultipartFile("contents", new byte[] {1,2,1,2,23,});
        mockRequest.addFile(file);
        mockRequest.addParameter("name", "test");

        MockHttpServletResponse mockResponse = new MockHttpServletResponse();
        ModelAndView mav = controller.handleRequest(mockRequest, mockResponse);
        assertNotNull("ModelAndView returned must not ne null!", mav);
        assertEquals("Wrong view returned", "products-index-r", mav.getViewName());

    }
}

package com.apress.prospring2.ch21.web.tag;

import com.apress.prospring2.ch17.web.tag.HelloTag;
import junit.framework.TestCase;
import org.springframework.mock.web.*;

import javax.servlet.jsp.tagext.Tag;

/**
 * @author aleksav
 */
public class HelloTagTests extends TestCase {
    public void testOutput() throws Exception{
        Tag tag  = new HelloTag();
        MockServletContext mockServletContext = new MockServletContext("E:\\sandbox\\prospring2\\bookcode\\ch17\\exploded");
        MockHttpServletResponse mockResponse = new MockHttpServletResponse();
        MockHttpServletRequest mockRequest = new MockHttpServletRequest();
        MockJspWriter mockJspWriter = new MockJspWriter(mockResponse);
        MockPageContext mockPageContext = new MockPageContext(mockServletContext, mockRequest, mockResponse);
        
        tag.setPageContext(mockPageContext);

        tag.doStartTag();

        System.out.println();

    }
}

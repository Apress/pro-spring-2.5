package com.apress.prospring2.ch15.remoting.jaxrpc;

import com.apress.prospring2.ch15.remoting.MessageBean;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.springframework.remoting.jaxrpc.JaxRpcPortProxyFactoryBean;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.TypeMapping;
import javax.xml.rpc.encoding.TypeMappingRegistry;


/**
 * @author aleksav
 */
public class MessageServiceJaxRpcProxyFactoryBean extends
        JaxRpcPortProxyFactoryBean {

    protected void postProcessJaxRpcService(Service service) {
        TypeMappingRegistry tmr = service.getTypeMappingRegistry();
        TypeMapping tm = tmr.createTypeMapping();

        QName qname = new QName("http://www.apress.com", "MessageBean");

        tm.register(MessageBean.class, qname,
                new BeanSerializerFactory(MessageBean.class, qname),
                new BeanDeserializerFactory(MessageBean.class, qname));

        tmr.register("http://schemas.xmlsoap.org/soap/encoding/", tm);
    }
}

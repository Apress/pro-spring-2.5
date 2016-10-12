package com.apress.prospring2.ch03.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.*;

/**
 * @author janm
 */
public class CollectionsDemo {
    private Map map;
    private Properties props;
    private Set set;
    private List list;

    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(
                            new ClassPathResource("/META-INF/spring/collectionsdemo1-context.xml"));
        CollectionsDemo instance = (CollectionsDemo)factory.getBean("collectionsDemo");
        instance.displayInfo();
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void displayInfo() {

        // display the Map
        Iterator i = map.keySet().iterator();

        System.out.println("Map contents:\n");
        while (i.hasNext()) {
            Object key = i.next();
            System.out.println("Key: " + key + " - Value: " + map.get(key));
        }

        // display the properties
        i = props.keySet().iterator();
        System.out.println("\nProperties contents:\n");
        while (i.hasNext()) {
            String key = i.next().toString();
            System.out.println("Key: " + key + " - Value: "
                    + props.getProperty(key));
        }

        // display the set
        i = set.iterator();
        System.out.println("\nSet contents:\n");
        while (i.hasNext()) {
            System.out.println("Value: " + i.next());
        }

        // display the list
        i = list.iterator();
        System.out.println("\nList contents:\n");
        while (i.hasNext()) {
            System.out.println("Value: " + i.next());
        }
    }

}

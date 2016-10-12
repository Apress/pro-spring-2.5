package com.apress.prospring2.mock;

import junit.framework.TestCase;
import org.jmock.core.InvocationMatcher;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContext;
import org.springframework.util.FileCopyUtils;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import javax.naming.spi.NamingManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;

/**
 * @author janm
 */
public abstract class TestUtils {

	/**
	 * Asserts that the collection container contains all contained items
	 * @param message Message for failure
	 * @param container The container, must contain all contained items, but may contain more items
	 * @param contained The contained items
	 */
	public static <T> void assertContains(final String message, final Collection<T> container, final T... contained) {
		if (container == null && contained == null) return;
		if (container == null/* && contained != null*/) TestCase.fail(message + "; Null container.");
		for (T t1 : contained) {
			boolean found = false;
			for (T t2 : container) {
				if (t1.equals(t2)) {
					found = true;
					break;
				}
			}
			if (!found) TestCase.fail(message + "; Container does not contain all contained items.");
		}
	}

	/**
	 * Asserts that the collection container contains exactly all contained items
	 * @param message Message for failure
	 * @param container The container, must contain all contained items, may not contain more items
	 * @param contained The contained items
	 */
	public static <T> void assertEquals(final String message, final Collection<T> container, final T... contained) {
		if (container == null && contained == null) return;
		if (container == null/* && contained != null*/) TestCase.fail(message + "; Null container.");
		if (container.size() != contained.length) TestCase.fail(message + "; not equal lengths.");
		assertContains(message, container, contained);
	}

	/**
	 * Asserts that the collections l and r contain exactly the same items; the items do not need to appear in the
	 * same order.
	 * @param message Message for failure
	 * @param l The left collection
	 * @param r The right collection
	 */
	public static <T> void assertCollectionsEqual(final String message, final Collection<T> l, final Collection<? extends T> r) {
		if (l == null && r == null) return;
		if (l == null/* && r != null*/) TestCase.fail(message + "; Null L collection.");
		if (l.size() != r.size()) TestCase.fail(message + "; not equal lengths.");
		for (T left : l) {
			boolean found = false;
			for (T right : r) {
				if (right.equals(left)) {
					found = true;
					break;
				}
			}
			if (!found) TestCase.fail(message + "; missing " + l + " in R collection.");
		}
	}

	public static byte[] getResourceContent(Class<?> clazz, String resourceName) throws IOException {
        return FileCopyUtils.copyToByteArray(clazz.getResourceAsStream(resourceName));
    }

	/**
	 * Asserts that the collection container does not contain any of the contained items
	 * @param message Message for failure
	 * @param container The container, must not contain any contained items, but may contain other items
	 * @param contained The contained items
	 */
	public static <T> void assertNotContains(final String message, final Collection<T> container, final T... contained) {
		if (container == null && contained == null) return;
		if (container == null/* && contained != null*/) TestCase.fail(message + "; Null container.");
		for (T t1 : container) {
			for (T t2 : contained) {
				if (t1.equals(t2)) {
					TestCase.fail(message + "; Container contains contained item.");
				}
			}
		}
	}

	/**
	 * Asserts that the two arrays container and contained are the same
	 * @param message The message for falure
	 * @param container The l array
	 * @param contained The r array
	 */
	public static void assertEquals(final String message, final Object[] container, final Object... contained) {
		if (container == null && contained == null) return;
		if (container == null/* && contained != null*/) TestCase.fail(message + "; Null container.");
		if (container.length != contained.length) TestCase.fail(message + "; not equal lengths.");
		assertCollectionsEqual(message, Arrays.asList(container), Arrays.asList(contained));
	}

	/**
	 * Gets the content of the Class resource of class <code>clazz</code> named <code>resourceName</code>
	 * @param clazz The class
	 * @param resourceName The resource name
	 * @return The content of the resource as String
	 * @throws IOException If the resource cannot be read
	 */
	public static String getResourceAsString(final Class<?> clazz, final String resourceName) throws IOException {
		InputStream resourceStream = clazz.getResourceAsStream(resourceName);
		if (resourceStream == null) TestCase.fail("Resource stream is null.");
		return FileCopyUtils.copyToString(new InputStreamReader(resourceStream));
	}

    /**
     * Returns an InvocationMatcher with the specified number of expected invocations
     * @param count The expected invocation count
     * @return The InvocationMatcher instance
     */
    public static InvocationMatcher times(int count) {
        return new InvokeTimesMatcher(count);
    }

    public static class NamingContextBuilder implements InitialContextFactoryBuilder {

        /** An instance of this class bound to JNDI */
        private static NamingContextBuilder activated;


        /**
         * Checks if a SimpleNamingContextBuilder is active.
         * @return the current SimpleNamingContextBuilder instance,
         * or <code>null</code> if none
         */
        public static NamingContextBuilder getCurrentContextBuilder() {
            return activated;
        }

        /**
         * If no SimpleNamingContextBuilder is already configuring JNDI,
         * createOrUpdate and activate one. Otherwise take the existing activate
         * SimpleNamingContextBuilder, clear it and return it.
         * <p>This is mainly intended for test suites that want to
         * reinitialize JNDI bindings from scratch repeatedly.
         * @return an empty SimpleNamingContextBuilder that can be used
         * to control JNDI bindings
         * @throws javax.naming.NamingException .
         */
        public static NamingContextBuilder emptyActivatedContextBuilder() throws NamingException {
            if (activated != null) {
                // Clear already activated context builder.
                activated.clear();
            }
            else {
                // Create and activate new context builder.
                NamingContextBuilder builder = new NamingContextBuilder();
                // The activate() call will cause an assigment to the activated variable.
                builder.activate();
            }
            return activated;
        }


        @SuppressWarnings({"CollectionDeclaredAsConcreteClass"})
		private final Hashtable<String, Object> boundObjects = new Hashtable<String, Object>();


        /**
         * Register the context builder by registering it with the JNDI NamingManager.
         * Note that once this has been done, <code>new InitialContext()</code> will always
         * return a context from this factory. Use the <code>emptyActivatedContextBuilder()</code>
         * static method to get an empty context (for example, in test methods).
         * @throws IllegalStateException if there's already a naming context builder
         * registered with the JNDI NamingManager
         * @throws javax.naming.NamingException .
         */
        public void activate() throws IllegalStateException, NamingException {
            if (!NamingManager.hasInitialContextFactoryBuilder()) NamingManager.setInitialContextFactoryBuilder(this);
            activated = this;
        }

        /**
         * Clear all bindings in this context builder.
         */
        public void clear() {
            this.boundObjects.clear();
        }

        /**
         * Bind the given object under the given name, for all naming contexts
         * that this context builder will generate.
         * @param name the JNDI name of the object (e.g. "java:comp/env/jdbc/myds")
         * @param obj the object to bind (e.g. a DataSource implementation)
         */
        public void bind(String name, Object obj) {
            this.boundObjects.put(name, obj);
        }

        /**
         * Simple InitialContextFactoryBuilder implementation,
         * creating a new SimpleNamingContext instance.
         * @see org.springframework.mock.jndi.SimpleNamingContext
         */
        public InitialContextFactory createInitialContextFactory(Hashtable environment) {
            return new InitialContextFactory() {
                public Context getInitialContext(Hashtable environment) {
                    return new SimpleNamingContext("", boundObjects, environment);
                }
            };
        }

    }


    public static void buildNamingContext() {
        try {
            NamingContextBuilder builder;
            builder = NamingContextBuilder.emptyActivatedContextBuilder();

            String connectionString = System.getenv("BPB_ASIT_CONNECTION_STRING");
            if (connectionString == null) {
                connectionString = "jdbc:oracle:thin:@oracle.devcake.co.uk:1521:INTL";
            }

            builder.bind("java:comp/env/jdbc/bpb", new DriverManagerDataSource("oracle.jdbc.driver.OracleDriver", connectionString, "BPB", "Gen0me64"));
        } catch (NamingException e) {
            // noop
        }
    }

}

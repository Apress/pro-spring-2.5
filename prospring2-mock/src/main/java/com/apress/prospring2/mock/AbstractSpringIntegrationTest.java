package com.apress.prospring2.mock;

import org.hibernate.SessionFactory;
import org.jmock.MockObjectTestCase;
import org.jmock.core.Constraint;
import org.jmock.core.InvocationMatcher;
import org.jmock.core.Stub;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author janm
 */
public abstract class AbstractSpringIntegrationTest extends AbstractTransactionalSpringContextTests {
	@SuppressWarnings({"JUnitTestCaseWithNoTests"})
	private MockObjectTestCase mockObjectTestCase = new MockObjectTestCase() { };
	protected SessionFactory hibernateSessionFactory;
	protected DataSource dataSource;

    protected void doOnSetUpInTransaction() throws Exception {
        // noop
    }

    protected final void onSetUpInTransaction() throws Exception {
        doOnSetUpInTransaction();
    }

    /**
	 * Subclasses may override this method to return additional config locations
	 * @return The additional config locations
	 */
	protected String[] getExtraConfigLocations() {
		return null;
	}

	protected InvocationMatcher once() {
		return mockObjectTestCase.once();
	}

	protected InvocationMatcher atLeastOnce() {
		return mockObjectTestCase.atLeastOnce();
	}

	protected Constraint eq(Object value) {
		return mockObjectTestCase.eq(value);
	}

	protected Constraint eq(long value) {
		return mockObjectTestCase.eq(value);
	}

	protected Stub returnValue(Object value) {
		return mockObjectTestCase.returnValue(value);
	}

	protected Stub returnValue(boolean value) {
		return mockObjectTestCase.returnValue(value);
	}

	protected Stub throwException(Throwable t) {
		return mockObjectTestCase.throwException(t);
	}

	@Override
	protected final String[] getConfigLocations() {
		TestUtils.buildNamingContext();

		List<String> configLocations = new ArrayList<String>();
		String[] extraConfigLocations = getExtraConfigLocations();
		if (extraConfigLocations != null) {
			configLocations.addAll(Arrays.asList(extraConfigLocations));
		}

		return configLocations.toArray(new String[configLocations.size()]);
	}


	public final void setDataSource(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public final void setHibernateSessionFactory(final SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
		this.hibernateSessionFactory.getAllClassMetadata();
		this.hibernateSessionFactory.getAllCollectionMetadata();
	}
}

package com.apress.prospring2.ch22.domain;

import java.io.Serializable;

/**
 * @author janm
 */
public abstract class AbstractIdentityVersionedObject<T> implements Serializable {
	protected Long version;
	protected T id;

	public AbstractIdentityVersionedObject() {

	}

	public AbstractIdentityVersionedObject(T id) {
		this.id = id;
	}

	protected final boolean idEquals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		//noinspection CastToConcreteClass
		final AbstractIdentityVersionedObject that = (AbstractIdentityVersionedObject) o;

		if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;
		//noinspection RedundantIfStatement
		if (this.version != null ? !this.version.equals(that.version) : that.version != null) return false;

		return true;
	}

	protected final int idHashCode() {
		int result = super.hashCode();
		result = 31 * result + (this.version != null ? this.version.hashCode() : 0);
		result = 31 * result + (this.id != null ? this.id.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(final Object o) {
		return idEquals(o);
	}

	@Override
	public int hashCode() {
		return idHashCode();
	}

	public T getId() {
		return id;
	}

	public void setId(final T id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(final Long version) {
		this.version = version;
	}
}
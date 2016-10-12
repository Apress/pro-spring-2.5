package com.apress.prospring2.ch17.domain;

/**
 * @author Aleksa Vukotic
 */
public class AbstractIdentityObject<T> {
    protected T id;

    public AbstractIdentityObject() {

    }

    public AbstractIdentityObject(T id) {
        this.id = id;
    }

    protected final boolean idEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        //noinspection CastToConcreteClass
        final AbstractIdentityObject that = (AbstractIdentityObject) o;

        //noinspection RedundantIfStatement
        if (this.id != null ? !this.id.equals(that.id) : that.id != null) return false;

        return true;
    }

    protected final int idHashCode() {
        int result = super.hashCode();
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

}

package com.robertsmieja.test.utils.junit;

import java.lang.reflect.InvocationTargetException;

public class SimplePojoTests implements EqualsTests<SimplePojo>, GettersAndSettersTests<SimplePojo>, HashCodeTests<SimplePojo>, ToStringTests<SimplePojo> {
    @Override
    public Class<SimplePojo> getTypeClass() {
        return SimplePojo.class;
    }

    @Override
    public SimplePojo createValue() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return SimplePojo.createValue();
    }

    @Override
    public SimplePojo createDifferentValue() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return SimplePojo.createDifferentValue();
    }
}
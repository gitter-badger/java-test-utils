/*
 *    Copyright 2017 Robert Smieja
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.robertsmieja.test.utils.junit;

import com.robertsmieja.test.utils.junit.AllBasicTests;
import com.robertsmieja.test.utils.junit.domain.ComplexPojo;

import java.lang.reflect.InvocationTargetException;

public class ComplexPojoTests implements AllBasicTests<ComplexPojo>{

    @Override
    public Class<ComplexPojo> getTypeClass() {
        return ComplexPojo.class;
    }

    @Override
    public ComplexPojo createValue() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return new ComplexPojo();
    }

    @Override
    public ComplexPojo createDifferentValue() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        ComplexPojo value = new ComplexPojo();
        value.setLongValue(2L);
        value.setIntegerValue(1);
        value.setStringValue("String");
        value.setBooleanValue(true);
        value.setBigBooleanValue(true);
        return value;
    }
}
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static com.robertsmieja.test.utils.junit.Internal.defaultCreateValueImplementation;

/**
 * A base interface that defines the following methods:
 * <ul>
 * <li> getTypeClass() which returns the class under test's Class </li>
 * <li> createValue() which returns an instance of the class under test </li>
 * <li> createDifferentValue() which returns an instance of the class under test, with different values in each field </li>
 * </ul>
 * By default it will attempt to use a no-arg constructor to create for the createValue() and createDifferentValue() methods
 *
 * @param <T> The class under test
 *
 * @since 1.0.0
 */
public interface TestProducer<T> {
    //TODO find a way to get the class without requiring the implementing class to have a new method
    Class<T> getTypeClass();

    //TODO find a way to intelligently create values of the class under test
    default T createValue() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return defaultCreateValueImplementation(getTypeClass());
    }

    default T createDifferentValue() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return defaultCreateValueImplementation(getTypeClass());
    }

    @Test
    @DisplayName("Can create values successfully")
    default void canCreateValuesSuccessfully() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        T value = createValue();
        T differentValue = createDifferentValue();

        Assertions.assertNotNull(value);
        Assertions.assertNotNull(differentValue);
    }
}

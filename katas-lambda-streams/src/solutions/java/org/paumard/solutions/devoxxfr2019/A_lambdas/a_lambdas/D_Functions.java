/*
 * Copyright (C) 2019 José Paumard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.paumard.solutions.devoxxfr2019.A_lambdas.a_lambdas;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the Function interface.
 * Some exercises also cover function chaining and composition.
 */
public class D_Functions {

    /**
     * Write a lambda expression that converts the
     * given string to upper case. Try to write this lambda
     * as a method reference.
     */
    @Test
    public void d_function01() {

        Function<String, String> func = String::toUpperCase;

        assertThat(func.apply("abc")).isEqualTo("ABC");
    }

    /**
     * Write a lambda expression that wraps the given
     * string in parentheses.
     */
    @Test
    public void d_function02() {

        Function<String, String> func = s -> "(" + s + ")";

        assertThat(func.apply("abc")).isEqualTo("(abc)");
    }

    /**
     * Write a lambda expression that returns the length of the
     * given String. Try to write this lambda as a method reference.
     */
    @Test
    public void d_function03() {

        Function<String, Integer> func = String::length;

        assertThat(func.apply("")).isEqualTo(0);
        assertThat(func.apply("Hello!")).isEqualTo(6);
    }

    /**
     * Write a lambda expression that returns an empty String
     * if the given string is null, and the given string otherwise.
     */
    @Test
    public void d_function04() {

        Function<String, String> func = s -> s == null ? "" : s;

        assertThat(func.apply(null)).isEqualTo("");
        assertThat(func.apply("")).isEqualTo("");
        assertThat(func.apply("Hello")).isEqualTo("Hello");
    }

    /**
     * Write a lambda expression that returns the length of the given
     * String if it is not null, and 0 if the given String is null.
     * Try using the a_lambdas written in d_function3() and d_function4()
     */
    @Test
    public void d_function05() {

        Function<String, Integer> func03 = String::length;
        Function<String, String> func04 = s -> s == null ? "" : s;

        Function<String, Integer> func = func03.compose(func04);
        // you can also call func04.andThen(func03)

        assertThat(func.apply(null)).isEqualTo(0);
        assertThat(func.apply("")).isEqualTo(0);
        assertThat(func.apply("Hello")).isEqualTo(5);
    }

    /**
     * Write a lambda expression that, given two strings, returns the result
     * of concatenating the first with the second, followed by the
     * first again.
     */
    @Test
    public void d_function06() {

        BiFunction<String, String, String> bifunc = (s1, s2) -> s1 + s2 + s1;

        assertThat(bifunc.apply("-", "Hello")).isEqualTo("-Hello-");
    }

    /**
     * Write a lambda expression that returns the index of
     * the first occurrence of the second string within the first string,
     * or -1 if the second string doesn't occur within the first string.
     * Try to write this lambda using a method reference.
     */
    @Test
    public void d_function07() {

        BiFunction<String, String, Integer> bifunc = String::indexOf;

        assertThat(bifunc.apply("Hello world", "Hello")).isEqualTo(0);
        assertThat(bifunc.apply("Hello world", "world")).isEqualTo(6);
    }

    /**
     * Write a lambda expression that returns the index of
     * the first occurrence of the given string within the string
     * "Hello world", or -1 if the given string is not found.
     * Try to write this lambda using a method reference.
     */
    @Test
    public void d_function08() {

        String pattern = "Hello world!";
        Function<String, Integer> func = pattern::indexOf;

        assertThat(func.apply("Hello")).isEqualTo(0);
        assertThat(func.apply("world")).isEqualTo(6);
    }

    /**
     * Write a lambda expression that returns the index of
     * the first occurrence of the given string within the string
     * "Hello world", or -1 if the given string is not found.
     * Try to write this lambda as a partial application of the
     * lambda you wrote in d_function07().
     */
    @Test
    public void d_function09() {

        BiFunction<String, String, Integer> bifunc07 = String::indexOf;

        String pattern = "Hello world!";

        Function<String, Integer> func = s -> bifunc07.apply(pattern, s);

        assertThat(func.apply("Hello")).isEqualTo(0);
        assertThat(func.apply("world")).isEqualTo(6);
    }

}

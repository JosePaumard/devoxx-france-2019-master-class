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

package org.paumard.devoxxfr2019.tdd.D_rpncalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a classical TDD Kata, made to practice TDD at a intermediate level. This kata is a good way to
 * practice the implementation of the Strategy pattern. The good news id that the tests have
 * already been written. The rule is the following: write the simplest code to make the test pass one by one,
 * in the order they appear in this class. Remember: you need to find the minimal code that will one test pass
 * at a time!
 * <p/>
 * The RPN Calculator Kata
 * <p/>
 * A RPN calculator program computes expressions written in RPN (Reverse Polish Notation).
 * <p/>
 * A RPN expression (or a postfix expression) is one of the following:
 * <ul> a number X, in which case the value of the expression is that of X;</ul>
 * <ul> a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an  arithmetic operation;
 * in this case, the value of the expression is that of  E1 O E2</ul>
 * <p/>
 * The following are RPN expressions:
 * <ul><code>1</code> => <code>1</code></ul>
 * <ul><code>1 2 +</code> => <code>(1 + 2) = 3</code></ul>
 * <ul><code>20 5 /</code> => <code>(20 / 5) = 4</code></ul>
 * <ul><code>4 2 + 3 -</code> => <code>(4 + 2) - 3 = 3</code></ul>
 * <ul><code>3 5 8 * 7 + *</code> => <code>3*((5*8) + 7) = 141</code></ul>
 * Once this calculator works, add the <code>SQRT</code> operator. We will keep things simple and support only
 * integer square roots, like SQRT(4), SQRT(9), SQRT(16), etc...
 * <ul><code>9 SQRT</code> => <code>3</code></ul>
 * <ul><code>3 9 SQRT +</code> => <code>(3 + SQRT(9)) = 6</code></ul>
 * Once the <code>SQRT</code> operator has been added, add the <code>MAX</code> operator:
 * <ul><code>5 8 1 4 2 MAX</code> => <code>8</code></ul>
 * <ul><code>5 8 1 4 2 MAX 8 + SQRT</code> => <code>SQRT(MAX(5, 8, 4, 1, 2) + 8) = 4</code></ul>
 */
public class RPNCalculatorTest {

    @Test
    public void should_compute_1_for_input_1() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "1";
        int expectedResult = 1;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_2_for_input_2() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "2";
        int expectedResult = 2;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_2_for_input_1_1_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "1 1 +";
        int expectedResult = 2;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_3_for_input_1_2_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "1 2 +";
        int expectedResult = 3;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_4_for_input_1_3_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "1 3 +";
        int expectedResult = 4;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_3_for_input_2_1_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "2 1 +";
        int expectedResult = 3;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_4_for_input_3_1_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 1 +";
        int expectedResult = 4;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_12_for_input_2_10_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "2 10 +";
        int expectedResult = 12;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_13_for_input_2_11_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "2 11 +";
        int expectedResult = 13;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_21_for_input_10_11_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "10 11 +";
        int expectedResult = 21;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_22_for_input_11_11_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "10 11 +";
        int expectedResult = 21;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_7_for_input_30_23_SUB() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "30 23 -";
        int expectedResult = 7;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_36_for_input_12_3_MULT() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "12 3 *";
        int expectedResult = 36;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_5_for_input_15_3_DIV() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "15 3 /";
        int expectedResult = 5;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_3_for_input_4_2_ADD_3_SUB() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "4 2 + 3 -";
        int expectedResult = 3;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_141_for_input_3_5_8_MULT_7_ADD_MULT() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 5 8 * 7 + *";
        int expectedResult = 141;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_3_for_input_9_SQRT() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "9 SQRT";
        int expectedResult = 3;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_6_for_input_3_9_SQRT_ADD() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "3 9 SQRT +";
        int expectedResult = 6;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_8_for_input_5_8_1_4_2_MAX() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "5 8 1 4 2 MAX";
        int expectedResult = 8;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_compute_4_for_input_5_8_1_4_2_MAX_8_ADD_SQRT() {

        // Given
        RPNCalculator calculator = new RPNCalculator();
        String input = "5 8 1 4 2 MAX 8 + SQRT";
        int expectedResult = 4;

        // When
        int result = calculator.compute(input);

        // Then
        assertThat(result).isEqualTo(expectedResult);
    }
}

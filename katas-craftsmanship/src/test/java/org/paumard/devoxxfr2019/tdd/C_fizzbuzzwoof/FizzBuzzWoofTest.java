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

package org.paumard.devoxxfr2019.tdd.C_fizzbuzzwoof;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a quite simple TDD Kata, made to practice TDD at a beginner level. The good news id that the tests have
 * already been written. The rule is the following: write the simplest code to make the test pass one by one,
 * in the order they appear in this class. Remember: you need to find the minimal code that will one test pass
 * at a time!
 * <p/>
 * The FizzBuzzWoof Kata
 * <p/>
 * Our startup The FizzBuzzWoof Factory really wants to make a difference with the old fashioned guys from the
 * FizzBuzz Inc. So we are going to add the following features to our product.
 * <p/>
 * We keep the original rules, so a number divisible by 3 is replaced with <code>Fizz</code>. But we go one step
 * further: everytime a 3 is met in a number, we add <code>Fizz</code> to the replaced number. Here are some examples:
 * <ul><code>6</code> => </code>Fizz</code> (divisible by 3)</ul>
 * <ul></code>3</code> => </code>FizzFizz</code> (divisible by 3, contains a 3)</ul>
 * <p/>
 * Then we do the same for 5 and <code>Buzz</code>. Here are some more examples:
 * <ul><code>10</code> => <code>Buzz</code> (divisible by 5)</ul>
 * <ul><code>5</code> => <code>BuzzBuzz</code> (divisible by 5, contains a 5)</ul>
 * <p/>
 * And of course we support both at the same time:
 * <ul><code>15</code> => <code>FizzBuzzBuzz</code> (divisible by 3, divisible by 5, contains a 5)</ul>
 * <ul><code>2535</code> => <code>FizzBuzzBuzzFizzBuzz</code> (divisible by 3, divisible by 5, contains a 5,
 * then a 3, then a 5)</ul>
 * <p/>
 * And then to really make a difference on our market, we need to support the 7, replaced with <code>Woof</code>.
 * <ul><code>35</code> => <code>BuzzWoofFizzBuzz</code> (divisible by 5, divisible by 7, contains 3, contains 5)</ul>
 * <p/>
 * At last, a strategic requirement came from the market guys. We need to keep track of the 0 in the incoming numbers
 * for a very important customer. Each 0 should be replaced by a star <code>*</code>. Here are some examples:
 * <p/>
 * <ul><code>10</code> => <code>Buzz*</code></ul>
 * <ul><code>30</code> => <code>FizzFizz*</code></ul>
 * <ul><code>3105</code> => <code>FizzBuzzFizz*Buzz</code></ul>
 */
public class FizzBuzzWoofTest {

    @Test
    public void should_return_1_for_1() {

        // Given
        int input = 1;
        String expectedOuput = "1";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_2_for_2() {

        // Given
        int input = 2;
        String expectedOuput = "2";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Fizz_for_6() {

        // Given
        int input = 6;
        String expectedOuput = "Fizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Fizz_for_9() {

        // Given
        int input = 9;
        String expectedOuput = "Fizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Buzz_Star_for_10() {

        // Given
        int input = 10;
        String expectedOuput = "Buzz*";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Buzz_Star_for_20() {

        // Given
        int input = 20;
        String expectedOuput = "Buzz*";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Woof_for_14() {

        // Given
        int input = 14;
        String expectedOuput = "Woof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Woof_for_28() {

        // Given
        int input = 28;
        String expectedOuput = "Woof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzz_Star_for_60() {

        // Given
        int input = 60;
        String expectedOuput = "FizzBuzz*";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzWoof_for_21() {

        // Given
        int input = 21;
        String expectedOuput = "FizzWoof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_BuzzWoofStar_for_140() {

        // Given
        int input = 140;
        String expectedOuput = "BuzzWoof*";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzzWoof_Star_for_210() {

        // Given
        int input = 210;
        String expectedOuput = "FizzBuzzWoof*";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Fizz_for_13() {

        // Given
        int input = 13;
        String expectedOuput = "Fizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Buzz_for_52() {

        // Given
        int input = 52;
        String expectedOuput = "Buzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_Woof_for_17() {

        // Given
        int input = 17;
        String expectedOuput = "Woof";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzFizz_for_313() {

        // Given
        int input = 313;
        String expectedOuput = "FizzFizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzFizzFizz_for_2313() {

        // Given
        int input = 2313;
        String expectedOuput = "FizzFizzFizz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzzBuzzFizzBuzz_for_2535() {

        // Given
        int input = 2535;
        String expectedOuput = "FizzBuzzBuzzFizzBuzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_BuzzWoofFizzBuzz_for_35() {

        // Given
        int input = 35;
        String expectedOuput = "BuzzWoofFizzBuzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_1_star_1_for_101() {

        // Given
        int input = 101;
        String expectedOuput = "1*1";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }

    @Test
    public void should_return_FizzBuzzFizzStarBuzz_for_3105() {

        // Given
        int input = 3105;
        String expectedOuput = "FizzBuzzFizz*Buzz";
        FizzBuzzWoof fizzBuzzWoof = new FizzBuzzWoof();

        // When
        String output = fizzBuzzWoof.convert(input);

        // Then
        assertThat(output).isEqualTo(expectedOuput);
    }
}

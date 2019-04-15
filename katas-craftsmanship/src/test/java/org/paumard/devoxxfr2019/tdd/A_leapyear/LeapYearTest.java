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

package org.paumard.devoxxfr2019.tdd.A_leapyear;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a classical TDD Kata, made to practice TDD at a beginner level. The good news id that the tests have
 * already been written. The rule is the following: write the simplest code to make the test pass one by one,
 * in the order they appear in this class. Remember: you need to find the minimal code that will one test pass
 * at a time!
 * <p/>
 * The LeapYears Kata
 * <p/>
 * Write a function that returns true or false depending on whether its input integer is a leap year or not.
 * A leap year is defined as one that is divisible by 4, but is not otherwise divisible by 100 unless it is also
 * divisible by 400.
 * <p/>
 * For example 2001 is a typical common year and 1996 is a typical leap year, whereas 1900 is an atypical common year
 * and 2000 is an atypical leap year.
 */
public class LeapYearTest {

    @Test
    public void should_return_false_for_year_2017() {

        // Given
        int year = 2017;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_year_2001_as_a_typical_common_year() {

        // Given
        int year = 2001;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_1996_as_a_typical_leap_year() {

        // Given
        int year = 1996;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_1992_as_a_typical_leap_year() {

        // Given
        int year = 1992;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_year_1900_as_an_atypical_common_year() {

        // Given
        int year = 1900;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_false_for_year_1800_as_an_atypical_common_year() {

        // Given
        int year = 1800;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = false;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_2000_as_an_atypical_leap_year() {

        // Given
        int year = 2000;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_true_for_year_1600_as_an_atypical_leap_year() {

        // Given
        int year = 1600;
        LeapYear leapYear = new LeapYear();
        boolean expectedResult = true;

        // When
        boolean isLeapYear = leapYear.isLeapYear(year);

        // Then
        assertThat(isLeapYear).isEqualTo(expectedResult);
    }
}

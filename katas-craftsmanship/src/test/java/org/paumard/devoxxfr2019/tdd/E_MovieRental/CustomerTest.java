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

package org.paumard.devoxxfr2019.tdd.E_MovieRental;

import org.junit.Test;
import org.paumard.devoxxfr2019.tdd.E_MovieRental.model.Movie;
import org.paumard.devoxxfr2019.tdd.E_MovieRental.model.Rental;
import org.paumard.devoxxfr2019.tdd.E_MovieRental.model.Tape;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
    @Test
    public void should_return_empty_statement_when_no_rentals_have_been_made() {
        // Given
        String name = "Sarah";
        Customer customer = new Customer(name);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Sarah\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_new_release_one_day() {
        // Given
        String name = "John";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Total Recall", Movie.NEW_RELEASE);
        Tape tape = new Tape("012345", movie);
        int daysRented = 1;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for John\n" +
                "\tTotal Recall\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points");
    }


    @Test
    public void should_return_correct_statement_for_one_rental_new_release_four_days() {
        // Given
        String name = "Jennifer";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Star Wars VI", Movie.NEW_RELEASE);
        Tape tape = new Tape("12345", movie);
        int daysRented = 4;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Jennifer\n" +
                "\tStar Wars VI\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 2 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_regular_one_day() {
        // Given
        String name = "James";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Casablanca", Movie.REGULAR);
        Tape tape = new Tape("123456", movie);
        int daysRented = 1;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for James\n" +
                "\tCasablanca\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_regular_two_days() {
        // Given
        String name = "Mary";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Taxi Driver", Movie.REGULAR);
        Tape tape = new Tape("123456", movie);
        int daysRented = 2;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Mary\n" +
                "\tTaxi Driver\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_regular_three_days() {
        // Given
        String name = "Robert";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Star Trek 2024", Movie.REGULAR);
        Tape tape = new Tape("123456", movie);
        int daysRented = 3;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Robert\n" +
                "\tStar Trek 2024\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_regular_four_days() {
        // Given
        String name = "Linda";
        Customer customer = new Customer(name);

        Movie movie = new Movie("The Gold Rush", Movie.REGULAR);
        Tape tape = new Tape("12354", movie);
        int daysRented = 4;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Linda\n" +
                "\tThe Gold Rush\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_childrens_four_days() {
        // Given
        String name = "Michael";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Frozen", Movie.CHILDRENS);
        Tape tape = new Tape("456123", movie);
        int daysRented = 4;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Michael\n" +
                "\tFrozen\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_one_rental_childrens_one_day() {
        // Given
        String name = "Elizabeth";
        Customer customer = new Customer(name);

        Movie movie = new Movie("Animalia", Movie.CHILDRENS);
        Tape tape = new Tape("789456", movie);
        int daysRented = 1;
        Rental rental = new Rental(tape, daysRented);
        customer.addRental(rental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for Elizabeth\n" +
                "\tAnimalia\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points");
    }

    @Test
    public void should_return_correct_statement_for_two_rentals_childrens_and_regular_two_days() {
        // Given
        String name = "David";
        Customer customer = new Customer(name);

        Movie childrensMovie = new Movie("Star Wars VII", Movie.CHILDRENS);
        Movie regularMovie = new Movie("Casablanca", Movie.REGULAR);

        Tape childrensTape = new Tape("456789", childrensMovie);
        Tape regularTape = new Tape("789123", regularMovie);

        int daysRented = 2;
        Rental firstRental = new Rental(childrensTape, daysRented);
        Rental secondRental = new Rental(regularTape, daysRented);
        customer.addRental(firstRental);
        customer.addRental(secondRental);

        // When
        String statement = customer.statement();

        // Then
        assertThat(statement).isEqualTo("Rental Record for David\n" +
                "\tStar Wars VII\t1.5\n" +
                "\tCasablanca\t2.0\n" +
                "Amount owed is 3.5\n" +
                "You earned 2 frequent renter points");
    }
}

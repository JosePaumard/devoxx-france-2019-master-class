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

package org.paumard.devoxxfr2019.A_lambdas.a_lambdas;

import org.junit.Ignore;
import org.junit.Test;
import org.paumard.devoxxfr2019.A_lambdas.a_lambdas.model.Circle;
import org.paumard.devoxxfr2019.A_lambdas.a_lambdas.util.CircleFactory;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the Supplier interface.
 */
public class A_Suppliers {

    /**
     * Write a lambda expression that returns a new StringBuilder
     * containing the string "abc".
     */
    @Test
    @Ignore
    public void a_supplier01() {

        Supplier<StringBuilder> sup = null; // TODO

        assertThat(sup.get().toString()).isEqualTo("abc");
    }

    /**
     * Write a lambda expression that returns a new, empty StringBuilder.
     * Try to write it using a method reference.
     */
    @Test
    @Ignore
    public void a_supplier02() {

        Supplier<StringBuilder> sup = null; // TODO

        assertThat(sup.get().toString()).isEqualTo("");
    }

    /**
     * Write a lambda expression that returns a new Circle.
     * The Circle class is provided in the model package.
     */
    @Test
    @Ignore
    public void a_supplier03() {

        Supplier<Circle> sup = null; // TODO

        assertThat(sup.get().toString()).isEqualTo("Circle{color=White}");
    }

    /**
     * Use the provided CircleFactory interface, that extends Supplier&lt;Circle>.
     * Add a method to this interface that can create a list of three circles.
     */
    @Test
    @Ignore
    public void a_supplier04() {

        CircleFactory circleFactory = null; // TODO

        List<Circle> circles = circleFactory.getThree();

        assertThat(circles).containsExactly(new Circle(), new Circle(), new Circle());
    }

    /**
     * Use the provided CircleFactory interface, that extends Supplier&lt;Circle>.
     * Add a method to this interface that can create a list of three red circles.
     */
    @Test
    @Ignore
    public void a_supplier05() {

        CircleFactory circleFactory = null; // TODO

        List<Circle> circles = circleFactory.getThree();

        assertThat(circles).containsExactly(new Circle("Red"), new Circle("Red"), new Circle("Red"));
    }

    /**
     * Writing our factory in that way is not very nice. We would like to create a factor method
     * to create a CircleFactory, and be able to call in that way:
     * <p/>
     * <code>CircleFactory factory = CircleFactory.createFactory(Circle::new);</code>
     * In that case, the factory should be a factory of white circles.
     */
    @Test
    @Ignore
    public void a_supplier06() {

        // The method call has been commented so that the code still compiles.
        // Once you have created it, you should uncomment the call on the following line
        CircleFactory circleFactory = null; // CircleFactory.createFactory(Circle::new);

        List<Circle> circles = circleFactory.getThree();

        assertThat(circles).containsExactly(new Circle("White"), new Circle("White"), new Circle("White"));
    }

    /**
     * And what about creating a factory of colored Circle in that way:
     * <p/>
     * <code>CircleFactory factory = CircleFactory.createFactory(Circle::new, "Blue");</code>
     * It needs another <code>createFactory()</code> method with two arguments.
     */
    @Test
    @Ignore
    public void a_supplier07() {

        // The method call has been commented so that the code still compiles.
        // Once you have created it, you should uncomment the call on the following line
        CircleFactory circleFactory = null; // CircleFactory.createFactory(Circle::new, "Blue");

        List<Circle> circles = circleFactory.getThree();

        assertThat(circles).containsExactly(new Circle("Blue"), new Circle("Blue"), new Circle("Blue"));
    }
}

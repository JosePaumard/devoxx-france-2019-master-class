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

package org.paumard.solutions.devoxxfr2019.A_lambdas.d_maps;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers the default method added to the Map interface.
 */
public class J_Maps {

    /**
     * Given a map whose keys are Integers and whose values are Strings,
     * set each value to upper case.
     * You can check the Map.replaceAll() method.
     */
    @Test
    public void j_map01() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "alfa");
        map.put(2, "bravo");
        map.put(3, "charlie");

        map.replaceAll((key, value) -> value.toUpperCase());

        assertThat(map).hasSize(3);
        assertThat(map).containsKeys(1, 2, 3);
        assertThat(map).containsValues("ALFA", "BRAVO", "CHARLIE");
    }

    /**
     * For some reason the provided map doesn't have mappings for all the keys.
     * Some keys are missing, some have a null value.
     * This is a problem, because if we call get() on a key that isn't present, it returns
     * null, and we need to add checks to protect against NullPointerException.
     * Write code to ensure that all missing keys are mapped to the empty string.
     * You can check the Map.putIfAbsent() method.
     */
    @Test
    public void j_map02() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", null);

        keys.forEach(key -> map.putIfAbsent(key, ""));

        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "alfa"))
                .contains(new AbstractMap.SimpleEntry<>("b", "bravo"))
                .contains(new AbstractMap.SimpleEntry<>("c", "charlie"))
                .contains(new AbstractMap.SimpleEntry<>("d", "delta"))
                .contains(new AbstractMap.SimpleEntry<>("e", ""))
                .contains(new AbstractMap.SimpleEntry<>("f", ""))
                .contains(new AbstractMap.SimpleEntry<>("g", ""));
    }


    /**
     * In the previous example, we added map entries that had a default value.
     * We've now determined that's incorrect, and we want to undo that. This
     * time, we want to remove the entry if the value is the empty string.
     * You can check one of the Map.remove() method.
     */
    @Test
    public void j_map03() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        keys.forEach(key -> map.remove(key, ""));

        assertThat(map).hasSize(4);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "alfa"))
                .contains(new AbstractMap.SimpleEntry<>("b", "bravo"))
                .contains(new AbstractMap.SimpleEntry<>("c", "charlie"))
                .contains(new AbstractMap.SimpleEntry<>("d", "delta"));
    }

    /**
     * We need another way to deal with the problem of the previous example.
     * Instead of removing entries whose value is the empty string, we want
     * to replace the empty-string values with a value that's the key itself.
     * Write the code to do that.
     * You can check one of the Map.replace() method.
     */
    @Test
    public void j_map04() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        keys.forEach(key -> map.replace(key, "", key));

        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "alfa"))
                .contains(new AbstractMap.SimpleEntry<>("b", "bravo"))
                .contains(new AbstractMap.SimpleEntry<>("c", "charlie"))
                .contains(new AbstractMap.SimpleEntry<>("d", "delta"))
                .contains(new AbstractMap.SimpleEntry<>("e", "e"))
                .contains(new AbstractMap.SimpleEntry<>("f", "f"))
                .contains(new AbstractMap.SimpleEntry<>("g", "g"));
    }

    /**
     * We are still dealing with a map with missing entries. For entries that
     * are present, we want to convert the value to upper case; and for keys
     * that are not present, we want to add an entry where the value is the
     * same as the key.
     * You can check the Map.compute() method.
     */
    @Test
    public void j_map05() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");

        keys.forEach(key -> map.compute(key, (k, v) -> v == null ? key : v.toUpperCase()));

        assertThat(map).hasSize(7);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "ALFA"))
                .contains(new AbstractMap.SimpleEntry<>("b", "BRAVO"))
                .contains(new AbstractMap.SimpleEntry<>("c", "CHARLIE"))
                .contains(new AbstractMap.SimpleEntry<>("d", "DELTA"))
                .contains(new AbstractMap.SimpleEntry<>("e", "e"))
                .contains(new AbstractMap.SimpleEntry<>("f", "f"))
                .contains(new AbstractMap.SimpleEntry<>("g", "g"));
    }

    /**
     * The map now has several entries, some with valid values, and some
     * with values that are the empty string. This time, we want to convert
     * the non-empty values to upper case, but we want to remove the entries
     * for which the values are the empty string.
     * You can check the Map.compute() method.
     */
    @Test
    public void j_map06() {

        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

        Map<String, String> map = new HashMap<>();
        map.put("a", "alfa");
        map.put("b", "bravo");
        map.put("c", "charlie");
        map.put("d", "delta");
        map.put("e", "");
        map.put("f", "");
        map.put("g", "");

        keys.forEach(key -> map.compute(key, (k, v) -> v == null || v.isEmpty() ? null : v.toUpperCase()));

        assertThat(map).hasSize(4);
        assertThat(map)
                .contains(new AbstractMap.SimpleEntry<>("a", "ALFA"))
                .contains(new AbstractMap.SimpleEntry<>("b", "BRAVO"))
                .contains(new AbstractMap.SimpleEntry<>("c", "CHARLIE"))
                .contains(new AbstractMap.SimpleEntry<>("d", "DELTA"));
    }

    /**
     * Given a list of words, populate a map whose keys are the lengths of
     * each word, and whose values are list of words with that length.
     * You can check the Map.computeIfAbsent() method.
     */
    @Test
    public void j_map07() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<Integer, List<String>> result = new HashMap<>();

        list.forEach(element -> result.computeIfAbsent(element.length(), k -> new ArrayList<>()).add(element));

        assertThat(result).hasSize(3);
        assertThat(result).containsKeys(3, 4, 5);
        assertThat(result)
                .contains(new AbstractMap.SimpleEntry<>(3, Arrays.asList("one", "two", "six", "ten")))
                .contains(new AbstractMap.SimpleEntry<>(4, Arrays.asList("four", "five", "nine")))
                .contains(new AbstractMap.SimpleEntry<>(5, Arrays.asList("three", "seven", "eight")));
    }

    /**
     * Given a list of words, populate a map whose keys are the first letter of each
     * word, and whose values are maps of lengths of each word, and list of words with that length.
     * The map should have the form:
     * e -> 5 -> {eight}
     * f -> 4 -> {four, five}
     * s -> 3 -> {six}
     * 5 -> {seven}
     * etc...
     * You can check the Map.computeIfAbsent() method.
     */
    @Test
    public void j_map08() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<String, Map<Integer, List<String>>> result = new HashMap<>();

        list.forEach(element -> result
                .computeIfAbsent(element.substring(0, 1), k -> new HashMap<>())
                .computeIfAbsent(element.length(), k -> new ArrayList<>())
                .add(element));


        assertThat(result).hasSize(6);
        assertThat(result).containsKeys("e", "f", "n", "o", "s", "t");
        assertThat(result.get("e"))
                .contains(new AbstractMap.SimpleEntry<>(5, Arrays.asList("eight")));
        assertThat(result.get("f"))
                .contains(new AbstractMap.SimpleEntry<>(4, Arrays.asList("four", "five")));
        assertThat(result.get("n"))
                .contains(new AbstractMap.SimpleEntry<>(4, Arrays.asList("nine")));
        assertThat(result.get("o"))
                .contains(new AbstractMap.SimpleEntry<>(3, Arrays.asList("one")));
        assertThat(result.get("s"))
                .contains(new AbstractMap.SimpleEntry<>(3, Arrays.asList("six")))
                .contains(new AbstractMap.SimpleEntry<>(5, Arrays.asList("seven")));
        assertThat(result.get("t"))
                .contains(new AbstractMap.SimpleEntry<>(3, Arrays.asList("two", "ten")))
                .contains(new AbstractMap.SimpleEntry<>(5, Arrays.asList("three")));
    }

    /**
     * Given a list of words, populate a map whose keys are the lengths of each word, and whose values
     * the concatenation of words with that length, separated by a space.
     * You can check the Map.merge() method.
     */
    @Test
    public void j_map09() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<Integer, String> result = new HashMap<>();

        list.forEach(element -> result.merge(element.length(), element, (s1, s2) -> s1 + " " + s2));

        assertThat(result).hasSize(3);
        assertThat(result).containsKeys(3, 4, 5);
        assertThat(result)
                .contains(new AbstractMap.SimpleEntry<>(3, "one two six ten"))
                .contains(new AbstractMap.SimpleEntry<>(4, "four five nine"))
                .contains(new AbstractMap.SimpleEntry<>(5, "three seven eight"));
    }

    /**
     * Given a list of words, populate a map whose keys are the first letter of each
     * word, and whose values are maps of lengths of each word, and concatenations of words
     * with that length, separated by a space.
     * The map should have the form:
     * e -> 5 -> "eight"
     * f -> 4 -> "four five"
     * s -> 3 -> "six"
     * 5 -> "seven"
     * etc...
     * You can check the Map.computeIfAbsent() and the Map.merge() methods.
     */
    @Test
    public void j_map10() {

        List<String> list = Arrays.asList(
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Map<String, Map<Integer, String>> result = new HashMap<>();

        list.forEach(element -> result
                .computeIfAbsent(element.substring(0, 1), k -> new HashMap<>())
                .merge(element.length(), element, (s1, s2) -> s1 + " " + s2));

        assertThat(result).hasSize(6);
        assertThat(result).containsKeys("e", "f", "n", "o", "s", "t");
        assertThat(result.get("e"))
                .contains(new AbstractMap.SimpleEntry<>(5, "eight"));
        assertThat(result.get("f"))
                .contains(new AbstractMap.SimpleEntry<>(4, "four five"));
        assertThat(result.get("n"))
                .contains(new AbstractMap.SimpleEntry<>(4, "nine"));
        assertThat(result.get("o"))
                .contains(new AbstractMap.SimpleEntry<>(3, "one"));
        assertThat(result.get("s"))
                .contains(new AbstractMap.SimpleEntry<>(3, "six"))
                .contains(new AbstractMap.SimpleEntry<>(5, "seven"));
        assertThat(result.get("t"))
                .contains(new AbstractMap.SimpleEntry<>(3, "two ten"))
                .contains(new AbstractMap.SimpleEntry<>(5, "three"));
    }

}

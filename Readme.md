### Devoxx France 2019  Master Class

This is a lab created for Devoxx France 2019. It is structured in two Maven modules, with distinct content:

1. A Java 8 / lambda / Stream / Collector / Challenges part. It starts gently with simple exercises and slowly reach much harder heights. The challenges are quite tricky, and meant to be... well, challenging!

2. A software crafstmanship part. Those are kata, classical or new. The tests have been provided, most of them are red, since the minimal code is written so that they can compile. Expect nasty `NullPointerException` if you run them. The rule of the game is the following: you should make the test pass in the order they are provided, and one at a time. If you pass the test 3 from a test class, then the test 4 should be red. If test 4 is also green, it means that you have written to much code. 

There is also the well-known `Movie Rental` by Martin Fowler. The classes to be refactored are provided, along with the tests. What you need to do is to follow the instructions to clean up this messy code. 

The solutions for the first part are provided in a folder called `solutions`.   
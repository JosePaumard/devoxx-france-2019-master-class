### Refactoring the Customer class

This kata is a classic, cited in the famous book _Refactoring_ by martin Fowler. This is the original Java form of this kata. 

Luckily, the tests have already been written for you, so all you need to do is to refactor the class to make it more readable. Here are some guidelines. 

1. First, you can check the class and some cleaning. You may be tempted to change the name of some local variables. In a real application, are you sure that it is completely safe to change the name of the fields? Does it seem possible to change the model classes (`Movie`, `Rental` and `Tape`)?
1. Once this little cleaning is done, what about doing some private method extraction? Can you spot the portion of the code that computes the price of a single rental? The one that computes the frequent renter points? The one that builds the line of the statement with a rental on it? That could make three private methods extracted from the `statement()` method.
1. At this point, can you tell how many responsibility the main loop has? How can you make it one, to comply with the Single Responsibility Principle? 
1. One this is done, maybe the loops you now have can be refactored with Streams?  
1. The next step could be to take care of this switch statement. What pattern should be applied here? Try to do it and create a nice enumeration for that. 
1. The next step is a little hard. To achieve it, you need to check the method you created to compute the frequent renter points. How many responsibilities does it have? How can you refactor it? 
1. At this step, you should have a much more clean class, but we are not quite done. Try to refactor the `statement()` method so that it has only one responsibility left.
1. One last step: what do you think of those three methods that compute the price, the frequent renter points and the statement line of a single rental? Don't you think they belong to the `Rental` class itself? Plus, if you followed those instructions, you may be bothered by the fact that the single rental price is computed twice... Not that bad in this kata, but still a little annoying. It would be so great to add them to the `Rental` class... Too bad our object model is locked in a safe and we only have read access to it... 
1. How can you add methods on a class you cannot change? Great! But remember: the GoF tells us that we should favor composition over inheritance. So what about doing that? This last step should solve the computation made twice that is still a itch in the back.  
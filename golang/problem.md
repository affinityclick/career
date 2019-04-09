# Common Actors

Using the The Movie DB we can search for movies using keywords:

~~~~
curl https://api.themoviedb.org/3/search/movie?query=star+wars&api_key=[API_KEY]
~~~~

Instead of having to do individual searches using curl we want to develop a command line tool that can have do multiple requests and present the results.

Please write said command line tool in Golang so it can solve the following problems. Add tests, explanations, comments as you feel necessary.

The API key will be provided separately.

## Problem 1: Common Actors

Given a list of search terms (e.g. movie titles) "star wars" "fugitive" "ender" we would like to know what are all the actors that appear in more than one of the movies that match these search terms.

We would like to run a command line tool like:

~~~~
sh> common_actors "star wars" "fugitive" "ender"
Harrison Ford | Star Wars IV, Star wars V, Star Wars VI, Star Wars VII, Enders Game, The Fugitive
Mark Hamill   | Star Wars IV, Star wars V, Star Wars VI, Star Wars VIII
...
sh>
~~~~

## Problem 2: Improvements

What can we do to speed up the searches? How can we make the time it takes to get a response from the tool more predictable? Are there trade-offs to be considered? What can be done to make the tool you wrote more professional?

Please explain your answers  / solutions. You can present your ideas in code or as text.

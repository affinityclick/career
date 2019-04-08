# Common Actors

Using the The Movie DB we can search for movies using keywords:

~~~~
curl https://api.themoviedb.org/3/search/movie?query=star+wars&api_key=[API_KEY]
~~~~

Instead of having to do individual searches using curl we want to develop a command line tool that answers a couple of questions.

Please write said command line tool in Golang so it can solve the following problems. Add tests, explanations, comments as you feel necessary.

The API key will be provided on request.

## Problem 1 - Common Actors

Given a list of search terms (e.g. movie titles) "star wars" "fugitive" "ender" I would like to know what are all the actors that appear in more than one of the movies that match these search terms.

I would like to run a command line tool like:

~~~~
sh> common_actors "star wars" "fugitive" "ender"
Harrison Ford | Star Wars IV, Star wars V, Star Wars VI, Star Wars VII, Enders Game, The Fugitive
Mark Hamill   | Star Wars IV, Star wars V, Star Wars VI, Star Wars VIII
...
sh>
~~~~

## Problem 2 - Common Pairs

For any if the movies are there pairs of actors that appeared in more than one movie together and what are those movies:

~~~~
sh> common_pairs "star wars" "fugitive" "ender"
Harrison Ford | Mark Hamill | Star Wars IV, Star wars V, Star Wars VI
Carrie Fisher | Harrison Ford | Star Wars IV, Star wars V, Star Wars VI, Star Wars VII
Carrie Fisher | Mark Hamill | Star Wars IV, Star wars V, Star Wars VI, Star Wars VIII
...
sh>
~~~~


## Problem 3: Improvements

What can I do to speed up the searches? How can I make time it takes to get a response from the tool more predictable? Are there trade-offs to be considered? Please explain your answers  / solutions. You can present your ideas in code or as text.

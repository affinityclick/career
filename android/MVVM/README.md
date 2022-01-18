# Instructions

Thank you for your interest in working at AffinityClick! We expect you to set aside 3-4 hours to complete the core task outlined and potentially some of the bonus tasks (THESE ARE NOT MANDATORY DO NOT FEEL OBLIGATED TO COMPLETE THEM). Feel free to use any additional 3rd party libraries in your solution.

Please submit your solution as ZIP-file (or google drive link) to career@affinityclick.com, as well as any feedback you have for us regarding the test, and any relevant information to a bonus task you attempted (if applicable).

# MVVM - The Movie Databse
This project connects to the movie database api see https://developers.themoviedb.org/3/getting-started/introduction for more details.

The api key used should be placed in key.properties there is a sample file key.properties.sample that can be copied and the value set.

## Core Tasks

The app currently has code in place to look up top rated movies. Once you click on a movie it should take you to a detail screen. From the detail screen you can view a credits page, we would like you to build this credits page. You'll need to build the UI for the credits screen and add in the network call, the models should already exist within the project. Below is a potential UI for what the credit items could be.

![Sample mockup](https://user-images.githubusercontent.com/16737168/56301760-7446b600-6106-11e9-8bc1-630521ecd3ba.jpg)

### Bonus Tasks

If you have completed the credits screen in less than 4 hours, feel free to start implementing the following features. We don't want you to exceed 4 hours working on this project so please send any partial solutions you have to these problems and a brief explanation on how you would ideally want to complete the taks you are working on. 

- Make the list of top rated movies an infinite scrolling list (load the next page of content)
- Add in logic to display trailers on the movie detail screen
- Add in logic to display reviews on the movie detail screen

## Technologies used:
### View Models, Live Data, Architecture Components
This is used for the MVVM architecture. You can do some reading about this at https://developer.android.com/topic/libraries/architecture. To learn more about how we use LiveData within ViewModels you can watch the following https://www.youtube.com/watch?v=OMcDk2_4LSk&t=4m16s
### Navigation Architecture Component
Used to handle the navigation within the app https://developer.android.com/guide/navigation
### Retrofit
Standard used for api calls
### Dagger
Our dependency injection framework, their mostly unhelpful documentation resides here: https://google.github.io/dagger/

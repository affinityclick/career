# Instructions

Thank you for your interest in working at AffinityClick! We expect you to set aside 3-4 hours to complete the core task outlined and potentially some of the bonus tasks (THESE ARE NOT MANDATORY DO NOT FEEL OBLIGATED TO COMPLETE THEM). Feel free to use any additional 3rd party libraries in your solution.

Please submit your solution as ZIP-file (or google drive link) to career@affinityclick.com, as well as any feedback you have for us regarding the test, and any relevant information to a bonus task you attempted (if applicable).

## The Movie Database

This project connects to the movie database api (https://developers.themoviedb.org/3/getting-started/introduction) for more details. An API key will be provided or you can set up your own account.

## Project Set Up

1. Run `pod install` to install dependencies and use the `iOS-MVVM.xcworkspace` to do your work
2. Change the `apiKey` value in the `iOS-MVVM/Util/Constants.swift` file from `"XXXX"` to the provided API key.
3. Build and run

## Architecture

The architecture used in the project is MVVM and UI is created using storyboards and XIBs. There are 4 distinct objects that we use when creating a screen:
- **ViewController**: Contains any UI logic, animations, and navigational logic.
- **ViewModel**: Contains any business logic, and notifies the view controller of any changes to the model or when to update it's state.
- **Service**: A dependency in the view model, a service object deals with any database and/or networking logic. Usually defined as a protocol to make database/network calls mockable in unit tests.

For screens that contain a table view/collection view:
- **DataSource**: Implementation of `UITableViewDataSource` & `UITableViewDelegate` (similarly for collection views). Contains the data that it is rendering and any table view/collection view related logic.

## Core Task

The app currently shows a list of the top rated movies and has a detail screen for those movies. From the detail screen you can view a credits page, we would like you to build this credits page. You'll need to build the UI for the credits screen and add in the network call, the models should already exist within the project. Below is a potential UI for what the credit items could be.

![Sample mockup](https://user-images.githubusercontent.com/16737168/56301760-7446b600-6106-11e9-8bc1-630521ecd3ba.jpg)

### Bonus Tasks

If you have completed the credits screen in less than 3 hours, feel free to start implementing the following features. We don't want you to exceed 4 hours working on this project so please send any partial solutions you have to these problems and a brief explanation on how you would ideally want to complete the taks you are working on.

- Make the list of top rated movies an infinite scrolling list (load the next page of content)
- Add in logic to display trailers on the movie detail screen
- Add in logic to display reviews on the movie detail screen
- Add another movie list to the nav menu (see api for potential endpoints)

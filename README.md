# Berlin Clock

### About the project
The clock is read from the top row to the bottom. The top row of four red fields denote five full hours each, alongside the second row, also of four red fields, which denote one full hour each, displaying the hour value in 24-hour format.

### Tools Used

The app is build with  **Kotlin** It supports from Android Sdk 24.


### Architecture

The app uses **MVVM Architecture** to have a unidirectional flow of data, separation of concern, testability, readable and maintainable.
It has Separate layers Data, Domain and Presentation.

### Libraries and tools
The Berlin Clock app uses below libraries and tools to build efficient application

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/compose) Modern toolkit for Android UI
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) 
- [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) for data stream
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)  for dependency injection
- [Mockito](https://site.mockito.org/) for unit testing
- [Compose Screenshot Testing](https://developer.android.com/studio/preview/compose-screenshot-testing) for ui testing
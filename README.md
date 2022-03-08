Kotlin Base
============

A base source code illustrating Android development best practices with Android Jetpack.

Introduction
------------
Android Jetpack is a set of components, tools and guidance to make great Android apps. They bring
together the existing Support Library and Architecture Components and arrange them into four
categories:

![Android Jetpack](screenshots/jetpack_donut.png "Android Jetpack Components")

Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [LiveData][11] - Build data objects that notify views when the underlying database changes.
  * [Navigation][12] - Handle everything needed for in-app navigation.
  * [Room][13] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][14] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
* [UI][20] - Details on why and how to use UI Components in your apps - together or separate.
  * [Fragment][21] - A basic unit of composable UI.
  * [Layout][22] - Layout widgets using different algorithms.
* Third party and miscellaneous libraries
  * [Glide][40] for image loading
  * [Hilt][41] for [dependency injection][42]
  * [Kotlin Coroutines][43] for managing background threads with simplified code and reducing needs for callbacks
  * [Retrofit][44] for call API

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[10]: https://developer.android.com/jetpack/arch
[11]: https://developer.android.com/topic/libraries/architecture/livedata
[12]: https://developer.android.com/topic/libraries/architecture/navigation
[13]: https://developer.android.com/topic/libraries/architecture/room
[14]: https://developer.android.com/topic/libraries/architecture/viewmodel
[20]: https://developer.android.com/guide/topics/ui
[21]: https://developer.android.com/guide/components/fragments
[22]: https://developer.android.com/guide/topics/ui/declaring-layout
[40]: https://bumptech.github.io/glide
[41]: https://developer.android.com/training/dependency-injection/hilt-android
[42]: https://developer.android.com/training/dependency-injection
[43]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[44]: https://square.github.io/retrofit
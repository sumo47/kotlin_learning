# What is COMPOSE
* Android native UI Toolkit written in Kotlin.
* Not part of the framework, it is a jetpack Library
* Basic Building Block - composable (Kotlin Funciton with @Composable)
```kotlin
@Composable
fun SayCheezy(name:String){
  Text(text = "Welcome To Dark World $name!")
}
```
# Imperative vs Declarative 
* Imperative is `How?`
* Declarative is `What?`
   - f(data) = UI
 
# INHERITANCE TREE
 * All the views inherit from View Class
 * For large codebase, Inheritance becomes complex.
 * Composition over Inheritance
 * RECOMPOSITION 
   - In Simple words - Whenever your state changes , it will recreate UI

# JETPACK COMPOSE
 * Project Setup
 * Simple Compose Example
 * Compose in Existing Project
  - we can preview our custome conpose =
```kotlin
@Preview(showBackground = true, name = "hello message", showSystemUi = true)
@Composable
fun sayHello (name:String = "Jatin"){
    Text(text = "Hi $name!")
}
```
   - //showbackground is use to show background (default - white)
   - // name = name of preview compose
   - // showSystemUi = show preview in system ui like 
   - composable function with no default parameter, does not support preview
   - 

# Column - Vertically Arrange
# Row - Horizontally Arrange
# Modifier - 
 * To modify size, display , appearance and behaviour of the Composable
 * size, Background Colour, Paddings, Click Handlers
 * Composition over Inheritance
 * Can be chained and sequence matters here.

# RECOMPOSITION
 * Initial Composition
 * Recomposition - 
   - In Simple words - Whenever your state changes, it will recreate the UI.
   - State - We have state object , when ever any changes detects in state value , the UI will re-render .
   - Composable functions can execute in any order.
   - Composable functions can run in parallel
   - Recomposition skips as many composable and lambdas as possible.
   - Recomposition is optimistic and may be canceled - if any state changes during the function call than function call will terminated and call again
   - A composable function might be run quite frequently , as often as every frame of an animation
# Stete concept & Hoisting & Unidirectional Flow
 * Mutable State concept - is use to change value of state
 * State Hoisting - we can create state on top of scope so inner 2 scope can access the state
 * Unidirectional Data Flow - 
    - state direction is up to down 
    - event direction is down to up
 * remember - is use to remember state value when composable run again  , rememberSaveable - is use to remember state value when composable create again
# LaunchedEffect - 
 * it is use to trigger method or function when we want , 
 * syntax -     LaunchedEffect(key1 = dependency) { function i want to trigger }
 * useEffet like 
# Remember Coroutine Scope
 * Remember Coroutine Scope vs launched
    - In Jetpack compose, we have the option of using rememberCoroutineScope() as well as using the LaunchedEffect composable in order to use coroutines / run suspend functions
    - launchedEffect - when composable is first launched/relaunched (or when the key parameter has changed)
    - rememberCoroutineScope - is specific to store the Coroutine scope allowing the code to launch some suspend function
 * Examples
 * Side Effects - any changes that will happen out of composable scope.
   - our composable should be side effect free
 * LaunchedEffect - it is composable to execute side effect
# RememberUpdatedState - SideEffect Handler
  * it is basically stores updated value of state
  * it returns state<T> object
  * to use it - state.value
# Tweetsy Compose - App
  * Demo App
  * Tech - MVVM, Navigation Component, HILT, Retrofit etc.
  * API - for api we have used Jsonbin website
    - created a collection name - `tweetsy` in `https://jsonbin.io/` website
    - created a bin inside collection tweetsy , and paste json 
    - change the privacy of bin (private to public ) using url - `https://api.jsonbin.io/v3/b/67a2819de41b4d34e484253c/meta/privacy`
      - in the Header
        - `X-Bin-Private` : `false`
        - `X-Master-Key`  : (api-key)
    - now we can access json using url - `https://api.jsonbin.io/v3/b/67a2819de41b4d34e484253c`
    - if we don't want meta - `https://api.jsonbin.io/v3/b/67a2819de41b4d34e484253c?meta=false`
    - filter by category , add header - `X-JSON-Path` : `tweets[?(@.category=="Motivation")]`

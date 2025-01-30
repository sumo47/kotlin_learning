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

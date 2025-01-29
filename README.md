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
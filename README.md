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
# Hilt - 
  * Hilt is a dependency injection library for Android
  * Standard way of implementing DI in Android
  * Built on top of Dagger 2
  * Hilt generates Dagger code for you
# Navigation In compose
  * NavHost - the screen will render , 
  * NavGraph - graph view , which screen is connected to different, from one place where we can go , nav graph says that
  * NavController - how two screen manage, interaction between NavHost and NavGraph , manage 
  * Nav Argument - the detail will pass from one navhost to another
# Navigation apply 
  * when we go from one scree to another , than the arguments will stored in savedStateHandle
  
# Room Db
* Room is part ot Android jetpack, which is helps to create robust , testable , and maintainable apps.(this is suite of library)
* Advantage - LiveData aur Flow ke saath integration: Room LiveData aur Flow ke saath seamlessly kaam kar sakta hai, jisse data change hone par aapke UI ko update karna aasaan ho jata hai.
* Key Components
1. Entity - it represents table of database
    - use - @Entity annotation
2. DAO (Data Access Object) - ye ek interface or abstract class hai , jo database se interact karne ke liye method defice krta hai
    - use - @DAO
    - Flow - it is stream of flow data , so we can collect data asynchronously
3. Database - it is main access point of database

# Flow 
   - What is Kotlin flow?
   - Need of Kotlin flows.
   - Examples
* Coroutines - 
  - Cotoutines helps to implement asynchronous, non blocking code.
  - For this we use - Suspend Functions.
  - Either you fire and forget using launch or wait for data(i.e. single object) using async.
  ```kotlin 
  // launch - fire and forget
  suspend fun deleteUser(){
    CoroutineScope(Dispatchers.Io).launch{
      //network call
    }
  }  
  ```
  ```kotlin
  // async - wait for data
  suspend fun createUser() : User
  {
    val user = CoroutineScope(Dispatchers.IO).async{
      //network call
    }
    return user.await()
  }
  ```
  - Suspend functions only return a single Object
  ```kotlin
  suspend fun getUsere() : User
  {
    //network call
    return User
  }
  ```
  ```kotlin
  suspend fun getUser() : List<User>
  {
    // network call
    return list
  }
  ```
  - Suspend functions work great for things like - 
    - Storing some value in database
    - Network calls
    - Doing task that returns single value
  - But there are scenarios where you save streams of data - 
    - Video Sreaming 
    - FM radio
    - Mobile sending audio signals to Bluetooth speakers
  - Kotlin has asynchronous stream support using Channels & Flows.
  - Channels (Send & Receive)
    - Channels are Hot - that means it send and receive data continously 
  - Flows (Emit & Collect)
    - Flows are mostly Cold = it Emit data when you want
* Important Points (Hot & Cold)
  - Cold Streams are preferred over Hot Streams
  - Resource Wastage in Hot stream
  - Manual Close in Hot stream
  - problem - one of them can become bottleneck (producer, consumer)
  - Producer Consumer
  - Bottleneck
  - Asynchronous
  - Cold
* Kotlin Flows  
* `asFlow()` - is use to convert list to flow
* `measureTimeMillis` - is use to measure time of execution of code
* `buffer` - is use to remove bottleneck
* if we emit in main thread and want to collect another thread , - it will gives error - to overcome it we use `FlowOn`
* every consumer will get indepandent flow object data
* `sharedFlow` - it is hot flow
* `stateFlow` - it is also hot but stores last value4
* LIVEDATA VS STATEFLOW
  1. Transformations of Mian thread - sateFlow can execure on worker thread
  2. Operators - stateFlow have many operators
  3. LifeCycle Dependent - stateFlow need csoroutine scope to execure

# Coroutine
* Agenda
  1. Basic Terminology
  2. Coroutine Introduction
  3. Need of Coroutines

* Basic Concepts
 - Program
 - Process (Actual Instance of your program)
   - Process Id
   - State
   - Memory
   - Handles for Networking, File System etc.
   - Thread (i.e. Thread Of Execution)
 - Sequential Execution -
   - Process - Instruction 1 -> Instruction 2 -> Instruction 3
   - all instructions execute in sequence - that means all instruction runs in one thread
   - if we want to execute one of instruction in another thread we use `coroutine`
 - What type of Instruction are we execution these days? - I/O oprations
 - Can we just re-use the thread when it is waiting for some response or IO operations?
* Coroutine - Cooperating functions
 - Executed inside a thread
 - One thread can have many coroutines
 - cheap
* Agenda
 - Main Thread with Looper
 - Background Threads
 - coroutines Introduction

* Looper - it basically checks message queue to execute task on main thread
* Background Thread - Thread generally takes 2 mb , and how much thread we can run it depends on system
* context switching - in Thread hard to switch some operation from one thread to another

* What's solution in Java? - No Solution
* What's solution in Kotlin - Coroutines
* Coroutines are just like threads ( lightweight thread ) but not threads.
* Coroutines run on top of Threads.

* Coroutines 
 - Coroutine Scope - Lifetime 
 - Coroutine Context - Threads - it defines that in which thread coroutine will execute

* Dispatchers
 - Coroutines run on top of threads
 - Dispatchers is a way to define threads on which Coroutines are executed.
 - Predefined Dispatchers - 
   - Dispatchers.IO
   - Dispatchers.Main
   - Dispatchers.Default
* coroutine scope - 
  - CoroutineScope
  - GlobalScope
  - MainScope
* COROUTINE BASIC SYNTAX
```kotlin
CoroutineScope(Dispatchers.IO).launch {
    // code
}
```
* THREADS & COROUTINES
```kotlin
// Thread
fun executeTask(view:View)
{
  thread(start = true) {
     executeLongRunningTask()
   }
}
```
to 

```kotlin
// coroutine
fun executeTask(view:View)
{
  CoroutineScope(Dispatchers.IO).launch {
    executeLongRunningTask()
  }
}
```
* Coroutines helps to implement functionality that can be suspended & and later resumed
at specified points without blocking the thread
* Suspending Functions
 - Functions with suspend modifier.
 - Helps coroutine to suspend the computation at a particular point
 - Suspendign functions must be called from either Coroutines or Other Suspending Function
* suspension point - from where we define to suspend function
* suspend function - `yield()`, `delay()`, etc

* Agenda
 - Coroutine Builders
 - launch , async
 - Examples

* Coroutine Builders
 - Coroutine Builders - Functions that help in creating coroutines
 - We have already seen launch function.

```kotlin
CoroutineScope(Dispatchers.IO).launch{
  // code
}
```
* Job = it is use to manage coroutine
* launch - is use to create instance of job
* job.join() - is use to hold function until job has been done, like some operation will call only when job (db call ) will done

* COROUTINE BUILDERS
 - Use Launch - when you do not care about the result.(Fire & Forget)
 - Use Async - when you expect result/output from your coroutine
 - Although both can be used to achieve the same functionality but it is better to use things that are meant for it.
* launch returns job
* async return deffered , (basically deffered inherit job)

* if we have parent and child coroutine , than both will execute on once thread , until we explicitly mention for child job to execute another thread
* if we cancel parent job than all child job will cancel
* if we want to cancel child job based on condition , we can do it

* Agenda
 - withContext
 - runBlocking
 - Examples
* withContext - this is blocking code - it will block coroutine
* job.sleep() - is use to block coroutine 
* runBlocking -it is global scope-  is use to block thread until coroutine completed

* Agenda
 - ViewModelScope
 - LifeCycleScope
 - Examples
* VIEWMODELSCOPE 
  - Coroutine scope attached with your View Models.
  - Coroutines in this scope will be cancelled automatically when viewmodel is cleared. We don't need to manually cancel the coroutines.














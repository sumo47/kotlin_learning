# xml - `Extensible Markup Language`

# Views
* A View is the basic UI component in Android.
* It represents a rectangular area on the screen and is responsible for drawing and event handling.
* View refer to the android.view.View class, which is the base class of the all UI classes. android.view.View class is the root of the UI class hierarchy.
* All UI objects are View objects
* Examples:
   - TextView 
   - EditText
   - ImageView
   - RadioButton
   - Button, etc
```xml
 <TextView android:id="@+id/text"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Hello, I am a TextView" />
```
# ViewGroup
* A ViewGroup is an invisible container that defines the layout structure for View and other ViewGroup objects.
* They are often referred to be as layouts.
* The ViewGroup class is a subclass of the View Class.
* ViewGroup Refer to the android.view.ViewGroup class, which is the base class of some special UI classes that can contain other View objects as children.
* Examples - 
   - LinearLayout
   - RelativeLayout
   - ConstraintLayout
   - FrameLayout etc.
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical" >
    <TextView android:id="@+id/text"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Hello, I am a TextView" />
    <Button android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello, I am a Button" />
</LinearLayout>
```
# Activity
* An Activity is one of the most fundamental components in Android development. It represents a single screen in Android application , like a "page" or "screen" that a user interacts with.
* An Application has min. 1 activity.
* Every Activity has a design(.xml) file and a logical(.kt/.java) file.

# Activity Lifecycle
* The lifecycle of an Activity describes how the Android System creates, manages and destroys it based on user interaction and system requirements.
* Each stage is represented by specific lifecycle methods that the developer can override to perform actions.
* Lifecycle methods - jab MainActivity start hoti hai, Android OS lifecycle methods ko call karta hai , jese :
   - onCreate() - Activity create hoti hai.
   - onStart() - UI visible hoti hai.
   - onResume() - User interact kar sakta hai.
   - onPause() - Background me chali jati hai. (??)
   - onStop() - Fully hidden ho jati hai.
   - onDestroy() - Activity destroy ho jati hai.
   - onRestart() - wapas se onCreate() call hota hai

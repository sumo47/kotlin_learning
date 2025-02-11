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
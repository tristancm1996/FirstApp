package edu.saintjoe.cs.brianc.firstapp;

//Import directives tell Eclipse which components you intend to use
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Form;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;

import com.google.devtools.simple.runtime.events.EventDispatcher;

public class FirstAppActivity extends Form implements HandlesEventDispatching {

	// Java Bridge version of FinalStartApp from CMP111
	//   Coded by Brian Capouch
	//   Project begun 19 December 2015
	
	// We begin with constants, and "global settings" variables
	// -- This app has none for now
	
	// Next are the UI widget references
	
	// These objects are equivalent to "components" of App Inventor
	// The containers which organize the app screen
	private HorizontalArrangement top;
	private HorizontalArrangement bottom;

	// Next the main components
	private Button calcButton;
	private Button listAddButton;
	private Button listShowerButton;
	private Button sumButton;
	
	private TextBox inputBox;
	
	// Variable to hold our saved value for later retrieval
	private int savedValue;
	private String tempString;
	
	private Label resultLabel;

// Java Bridger apps all use $define() in place of main()
void $define() {
	
	// Code in this block is equivalent to the "Designer" part of App Inventor
  
	 // "this" is an Activity object, or the "main screen"
   this.BackgroundColor(COLOR_WHITE);
   
   // Create containers for UI widgets
   top = new HorizontalArrangement(this);
   bottom = new HorizontalArrangement(this);
   
   // Now create the user interface
   calcButton = new Button(top,"Save"); 
   listAddButton = new Button(top, "Retrieve");
   inputBox = new TextBox(bottom);
   inputBox.NumbersOnly(true);
   resultLabel = new Label(bottom,"");
   
   
   // Let the runtime system know which events to report to the dispatcher
   EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
  
} // end $define()

// This method, known as a "callback" is invoked by the runtime system
// It will only be called when a delegated event occurs
@Override
public boolean dispatchEvent(Component component, String id, String eventName,
       Object[] args) {
	
	// This code is equivalent to the "Blocks" part of App Inventor
	    if (component.equals(calcButton) && eventName.equals("Click")){
	    	savedValue = Integer.parseInt(inputBox.Text());
	    	// tempString = Integer.toString(savedValue);
	    	resultLabel.Text("Input value has been saved");
	    	inputBox.Text("");
	        return true;
	     } // 
	    
	    if (component.equals(calcButton) && eventName.equals("Click")){
	    	resultLabel.Text("");
	    	tempString = Integer.toString(savedValue);
	    	resultLabel.Text(tempString);
	        return true;
	     } // 
	// This line is syntactically required
  return true;
	} // end dispatchEvent
}

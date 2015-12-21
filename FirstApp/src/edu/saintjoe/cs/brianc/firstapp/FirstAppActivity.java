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


	// Next the main components
	private Button onlyButton;
	
	private Label onlyLabel;

// Java Bridger apps all use $define() in place of main()
void $define() {
	
	// Code in this block is equivalent to the "Designer" part of App Inventor
  
	 // "this" is an Activity object, or the "main screen"
   this.BackgroundColor(COLOR_WHITE);
   
   // Create our button
   onlyButton = new Button(this);
   onlyButton.Text("Please push me!!");

   // And our only label
   onlyLabel = new Label(this);
   
   
   // Let the runtime system know which events to report to the dispatcher
   EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
  
} // end $define()

// This method, known as a "callback" is invoked by the runtime system
// It will only be called when a delegated event occurs
@Override
public boolean dispatchEvent(Component component, String id, String eventName,
       Object[] args) {
	
	// This code is equivalent to the "Blocks" part of App Inventor
	    if (component.equals(onlyButton) && eventName.equals("Click")){
	    	onlyLabel.Text("OUCH!!");
	        return true;
	     } // 
	    
	// This line is syntactically required
  return true;
	} // end dispatchEvent
}

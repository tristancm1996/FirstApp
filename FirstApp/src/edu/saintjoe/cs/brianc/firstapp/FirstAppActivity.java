package edu.saintjoe.cs.brianc.firstapp;

// Include these lines every time; they're needed by every ap
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.Form;

// One line here for each TYPE of componment you intend to use

// Import buttons so I can use them
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.HorizontalArrangement;


// This line needs to be in every app
import com.google.appinventor.components.runtime.EventDispatcher;

public class FirstAppActivity extends Form implements HandlesEventDispatching {

	// Minimal Android app built with the Java Bridge
	//   Project begun 21 December 2015
	//   Brought before CMP112 on 27 January 2016
	
	// We begin with constants, and "global settings" variables
	// -- This app has none for now
	
	// Next are the UI widget references	
	// These objects are equivalent to "components" of App Inventor

	// Only two for this simple demo
	
	// Declare our button
	private Button onlyButton;
	private Button clearButton;
	private Label onlyLabel;
	private HorizontalArrangement top; 
	

// Java Bridger apps all use $define() in place of main()
protected void $define() {

	// Code in this block is equivalent to the "Designer" part of App Inventor
  
	this.BackgroundColor(COLOR_WHITE);
	 
   //Create horizontal arrangement
	top = new HorizontalArrangement(this);
	// Define our button
	onlyButton = new Button(top);
	onlyButton.Text("Make my life complete");

	// Clear the label when pressed
	clearButton = new Button(top);
	clearButton.Text("Clear label");
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
	    	onlyLabel.Text("Ahhhhhhhhhhh. . . . ");
	        return true;
	     } // 
	    
	    if (component.equals(clearButton) && eventName.equals("Click")){
	    	onlyLabel.Text("");
	        return true;
	     } // 

	    // This line is syntactically required  
	    return true;
} // end dispatchEvent
}

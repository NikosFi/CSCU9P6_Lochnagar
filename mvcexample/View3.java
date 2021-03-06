package mvcexample;

// This is the yellow view.
// It displays the A component of the model (data base).
// As supplied, this view does not subscribe to the model as an Observer,
// and relies on its controller to call update to cause the view to be refreshed.

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View3 extends JPanel implements Observer {
  
    private Model model;
    private Controller2 contr;   // Parent Frame
    
    private JTextField display;
    
    // Constructor
    public View3(Controller2 contr, Model model) {
        
        // Record references to the parent controller and the model
        this.contr = contr;
        this.model = model;
        
        // Set up view GUI
        setBackground(Color.yellow);
        add(new JLabel("View3"));
        display = new JTextField("No data", 15);
        add(display);
        model.addObserver(this);
        
    } // constructor
    
    // Called by controller to refresh the view:
//    public void update() {
//
//        // Fetch (potentially) updated information and display it
//        int a = model.getDataA();
//        display.setText("Model data A: " + a);
//
//    } // update
    
    // Called by the controller to clear the view:
    public void clear() {
        
        display.setText("");
      
    } // clear

    @Override
    public void update(Observable o, Object arg) {
        // Fetch (potentially) updated information and display it
        int a = model.getDataA();
        display.setText("Model data A: " + a);

    } // update
} // class View3





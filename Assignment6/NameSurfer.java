/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		add(new JLabel("Name"),SOUTH);
		pause(TIME);
		tf = new JTextField(20);
		tf.setActionCommand("Text");
		add(tf,SOUTH);
		pause(TIME);
		add(new JButton("Graph"),SOUTH);
		pause(TIME);
		add(new JButton("Clear"),SOUTH);
		addActionListeners();
		
		tf.addActionListener(this);
		
		nsg = new NameSurferGraph();
		add(nsg);
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Text") || cmd.equals("Graph")){
			nsg.addString(tf.getText());
			
		} else if(cmd.equals("Clear")){
			nsg.clear();
		}
	}
		
	private JTextField tf;
	private NameSurferGraph nsg;
}

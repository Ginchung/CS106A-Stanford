
/*
 * File: Robot.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for 
 * the Robot Face problem.
 */

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class Robot extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 240;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 100;
	private static final int MOUTH_HEIGHT = 50;
	

	public void run() {
		int centerWidth = getWidth()/2;
		int centerHeight = getHeight()/2;
		
		
		/* OLDER EDIITION (18:23, 16.10.13)
		 * 
		 * And we actually can pass the parameter through method. 
		 * USE THEM. 
		 * 
		//Firstly, get the face. 
		GRect face = new GRect(centerWidth-HEAD_WIDTH/2,centerHeight-HEAD_HEIGHT/2,
				HEAD_WIDTH,HEAD_HEIGHT);
		face.setFilled(true);
		face.setFillColor(Color.GRAY);
		add(face);
		
		//Then make two eyes, symmetric. 
		GOval leftEye = new GOval(centerWidth-HEAD_WIDTH/4-EYE_RADIUS,
				centerHeight-HEAD_HEIGHT/4-EYE_RADIUS,2*EYE_RADIUS,2*EYE_RADIUS);
		GOval rightEye = new GOval(centerWidth+HEAD_WIDTH/4-EYE_RADIUS,
				centerHeight-HEAD_HEIGHT/4-EYE_RADIUS,2*EYE_RADIUS,2*EYE_RADIUS);
		leftEye.setFilled(true);
		rightEye.setFilled(true);
		leftEye.setFillColor(Color.YELLOW);
		rightEye.setFillColor(Color.yellow);
		add(leftEye);
		add(rightEye);
		
		//Finally make the mouth.
		GRect mouth = new GRect(centerWidth-MOUTH_WIDTH/2,
				centerHeight+HEAD_HEIGHT/4-MOUTH_HEIGHT/2,MOUTH_WIDTH,MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
		
		 */
		
	}
}


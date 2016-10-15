import java.awt.*;
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;

public class flappyBird extends GraphicsProgram{
	
	private static final int PAUSE = 15;
	private int rectUpperHeight;
	private int rectDownHeight;
	private double oldHeight;   			  //The height of upper rectangle
	private double newHeight;
	
	//Move speed definition
	private int SPEED = 3;
	//Give the empty area of the active ball
	private static final int EMPTY = 50;
	private static final int RADIUS = 10; //The radius of the ball
	
	private static final int blockWidth = 70;
	
	//horizontally change the height
	private int height = 0;
	//steps
	private int STEPS = 300;
	
	private int i=0; 		//To make steps horizontally
	
	private int AREA = 150;  //The changeable area for the box

	private int blocks = 0;
	
	private double xBall;
	private double yBall;
	
	public void run(){
		setRectInit();
		ballInit();
		
		//Mouse event
		addMouseListeners(); 
		
		while(true){
			
			
			move();
			blockAndChange();
			if(i<STEPS){
				horiMove(i);
				i++;
			}
			pause(PAUSE);
			
			
			//set ball cracked checking
			if(ballCrack()){
				break;
			}
		}
		add(new GLabel("You Failed! Finished blocks: "+blocks),100,100);
		
	}
	
	//move ball with the mouse
	public void mouseDragged(MouseEvent e){
		ball.setLocation(getWidth()/2, e.getY());
	}
	
	//Ball crack check
	private boolean ballCrack(){
		xBall = ball.getX();
		yBall = ball.getY();
		
		if(getElementAt(xBall -1,yBall)==null&&getElementAt(xBall+2*RADIUS +1,yBall+2*RADIUS)==null&&
				getElementAt(xBall+2*RADIUS +1,yBall)==null&&getElementAt(xBall -1,yBall+2*RADIUS)==null)
			return false;
		else
			return true;
	}


	
	//Set ball initially
	private void ballInit(){
		ball = new GOval(getWidth()/2,getHeight()/2,RADIUS,RADIUS);
		ball.setFilled(true);
		ball.setFillColor(Color.RED);
		add(ball);
	}
	
	//move small steps horizontally
	private void horiMove(int i){
		rectUpper.setSize(blockWidth, i*(newHeight-oldHeight)/STEPS+oldHeight);
		rectDown.setLocation(rectUpper.getX(), i*(newHeight-oldHeight)/STEPS+oldHeight+EMPTY);
		rectDownHeight = (int)(getHeight()-(i*(newHeight-oldHeight)/STEPS+oldHeight+EMPTY));
		rectDown.setSize(blockWidth, rectDownHeight);
	}
	
	//Change the direction
	private void blockAndChange(){
		if(rectUpper.getX() < 0 || rectUpper.getX()+blockWidth >= getWidth()){
			SPEED = -SPEED;
			
			//Change colors
			rectUpper.setColor(rgen.nextColor());
			rectDown.setColor(rgen.nextColor());
			
			/*Change heights of the rectangles, the variable here to indicate the
			 * height of the upper rectangle. 
			 */
			oldHeight = rectUpper.getHeight();
			height = (int)rgen.nextDouble(getHeight()/2-AREA, getHeight()/2+AREA);
			newHeight = height;
			
			//initialize i value
			i = 0;
			blocks++;
		}
		

		
	}	
	
	//move in a horizontal way
	private void move(){
		rectUpper.move(SPEED,0);
		rectDown.move(SPEED,0);
	}
	
	//Initialize the program, concisely the two rects
	private void setRectInit(){
		rectUpper = new GRect(100,0,blockWidth,getHeight()/2);
		rectDown = new GRect(100,getHeight()-200,blockWidth,200);
		rectUpper.setFilled(true);
		rectDown.setFilled(true);
		add(rectUpper);
		add(rectDown);
	}
	

	private GOval ball;
	
	private GRect rectUpper;
	private GRect rectDown;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}

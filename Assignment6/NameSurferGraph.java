/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		//	 You fill in the rest //
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		//	 You fill this in //
		removeAll();
		hmp.clear();
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
	}
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		//	 You fill this in //
		removeAll();
		double eachWidth = (double)getWidth()/NDECADES;
		if(!hmp.isEmpty()){
			Iterator<String> i = hmp.keySet().iterator();
			while(i.hasNext()){
				drawStatLine(hmp.get(i.next()),eachWidth);
			}
		}
		drawBackGround(eachWidth);

	}
	
	//Draw Lines standing for the ranks of each kind of name.
	private void drawStatLine(NameSurferEntry nse,double Width){
		//Get name initially, avoiding using functions and lowering the speed of computing. 
		String name = nse.getName();
		int color=hmp.size()%(colorArray.length);
		
		double xLeft=0,yLeft;
		if(nse.getRank(0)==0){
			yLeft = getHeight()-GRAPH_MARGIN_SIZE;
		} else {
			yLeft = nse.getRank(0)*(getHeight()-2*GRAPH_MARGIN_SIZE)/1000+GRAPH_MARGIN_SIZE;
		}
		double xRight,yRight;
		int rank = 0;
		for(int i=1;i<NDECADES;i++){
			rank = nse.getRank(i);
			if(rank<1 || rank>=1000)
				rank = 1000;
			yRight = rank*(getHeight()-2*GRAPH_MARGIN_SIZE)/1000+GRAPH_MARGIN_SIZE;
			xRight = i*Width;
			GLine line = new GLine(xLeft,yLeft,xRight,yRight);
			//Give a label it for describing the name and rank of certain decade. 
			GLabel label = new GLabel(name+","+rank,xLeft,yLeft);
			add(label);
			add(line);
						
			line.setVisible(true);
			line.setColor(colorArray[color]);
			label.setColor(colorArray[color]);
			
			/*Modify the two point, that means, the previously right point becomes the left point
			 * in the next time. And we create only the right point in the next time. 
			 */
			xLeft = xRight;
			yLeft = yRight;
		}
		GLabel label = new GLabel(name+","+rank,xLeft,yLeft);
		add(label);
	}
	
	private void drawBackGround(double Width){
		add(new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE));
		add(new GLine(0,getHeight()-GRAPH_MARGIN_SIZE,getWidth(),getHeight()-GRAPH_MARGIN_SIZE));
		for(int i=0;i<NDECADES;i++){
			add(new GLine(i*Width,0,i*Width,getHeight()));
			add(new GLabel(""+(START_DECADE+i*10),i*Width,getHeight()-GRAPH_MARGIN_SIZE+16));
			/* 16 here is the label ascent I used to make it nice, however I don't use the 
			 * variables here, because the area is limited here. I will make declarations later, 
			 * after I finish the program wholly.
			 */
		}
	}
	
	/* I add it to replace the addEntry method, because the latter method cannot be used in 
	 * the main interface, that is, NameSurfer cannot use the things related to the 
	 * NameSurferDataBase Class directly. 
	 * So I will desert the addEntry method here. 
	 */
	public void addString(String name){
		if(nsdb.findEntry(name)!=null && !hmp.containsKey(name)){
			hmp.put(name, nsdb.findEntry(name));
			update();
		}
	}
	private HashMap<String,NameSurferEntry> hmp = new HashMap<String,NameSurferEntry>();

	public String set(){
		return hmp.keySet().toString();
	}
	
	private Color[] colorArray = new Color[]{Color.BLACK,Color.RED,Color.BLUE,Color.MAGENTA};
	
	private NameSurferDataBase nsdb = new NameSurferDataBase(NAMES_DATA_FILE);
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}

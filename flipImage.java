import acm.graphics.*;
import acm.program.*;

public class flipImage extends GraphicsProgram{

	public void run() {
		String address = "cuba.jpg";
		add(flipHorizontal(address));
		
	}
	
	
	private GImage flipHorizontal(String add){
		GImage image = new GImage(add,0,0);
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		int temp;
		add(new GLabel(height+","+width,30,30));
		for(int j=0;j<width*0.5;j++){
			for(int i=0;i<height;i++){
				temp = array[i][j];
				array[i][j] = array[i][width-1-j];
				array[i][width-1-j] = temp;
			}
		}
		return new GImage(array);
		//The return has been really important, to give back a GImage object of array! 
	}
}

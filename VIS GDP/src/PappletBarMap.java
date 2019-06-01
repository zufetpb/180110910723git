import java.awt.Color;

import processing.core.PApplet;

public class PappletBarMap extends PApplet {
	public void setup() {
		size(400, 300);
	}
	public void draw() {
	    background(255);
	    strokeWeight(0);
	    //stroke(0);
	    int[] height = new int [6];
	    int[] height2= new int [6];
	    String [] str = {"GDP","第一产业","第二产业","第三产业","金融","房地产"};
	    for( int i=0; i<6; i++ ) {
	    	height[i] = (int)Math.ceil(Data.gdpsum[Data.index][i]*200/Data.gdpsum_max[Data.index]);
	    	height2[6-i-1]=height[i];
	    }
	    for( int i=0; i<6; i++ ) {
	    	if(i==0)fill(210,105,30);
	    	else if(i==1)fill(255,248,200);
	    	else if(i==2)fill(135,206,250);
	    	else if(i==3)fill(255,215,0);
	    	else if(i==4)fill(255,228,181);
	    	else if(i==5)fill(210,105,30);
	    	beginShape();
	    	vertex(200,150+25*i);
	    	if(i!=0) vertex(200+height[i-1],150+25*i);
	    	else vertex(200+height[i],150+25*i);
	    	vertex(200+height[i],150+25*(i+1));
	    	vertex(200,150+25*(i+1));
	    	vertex(200,150-25*i);
	    	if(i!=0) vertex(200+height[i-1],150-25*i);
	    	else vertex(200+height[i],150-25*i);
	    	vertex(200+height[i],150-25*(i+1));
	    	vertex(200,150-25*(i+1));
	    	vertex(200,150+25*i);
	    	if(i!=0) vertex(200-height2[i-1],150+25*i);
	    	else vertex(200-height2[i],150+25*i);
	    	vertex(200-height2[i],150+25*(i+1));
	    	vertex(200,150+25*(i+1));
	    	vertex(200,150-25*i);
	    	if(i!=0) vertex(200-height2[i-1],150-25*i);
	    	else vertex(200-height2[i],150-25*i);
	    	vertex(200-height2[i],150-25*(i+1));
	    	vertex(200,150-25*(i+1));
	    	endShape();
	    }
	    strokeWeight(1);
	    stroke(255);
	    line(200,50,200,350);
	}
}

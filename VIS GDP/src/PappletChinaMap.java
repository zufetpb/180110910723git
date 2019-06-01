
import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;

import processing.core.PApplet;


public class PappletChinaMap extends PApplet{
	public void setup() {
		size(800, 500);
	}
	public void draw() {
		Data.update();
	    background(255);
	    strokeWeight(3);
	    stroke(60,100,0);
	    line(15,450,790,450);
	    for(int i=0; i<=31; i++ ) {
	    	strokeWeight(3);
		    stroke(60,100,0);
		    line(15+i*25,450,15+i*25,455);
	    }
	    line(15,450,15,50);
	    for(int i=0; i<31; i++ ) {
	    	int count=0;
	    	for( int j=0; j<6; j++ ) {
	    		if(Data.buttonFlag[j]==true) {
		    		strokeWeight(1);
		    	    if(j==0) fill(255,140,0);
		    	    else if(j==1) fill(135,206,250);
		    	    else if(j==2) fill(255,248,200);
		    	    else if(j==3) fill(255,215,0);
			    	else if(j==4) fill(255,228,181);
			    	else if(j==5) fill(210,105,30);
		    		int height = (int)Math.ceil(Data.yeardata[Data.index][i][j]*400/Data.yeardata_max[Data.index]);
		    		if(Data.buttonFlagCount!=0) rect(15+(i-1)*25+count*25/Data.buttonFlagCount, 450-height,25/Data.buttonFlagCount , height);
		    		count++;
	    		}
	    	}	    	
	    	String name = null;
			try {
				name = Data.diGui(Data.prodata[i].province);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fill(0);
    		if(i%2!=0) text(name,15+(i-1)*25,470);
    		else text(name,15+(i-1)*25,485);	
	    }
	    float start=0;
	    for( int i=0; i<Data.industryCount; i++){
	      strokeWeight(10);
	      if(i==0) stroke(255,140,0);
	      else if(i==1) stroke(135,206,250);
	      else if(i==2) stroke(255,248,200);
	      else if(i==3) stroke(255,215,0);
	      else if(i==4) stroke(255,228,181);
	      else if(i==5) stroke(210,105,30);
	      noFill();
	      for( int j=20; j<160; j+=25){
	    	  arc(700,100,j,j,start,(float) (start+TWO_PI/Data.yeardata[Data.index][PappletMap.index][0]*Data.yeardata[Data.index][PappletMap.index][i]));
	      }
	      start+=(float) (TWO_PI/Data.yeardata[Data.index][PappletMap.index][0]*Data.yeardata[Data.index][PappletMap.index][i]);
	    }
	    strokeWeight(5);
	    stroke(100,0,0,100);
	    line(15,50,790,50);text(Double.toString(Math.ceil(Data.yeardata_max[Data.index])),15,50);
	    line(15,150,790,150);text(Double.toString(Math.ceil(Data.yeardata_max[Data.index]*0.75)),15,150);
	    line(15,250,790,250);text(Double.toString(Math.ceil(Data.yeardata_max[Data.index]*0.5)),15,250);
	    line(15,350,790,350);text(Double.toString(Math.ceil(Data.yeardata_max[Data.index]*0.25)),15,350);
	}
}

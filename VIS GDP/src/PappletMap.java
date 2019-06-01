
import geomerative.RG;
import geomerative.RPoint;
import geomerative.RShape;
import processing.core.PApplet;
import processing.core.PGraphics;

public class PappletMap extends PApplet{
	PGraphics pgMap;
	RShape chinaMap, provinceMap;
	Coloring color = new Coloring(0, 80,5,15);
	ProvinceName pName = new ProvinceName();
	String overArea = "";
	String cityName[] = { "Xin_Jiang", "Xi_Zang", "Qing_Hai", "Yun_Nan",
		      "Gan_Su", "Si_Chuan", "Ning_Xia", "Chong_Qing", "Gui_Zhou",
		      "Guang_Xi", "Shan3_Xi", "Hai_Nan", "Nei_Meng_Gu", "Hu_Nan",
		      "Guang_Dong", "He_Nan", "Hu_Bei", "He_Bei", "Jiang_Xi", "Bei_Jing",
		      "Shan_Dong", "Tian_Jin", "An_Hui", "Jiang_Su", "Fu_Jian",
		      "Zhe_Jiang", "Shang_Hai", "Liao_Ning", "Ji_Lin", "Hei_Long_Jiang",
		      "Shan1_Xi", "Tai_Wan" };
	public static int index=1;
	public void setup() {
	    size(450, 400);
	    RG.init(this);
	    chinaMap = RG.loadShape("China.svg");

	    pgMap = createGraphics(620, 520);
	    pgMap.beginDraw();
	    pgMap.colorMode(HSB, 360, 100, 100); // É«²ÊÄ£Ê½HSB
	    pgMap.background(0, 0, 100);
	    pgMap.endDraw();
	}
	public void draw() {
	    background(255);
	    drawMap(pgMap);
	    image(pgMap, 0, 0,pgMap.width*10/14, pgMap.height*10/14);
	    showName();
	}
	public void drawMap(PGraphics pg) {
	    pg.beginDraw();
	    //pg.noStroke();
	    pg.stroke(0,100,100);
	    for (int i = 0; i < 31; i++) {
	    	Data.listPoints.clear();
	    	int provinceIndex = pName.GetProvinceIndex(cityName[i]);
	    	int colorVau = color.getColorData(Data.index, provinceIndex);
	    	colorVau=80-colorVau;
	    	int rCircleVau = color.getCircleR(Data.index, provinceIndex);
	    	rCircleVau=20-rCircleVau;
	        provinceMap = chinaMap.getChild(cityName[i]);
	        //provinceMap.draw(pg);
	        
	        pg.fill(colorVau,100,100);
	        RPoint mapCente = provinceMap.getCenter();
	        if(provinceMap.name.equals("Gan_Su"))  {
	        	mapCente = new RPoint(mapCente.x-40,mapCente.y-40);
	        	dfs.dfsRPoint(mapCente, provinceMap, rCircleVau);
	        	mapCente = new RPoint(mapCente.x+70,mapCente.y+70);
	        	dfs.dfsRPoint(mapCente, provinceMap, rCircleVau);
	        	
	        	for( int j=0; j<Data.listPoints.size(); j++ ) {
	        		RPoint point = Data.listPoints.get(j);
	        		pg.ellipse(point.x, point.y, rCircleVau, rCircleVau);
	        	}
	        	continue;
	        }
	        else if(provinceMap.name.equals("Nei_Meng_Gu")) mapCente = new RPoint(mapCente.x+25,mapCente.y+25);
	        else if(provinceMap.name.equals("Shan3_Xi")) mapCente = new RPoint(mapCente.x+20,mapCente.y-20);
	        else if(provinceMap.name.equals("He_Bei")) mapCente = new RPoint(mapCente.x-15,mapCente.y+15);
	        	
//	        pg.ellipse(mapCente.x, mapCente.y, 10, 10);
        	dfs.dfsRPoint(mapCente, provinceMap, rCircleVau);
	        for( int j=0; j<Data.listPoints.size(); j++ ) {
        		RPoint point = Data.listPoints.get(j);
        		pg.ellipse(point.x, point.y, rCircleVau, rCircleVau);
        	}
	    }
	    pg.endDraw();
	}
	public void mouseMoved() {
		RPoint p = new RPoint(mouseX*14/10,mouseY*14/10);
		int i=0;
		for(i=0; i<Data.provinceCount; i++ ) {
			if(chinaMap.children[i].contains(p)) {
				overArea = pName.GetProvinceChineseName(chinaMap.children[i].name);break;
			}
		}
		if(i==Data.provinceCount) overArea="";
	}
	public void mousePressed() {
		RPoint p = new RPoint(mouseX*14/10,mouseY*14/10);
		for( int i=0; i<chinaMap.countChildren(); i++ ) {
			if(chinaMap.children[i].contains(p)) {
				int index1 = pName.GetProvinceIndex(chinaMap.children[i].name);
				index = index1;
			}
		}
	}
	public void showName() {
		if(overArea!="") {
			stroke(0);
			strokeWeight(1);
			fill(255);
			rect(mouseX+10,mouseY+10,overArea.length()*15,20);
			fill(0);
			text(overArea, mouseX+15, mouseY+23);
		}
	}
}

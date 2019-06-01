import java.util.Arrays;

import geomerative.RG;
import geomerative.RPoint;
import geomerative.RShape;
import processing.core.PApplet;

public class dfs extends PApplet{
//	static RShape chinaMap, provinceMap;
	static RPoint point;
//	public void setup() {
//		size(450, 400);
//		RG.init(this);
//	}
	public static void dfsRPoint(RPoint p,RShape provinceMap,double r) {
		if(provinceMap.contains(p)==false) return;
		else {
			Data.listPoints.add(p);
			point = new RPoint(p.x+r,p.y);
			if(find(point)==false)dfsRPoint(point, provinceMap, r);
			point = new RPoint(p.x-r,p.y);
			if(find(point)==false)dfsRPoint(point, provinceMap, r);
			point = new RPoint(p.x,p.y+r);
			if(find(point)==false)dfsRPoint(point, provinceMap, r);
			point = new RPoint(p.x,p.y-r);
			if(find(point)==false)dfsRPoint(point, provinceMap, r);
		}
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PApplet.main("dfs");
//		chinaMap = RG.loadShape("China.svg");
//		provinceMap=chinaMap.getChild("Nei_Meng_Gu");
//		RPoint point = provinceMap.getCenter();
//		dfsRPoint(point, provinceMap, 10);
//		
//		System.out.println(Data.listPoints.size());
//	}
	public static boolean find(RPoint _point) {
		for( int i=0; i<Data.listPoints.size(); i++ ) {
			if(Data.listPoints.get(i).x==_point.x&&Data.listPoints.get(i).y==_point.y) return true;
		}
		return false;
	}
}

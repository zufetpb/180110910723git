
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

import geomerative.RPoint;

public class Data {
	public static int yearCount = 20;
	public static int provinceCount = 32;
	public static int industryCount = 6;
	public static int startYear = 1980;
	public static Province[] prodata = new Province[32];
	public static double [][][] yeardata = new double [yearCount][provinceCount][industryCount];
	public static double [] yeardata_max = new double [yearCount];
	public static double [][] gdpsum = new double [yearCount][industryCount];
	public static double [] gdpsum_max = new double [yearCount];
	public static boolean [] buttonFlag = {true,true,true,false,false,false};
	public static ArrayList<RPoint> listPoints =new ArrayList<RPoint>();
	public static int buttonFlagCount=0;
	ProvinceName pName = new ProvinceName();
	public static int index=0;
	public static int proindex=3;
	
	public void init(String url) {
		for (int i = 0; i < provinceCount; i++) {
			prodata[i] = new Province();
			prodata[i].province = "";
			for (int j = 0; j < industryCount; j++) {
				for (int k = 0; k < yearCount; k++) {
					prodata[i].industry[j][k] = 0;
				}
			}
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(url));
			String line;
			while((line = reader.readLine())!=null) {
				String [] str = line.split(",");
				int year = Integer.parseInt(str[0]);
				if (year < startYear || year>=startYear+yearCount ||str[2].equals("ÖÐ¹ú")) continue;
				int index = pName.GetProvinceIndex(str[2]);
				prodata[index].province = str[2];
				yeardata[year-startYear][index][0]=prodata[index].industry[0][year-startYear]=Double.parseDouble(str[3]);
				gdpsum[year-startYear][0]=Double.parseDouble(str[3]);
				yeardata[year-startYear][index][1]=prodata[index].industry[1][year-startYear]=Double.parseDouble(str[4]);
				gdpsum[year-startYear][1]=Double.parseDouble(str[4]);
				yeardata[year-startYear][index][2]=prodata[index].industry[2][year-startYear]=Double.parseDouble(str[5]);
				gdpsum[year-startYear][2]=Double.parseDouble(str[5]);
				yeardata[year-startYear][index][3]=prodata[index].industry[3][year-startYear]=Double.parseDouble(str[8]);
				gdpsum[year-startYear][3]=Double.parseDouble(str[8]);
				yeardata[year-startYear][index][4]=prodata[index].industry[4][year-startYear]=Double.parseDouble(str[12]);
				gdpsum[year-startYear][4]=Double.parseDouble(str[12]);
				yeardata[year-startYear][index][5]=prodata[index].industry[5][year-startYear]=Double.parseDouble(str[13]);
				gdpsum[year-startYear][5]=Double.parseDouble(str[13]);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		for( int i=0; i<yearCount; i++) {
			for( int j=0; j<provinceCount; j++ ) {
				yeardata_max[i]=Math.max(yeardata_max[i], yeardata[i][j][0]);
			}
		}
		for( int i=0; i<yearCount; i++) {
			for( int j=0; j<industryCount; j++ ) {
				gdpsum_max[i]=Math.max(gdpsum_max[i], gdpsum[i][j]);
			}
		}
		update();
	}
	public static void update() {
		buttonFlagCount=0;
		for( int i=0; i<industryCount; i++ ) if(buttonFlag[i]==true) buttonFlagCount++;
	}
	public static String diGui(String name)throws Exception{
		int length = name.getBytes("UTF-8").length;
		if(length>8) {
			name=name.substring(0, name.length()-1);
			name = diGui(name);
		}
		return name;
	}
}

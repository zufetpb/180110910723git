
public class Coloring {
	public int[][] colorData = new int[Data.yearCount][Data.provinceCount];
	public int[][] circleR = new int[Data.yearCount][Data.provinceCount];
	public int mindata=0x3f3f3f,maxdata=0;
	public Coloring(int l,int r,int l2,int r2) {
		findMinMax();
		for( int i=0; i<Data.yearCount; i++ ) {
			for( int j=0; j<Data.provinceCount; j++ ) {
				colorData[i][j]=(int) (l+(r-l)*(Data.yeardata[i][j][0])/(maxdata-mindata));
			}
		}
		for( int i=0; i<Data.yearCount; i++ ) {
			int mindata2=0x3f3f3f,maxdata2=0;
			for( int j=0; j<Data.provinceCount; j++ ) {
				if(Data.prodata[j].province.equals("中国")) continue;
				mindata2 = (int) Math.min(mindata2, Data.yeardata[i][j][0]);
				maxdata2 = (int) Math.max(maxdata2, Data.yeardata[i][j][0]);
			}
			for( int j=0; j<Data.provinceCount; j++ ) {
				circleR[i][j]=(int) (l2+(r2-l2)*(Data.yeardata[i][j][0])/(maxdata2-mindata2));
			}
		}
	}
	public void findMinMax(){
		for( int i=0; i<Data.yearCount; i++ ) {
			for( int j=0; j<Data.provinceCount; j++ ) {
				if(Data.prodata[j].province.equals("中国")) continue;
				mindata = (int) Math.min(mindata, Data.yeardata[i][j][0]);
				maxdata = (int) Math.max(maxdata, Data.yeardata[i][j][0]);
			}
		}
	}
	public int getColorData(int yearIndex,int proIndex) {
		if(yearIndex>Data.yearCount&&proIndex>Data.provinceCount) return 0;
		return colorData[yearIndex][proIndex];
	}
	public int getCircleR(int yearIndex,int proIndex) {
		if(yearIndex>Data.yearCount&&proIndex>Data.provinceCount) return 0;
		return circleR[yearIndex][proIndex];
	}
}

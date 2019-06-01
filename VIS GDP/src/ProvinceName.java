
/**
 * һ�������࣬����ʡ�ݵĸ������ݵ��໥ת��
 * @author Gavin
 *
 */
public class ProvinceName {
	public String[] provinceChineseName = new String[32];
	public String[] provinceEnglishName = new String[32];

	public ProvinceName() {
		provinceChineseName[0] = "�й�";
		provinceEnglishName[0] = "china";
		provinceChineseName[1] = "������";
		provinceEnglishName[1] = "Bei_Jing";
		provinceChineseName[2] = "�Ϻ���";
		provinceEnglishName[2] = "Shang_Hai";
		provinceChineseName[3] = "����ʡ";
		provinceEnglishName[3] = "Jiang_Su";
		provinceChineseName[4] = "�����";
		provinceEnglishName[4] = "Tian_Jin";
		provinceChineseName[5] = "�ӱ�ʡ";
		provinceEnglishName[5] = "He_Bei";
		provinceChineseName[6] = "������";
		provinceEnglishName[6] = "Chong_Qing";
		provinceChineseName[7] = "�Ĵ�ʡ";
		provinceEnglishName[7] = "Si_Chuan";
		provinceChineseName[8] = "����ʡ";
		provinceEnglishName[8] = "He_Nan";
		provinceChineseName[9] = "���Ļ���������";
		provinceEnglishName[9] = "Ning_Xia";
		provinceChineseName[10] = "����ʡ";
		provinceEnglishName[10] = "An_Hui";
		provinceChineseName[11] = "�㽭ʡ";
		provinceEnglishName[11] = "Zhe_Jiang";
		provinceChineseName[12] = "����ʡ";
		provinceEnglishName[12] = "Jiang_Xi";
		provinceChineseName[13] = "����ʡ";
		provinceEnglishName[13] = "Gui_Zhou";
		provinceChineseName[14] = "ɽ��ʡ";
		provinceEnglishName[14] = "Shan_Dong";
		provinceChineseName[15] = "ɽ��ʡ";
		provinceEnglishName[15] = "Shan1_Xi";
		provinceChineseName[16] = "����ʡ";
		provinceEnglishName[16] = "Shan3_Xi";
		provinceChineseName[17] = "����ʡ";
		provinceEnglishName[17] = "Hu_Nan";
		provinceChineseName[18] = "����ʡ";
		provinceEnglishName[18] = "Hu_Bei";
		provinceChineseName[19] = "����ʡ";
		provinceEnglishName[19] = "Gan_Su";
		provinceChineseName[20] = "����ʡ";
		provinceEnglishName[20] = "Liao_Ning";
		provinceChineseName[21] = "����ʡ";
		provinceEnglishName[21] = "Ji_Lin";
		provinceChineseName[22] = "������ʡ";
		provinceEnglishName[22] = "Hei_Long_Jiang";
		provinceChineseName[23] = "�㶫ʡ";
		provinceEnglishName[23] = "Guang_Dong";
		provinceChineseName[24] = "����׳��������";
		provinceEnglishName[24] = "Guang_Xi";
		provinceChineseName[25] = "�½�ά���������";
		provinceEnglishName[25] = "Xin_Jiang";
		provinceChineseName[26] = "���ɹ�������";
		provinceEnglishName[26] = "Nei_Meng_Gu";
		provinceChineseName[27] = "����ʡ";
		provinceEnglishName[27] = "Yun_Nan";
		provinceChineseName[28] = "�ຣʡ";
		provinceEnglishName[28] = "Qing_Hai";
		provinceChineseName[29] = "����������";
		provinceEnglishName[29] = "Xi_Zang";
		provinceChineseName[30] = "����ʡ";
		provinceEnglishName[30] = "Hai_Nan";
		provinceChineseName[31] = "����ʡ";
		provinceEnglishName[31] = "Fu_Jian";
	}
	
	public String GetProvinceEnglishName(String provinceChineseName) {
		int len = provinceEnglishName.length;
		for (int i = 0; i < len; i++) {
			if (provinceChineseName.equals(this.provinceChineseName[i])) {
				return provinceEnglishName[i];
			}
		}
		return null;
	}

	public String GetProvinceEnglishName(int index) {
		int len = provinceEnglishName.length;
		if (index < 0 || index >= len)
			return null;
		return provinceEnglishName[index];
	}

	public int GetProvinceIndex(String areaName) {
		int len = provinceEnglishName.length;
		for (int i = 0; i < len; i++) {
			if ((areaName.equals(provinceEnglishName[i]))
					|| (areaName.equals(provinceChineseName[i]))) {
				return i;
			}
		}
		return -1;
	}

	public String GetProvinceChineseName(String provinceEnglishName) {
		int len = provinceChineseName.length;
		for (int i = 0; i < len; i++) {
			if (provinceEnglishName.equals(this.provinceEnglishName[i])) {
				return provinceChineseName[i];
			}
		}
		return null;
	}

	public String GetProvinceChineseName(int index) {
		int len = provinceChineseName.length;
		if (index < 0 || index >= len)
			return null;
		return provinceChineseName[index];
	}
	public int GetProvinceCount(){
		return provinceChineseName.length;
	}
}

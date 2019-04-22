package util;

/**
 * �ṩ��ת������Ϊ����ľ�̬����
 * @author Mr.Hu
 *
 */
public class TranFromat {
	
	/**
	 * ��  String ���͵��ַ���ת��Ϊ int ���͵�����
	 * @param string ���������
	 * @return ת�����֮��� int ��������
	 */
	public static int[] String2Int(String string) {
		
		string = string.trim();
		
		String[] temp = string.split(" ");
		int[] target = new int[temp.length];
		
		for(int i = 0;i < target.length;i++) {
			target[i] = Integer.parseInt(temp[i]);
		}
		
		return target;
	}
	
	/**
	 * �� String ���͵��ַ���ת��Ϊ Double ���͵�����
	 * 
	 * @param string ���������
	 * @return ת�����֮��� double ���͵�����
	 */
	public static double[] String2Double(String string) {
		
		string = string.trim();
		
		String[] temp = string.split(" ");
		double[] target = new double[temp.length];
		
		for(int i = 0;i < target.length;i++) {
			target[i] = Double.parseDouble(temp[i]);
		}
		
		return target;
	}
}

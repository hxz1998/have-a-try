package util;

/**
 * 提供了转换数据为数组的静态方法
 * @author Mr.Hu
 *
 */
public class TranFromat {
	
	/**
	 * 将  String 类型的字符串转换为 int 类型的数组
	 * @param string 传入的数组
	 * @return 转换完成之后的 int 类型数组
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
	 * 将 String 类型的字符串转换为 Double 类型的数组
	 * 
	 * @param string 传入的数组
	 * @return 转换完成之后的 double 类型的数组
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

package controller.util;

/**
 * �����࣬���ڻ�ȡ��ɾ���б��л�ȡ��ֵ
 * @author Mr.Hu
 *
 */
public class UtilForGetItem {
	private int selectId;
	private int selectIndex;
	public UtilForGetItem(int selectId, int selectIndex) {
		this.selectId = selectId;
		this.selectIndex = selectIndex;
	}
	public int getSelectId() {
		return selectId;
	}
	public int getSelectIndex() {
		return selectIndex;
	}
	public void SetPara(int selectId, int selectIndex) {
		this.selectId = selectId;
		this.selectIndex = selectIndex;
	}
}

package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorAlert {
	public void showError() {
		Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("�д���");
    	alert.setHeaderText("���ݳ�����");
    	alert.setContentText("�������������Ƿ�������\n1.�����Ƿ�����һ��\n2.�Ƿ������˷Ƿ��ַ�");
    	alert.showAndWait();
	}
}

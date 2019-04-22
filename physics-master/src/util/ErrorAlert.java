package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorAlert {
	public void showError() {
		Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("有错误");
    	alert.setHeaderText("数据出错了");
    	alert.setContentText("请检查您的数据是否有问题\n1.数据是否少了一个\n2.是否输入了非法字符");
    	alert.showAndWait();
	}
}

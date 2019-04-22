package controller.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HallEffectController {
	@FXML
	private TextField IsText;
	@FXML
	private TextField ImText;
	@FXML
	private TextField V1Text;
	@FXML
	private TextField V2Text;
	@FXML
	private TextField V3Text;
	@FXML
	private TextField V4Text;
	@FXML
	private Button analyzeButton1;
	@FXML
	private Button analyzeButton2;
	
	public void calcForOne() {
		int isValue = Integer.parseInt(IsText.getText());
		int imValue = Integer.parseInt(ImText.getText());
		int v1 = Integer.parseInt(V1Text.getText());
	}
	
	public void calcForTwo() {
		
	}
}

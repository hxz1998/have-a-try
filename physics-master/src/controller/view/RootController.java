package controller.view;

import java.io.IOException;

import controller.MainFunction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.LayoutLoader;

public class RootController {
 
	@FXML
	private Button SolarCellButton;
	@FXML
	private Label topic; 
	private Stage primaryStage;
	private BorderPane rootPane;
	
	/**
	 * ��ʾ̫���ܵ�صĹ�������о����
	 */
	public void setSolarCell() {
		primaryStage = MainFunction.getRootStage();
		rootPane = MainFunction.getRootPane();
		LayoutLoader loader = new LayoutLoader("view/SolarCell.fxml");
		try {
			AnchorPane solarCellPane = (AnchorPane) loader.getLayout();
			rootPane.setCenter(solarCellPane);
			setStatement("����");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʾ--�ⶨ���Ų��ϵĻ����Ż����ߺʹ����������
	 */
	public void setMagnetization() {
		setStatement("���ڻ�ȡ��Դ...");
		rootPane = MainFunction.getRootPane();
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFunction.class.getResource("view/Magnetization.fxml"));
			rootPane.setCenter(loader.load());
			setStatement("����");
		} catch(IOException e) {
			e.printStackTrace();
			setStatement("��ȡ��Դʧ��");
		}
		
	}
	
	public void setHallEffect() {
		setStatement("���ڻ�ȡ��Դ...");
		rootPane = MainFunction.getRootPane();
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFunction.class.getResource("view/HallEffect.fxml"));
			rootPane.setCenter(loader.load());
			setStatement("����");
		} catch(IOException e) {
			e.printStackTrace();
			setStatement("��ȡ��Դʧ��");
		}
	}
	
	/**
	 * ���õ�ǰ״̬
	 * @param statement
	 */
	public void setStatement(String statement) {
		topic.setText(statement);
	}
	
	/**
	 * ��ʾ��ӭҳ��
	 */
	public void setMainLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFunction.class.getResource("view/MainLayout.fxml"));
		try{
			MainFunction.getRootPane().setCenter(loader.load());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʾ����ҳ��
	 */
	public void showAboutPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFunction.class.getResource("view/About.fxml"));
		try{
			AnchorPane aboutPane = loader.load();
			Scene scene = new Scene(aboutPane, 500, 600);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("�������");
			stage.setResizable(false);
			stage.getIcons().add(new Image(MainFunction.class.getResourceAsStream("view/icon/logo.png")));

			stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}






















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
	 * 显示太阳能电池的光电特性研究面板
	 */
	public void setSolarCell() {
		primaryStage = MainFunction.getRootStage();
		rootPane = MainFunction.getRootPane();
		LayoutLoader loader = new LayoutLoader("view/SolarCell.fxml");
		try {
			AnchorPane solarCellPane = (AnchorPane) loader.getLayout();
			rootPane.setCenter(solarCellPane);
			setStatement("就绪");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示--测定铁磁材料的基本磁化曲线和磁滞曲线面板
	 */
	public void setMagnetization() {
		setStatement("正在获取资源...");
		rootPane = MainFunction.getRootPane();
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFunction.class.getResource("view/Magnetization.fxml"));
			rootPane.setCenter(loader.load());
			setStatement("就绪");
		} catch(IOException e) {
			e.printStackTrace();
			setStatement("获取资源失败");
		}
		
	}
	
	public void setHallEffect() {
		setStatement("正在获取资源...");
		rootPane = MainFunction.getRootPane();
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainFunction.class.getResource("view/HallEffect.fxml"));
			rootPane.setCenter(loader.load());
			setStatement("就绪");
		} catch(IOException e) {
			e.printStackTrace();
			setStatement("获取资源失败");
		}
	}
	
	/**
	 * 设置当前状态
	 * @param statement
	 */
	public void setStatement(String statement) {
		topic.setText(statement);
	}
	
	/**
	 * 显示欢迎页面
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
	 * 显示关于页面
	 */
	public void showAboutPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFunction.class.getResource("view/About.fxml"));
		try{
			AnchorPane aboutPane = loader.load();
			Scene scene = new Scene(aboutPane, 500, 600);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("关于软件");
			stage.setResizable(false);
			stage.getIcons().add(new Image(MainFunction.class.getResourceAsStream("view/icon/logo.png")));

			stage.show();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}






















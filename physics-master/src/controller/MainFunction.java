package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainFunction extends Application {

	private static BorderPane rootLayout;
	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		initRootLayout();
		initMainLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * 载入根布局
	 */
	private void initRootLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFunction.class.getResource("view/RootLayout.fxml"));
		try{
			rootLayout = loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("一个计算器");
			primaryStage.getIcons().add(new Image(MainFunction.class.getResourceAsStream("view/icon/logo.png")));
			primaryStage.show();
//			primaryStage.setFullScreen(true);
//			primaryStage.initStyle(StageStyle.TRANSPARENT);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 载入主页面、
	 * ------其实就是一个欢迎界面。。
	 */
	private void initMainLayout() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainFunction.class.getResource("view/MainLayout.fxml"));
		try{
			AnchorPane mainPane = loader.load();
			rootLayout.setCenter(mainPane);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 辅助方法，获取根布局的一些属性
	 */
	public static Stage getRootStage() {
		return primaryStage;
	}
	public static BorderPane getRootPane() {
		return rootLayout;
	}
}


























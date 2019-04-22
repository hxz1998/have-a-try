package controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import controller.MePu;
import controller.model.DataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Login Controller.
 */
public class LoginController extends AnchorPane implements Initializable {

    
    private Stage primaryStage;
    private BorderPane rootPane;
    @Override
    /**
     * 初始化各项文本
     */
    public void initialize(URL location, ResourceBundle resources) {
    }
    
 
    
//	/**
//	 * 显示应用主窗口
//	 */
//	public void initRootWindow() {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(LoginController.class.getResource("RootPane.fxml"));
//		try {
//			rootPane = loader.load();
//			Scene scene = new Scene(rootPane);
//			primaryStage.setScene(scene);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//舞台展示场景
//		primaryStage.show();
//	}
//	
//	/**
//	 * 显示主应用窗口
//	 */
//	public void showMainWindow() {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(LoginController.class.getResource("MainPane.fxml"));
//		try{
//			AnchorPane anchorPane = loader.load();
//			rootPane.setCenter(anchorPane);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	class ChangeStage implements Runnable {
//		public void run() {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}finally{
//				initRootWindow();
//				showMainWindow();
//			}
//		}
//	}
}

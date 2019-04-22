/**
 * @author Mr.Hu
 * @version 1.0.5
 * @time 2017.08.28
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MePu extends Application implements Initializable{

	/**
	 * 一些来自登录框的控件
	 * 可见代码并不好，很乱
	 */
    @FXML
    private TextField userId;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Label errorMessage;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private ImageView closeWindow;
    @FXML
    private ImageView minWindow;
 
    
	private static Stage primaryStage;
	private Stage loginStage;//登录
	private static BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
//		this.primaryStage = loginStage;
//		primaryStage.setTitle("米普");
		primaryStage.initStyle(StageStyle.TRANSPARENT);
//		this.primaryStage.getIcons().add(new Image(MePu.class.getResourceAsStream("logo.png")));
		initLoginWindow();
		
//		切换主题
//		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);		
//		initRootWindow();
//		showMainWindow();
	}

	/**
	 * 切换主题
	 */
	public static void changeThemeToDark() {
		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
	}
	public static void changeThemeToLight() {
		Application.setUserAgentStylesheet(STYLESHEET_MODENA);
	}
	
	/**
	 * 显示登录窗口
	 */
	public void initLoginWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MePu.class.getResource("login.fxml"));
		try{
			AnchorPane loginPane = loader.load();
			Scene scene = new Scene(loginPane);
			primaryStage.setScene(scene);
		} catch(IOException e) {
			e.printStackTrace();
		}
		primaryStage.show();
	}
	
	
	/**
	 * 显示根布局
	 */
	public void initRootWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MePu.class.getResource("view/RootPane.fxml"));
		try {
			rootPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		primaryStage.setScene(scene);

		//舞台展示场景
		primaryStage.show();
	}
	
	/**
	 * 显示主应用窗口
	 */
	public void showMainWindow() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MePu.class.getResource("view/MainPane.fxml"));
		try{
			AnchorPane anchorPane = loader.load();
			rootPane.setCenter(anchorPane);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * 获取根布局
	 * @return 跟布局
	 */
	public static BorderPane getRootPane() {
		return rootPane;
	}
	/**
	 * 获取主要舞台
	 * @return
	 */
	public static Stage getRootStage() {
		return primaryStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        errorMessage.setText("");
        userId.setPromptText("User");
        password.setPromptText("Password");
	}
	
	/**
     * 登录校验账户
     */
    public boolean loginAccount() {
    	String USER = "";
		String PASS = "";
		errorMessage.setVisible(false);
		progressIndicator.setVisible(true);
		progressIndicator.setProgress(10);
    	USER = userId.getText();
    	PASS = password.getText();
//System.out.println(passWord);
		String sql_query = null;
		String  DB_URL = "jdbc:mysql://101.200.56.88/article?characterEncoding=utf-8";//一定要修改编码
		progressIndicator.setProgress(30);
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			progressIndicator.setProgress(50);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			progressIndicator.setProgress(90);
			conn.close();
			return true;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			errorMessage.setVisible(true);
			errorMessage.setText("对不起，请核对您的账户和密码。\n如果您的账户和密码确保正确无误请确保服务器开启。");
			progressIndicator.setProgress(0);
			progressIndicator.setVisible(false);
			return false;
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
		progressIndicator.setProgress(100);
		return false;
    }
    
    /**
     * 校验完成决定是否切换场景
     */
    public void changeToStage() {
    	if(loginAccount()) {
    		//登录成功切换场景
    		primaryStage.close();
    		initRootWindow();
    		showMainWindow();
    	}
    }
    
    /**
     * 处理一些乱七八糟的窗口事件特效，嗯，算是特效。。。
     */
    public void changeStyleMouseEnterForClose() {
    	closeWindow.setOpacity(1.0);
    }
    public void changeStyleMouseOutForClose() {
    	closeWindow.setOpacity(0.5);
    }
    public void changeStyleMouseEnterForMin() {
    	minWindow.setOpacity(1.0);
    }
    public void changeStyleMouseOutForMin() {
    	minWindow.setOpacity(0.5);
    }
    public void closeWindow() {
    	System.exit(0);
    }
    public void minWindow() {
    	primaryStage.setIconified(true);
    }
}

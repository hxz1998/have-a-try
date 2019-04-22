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
	 * һЩ���Ե�¼��Ŀؼ�
	 * �ɼ����벢���ã�����
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
	private Stage loginStage;//��¼
	private static BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
//		this.primaryStage = loginStage;
//		primaryStage.setTitle("����");
		primaryStage.initStyle(StageStyle.TRANSPARENT);
//		this.primaryStage.getIcons().add(new Image(MePu.class.getResourceAsStream("logo.png")));
		initLoginWindow();
		
//		�л�����
//		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);		
//		initRootWindow();
//		showMainWindow();
	}

	/**
	 * �л�����
	 */
	public static void changeThemeToDark() {
		Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
	}
	public static void changeThemeToLight() {
		Application.setUserAgentStylesheet(STYLESHEET_MODENA);
	}
	
	/**
	 * ��ʾ��¼����
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
	 * ��ʾ������
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

		//��̨չʾ����
		primaryStage.show();
	}
	
	/**
	 * ��ʾ��Ӧ�ô���
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
	 * ��ȡ������
	 * @return ������
	 */
	public static BorderPane getRootPane() {
		return rootPane;
	}
	/**
	 * ��ȡ��Ҫ��̨
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
     * ��¼У���˻�
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
		String  DB_URL = "jdbc:mysql://101.200.56.88/article?characterEncoding=utf-8";//һ��Ҫ�޸ı���
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
			errorMessage.setText("�Բ�����˶������˻������롣\n��������˻�������ȷ����ȷ������ȷ��������������");
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
     * У����ɾ����Ƿ��л�����
     */
    public void changeToStage() {
    	if(loginAccount()) {
    		//��¼�ɹ��л�����
    		primaryStage.close();
    		initRootWindow();
    		showMainWindow();
    	}
    }
    
    /**
     * ����һЩ���߰���Ĵ����¼���Ч���ţ�������Ч������
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

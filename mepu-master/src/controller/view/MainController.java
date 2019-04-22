package controller.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.model.DataModel;
import controller.util.ChatRobot;
import controller.util.SendMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.web.HTMLEditor;

public class MainController {
	@FXML
	private Button send;
	@FXML
	private Button clear;
	@FXML
	private HTMLEditor editor;
	@FXML
	private TextField title;
	@FXML
	private TextField link;
	@FXML
	private TextField overview;
	@FXML
	private ProgressIndicator progress;
	@FXML
	private SplitPane pane;
	@FXML
	private	TitledPane chatWindow;
	@FXML
	private AnchorPane messageWindow;
	@FXML
	private TextField userMessage;
	@FXML
	private TextArea robotMessage;
	
	/**
	 * 发送消息到用户
	 * @return
	 */
	public boolean sendMessageToUser() {
		try {
			SendMessage.sendMessage(title.getText(), overview.getText(), link.getText());
			progress.setProgress(100);
			/**
			 * 考虑是否启用下面的功能。
			 * 优点：交互性强，用户明确知道发送成功了。
			 * 缺点：可以用进度指示器代替，并且体验流畅。
			 * @author Mr.Hu
			 */
//			Alert alert = new Alert(AlertType.CONFIRMATION);
//			alert.setTitle("提示");
//			alert.setHeaderText("发送成功！");
//			alert.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("阿偶，有错误");
        	alert.setHeaderText("发送失败噜。");
        	alert.setContentText("请检查网络连接是否还在线、消息所填内容是否完整。");
        	alert.showAndWait();
        	return false;
		} finally {
			Thread t = new Thread(new SetProgress());
			t.start();
		}
		sendMessageToDatabase();
		return true;
	}
	
	/**
	 * 发送内容到服务器
	 * 正文内容以HTML格式储存
	 */
	public boolean sendMessageToDatabase() {
		String sql_query = null;
		String  DB_URL = "jdbc:mysql://101.200.56.88/article?characterEncoding=utf-8";//一定要修改编码
		String USER = "testroot";
		String PASS = "1111";
		PreparedStatement ps;
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//										   id name title cont artdata link 
			sql_query = "INSERT INTO articles VALUES (null, ?, ?, ?, now(), ?)";
			ps = conn.prepareStatement(sql_query);
			ps.setString(1, USER);
			ps.setString(2, title.getText()+"");
			ps.setString(3, editor.getHtmlText()+"");
			ps.setString(4, link.getText());
			ps.executeUpdate();
System.out.println(sql_query);
			conn.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
			
		}
		return true;
	}
	
	/**
	 * 清除所有内容
	 * @author Mr.Hu
	 */
	public void clearMessage() {
		title.setText("");
		editor.setHtmlText("");
		link.setText("");
		overview.setText("");
	}
	
	/**
	 * 给外部提供方法，处理显示窗口问题
	 * 暂时看起来没什么卵用
	 */
	public void closeChatWindow() {
		chatWindow.setVisible(false);
		pane.setDividerPosition(0, 0);
	}
	public void closeMessageWindow() {
		messageWindow.setVisible(false);
		pane.setDividerPosition(1, 1);
	}
	
	/**
	 * 与机器交互
	 */
	public void chatWithRobot() {
		String response = "";
		try {
			response = ChatRobot.getAnswer(userMessage.getText());
		} catch (IOException e) {
			robotMessage.setText("非常抱歉，机器人好像出故障了。");
			e.printStackTrace();
		}
		robotMessage.appendText("我："+userMessage.getText()+"\n\n");
		robotMessage.appendText("米普："+response+"\n\n");
		userMessage.setText("");
	}
	
	/**
	 * 辅助类，重置进度
	 * @author Mr.Hu
	 *
	 */
	class SetProgress implements Runnable {
		public void run() {
			try {
				Thread.sleep(2000);
				progress.setProgress(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

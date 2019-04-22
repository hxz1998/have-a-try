package controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import controller.MePu;
import controller.util.*;

public class DeleteController {

	@FXML
	private ObservableList<String> choiceItem = FXCollections.observableArrayList();
	@FXML 
	private ChoiceBox<String> deleteItem = new ChoiceBox<String>();
	@FXML
	private Button okButton;
	@FXML
	private ProgressIndicator progress;
	@FXML
	private Button refresh;
	
	//������ʵ��
	UtilForGetItem ufgi = new UtilForGetItem(0, 0);
	
	/**
	 * ��ʼ��
	 */
	@FXML
	public void initialize() {
		getItemsFromDatabase();
		deleteItemFromItems();	
	}
	
	/**
	 * ��ȡ��ɾ����Ŀ
	 */
	public void getItemsFromDatabase() {
		String sql_query = null;
		String  DB_URL = "jdbc:mysql://101.200.56.88/article?characterEncoding=utf-8";//һ��Ҫ�޸ı���
		String USER = "testroot";
		String PASS = "1111";
		String id,title;
		Statement stmt = null;
		Connection conn = null;
		try{
			choiceItem.remove(0, choiceItem.size());
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			sql_query = "Select id,title from articles order by id;";
//System.out.println(sql_query);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql_query);
			while(rs.next()) {
				id = rs.getString("id");title = rs.getString("title");
				choiceItem.add(new String(id+":"+title));
			}
			deleteItem.setItems(choiceItem);
			stmt.close();
			conn.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
			
		}
	}
	
	/**
	 * ��ȡҪɾ����Ŀ
	 */
	public void deleteItemFromItems() {
		deleteItem.getSelectionModel().selectedIndexProperty().addListener(
					(ObservableValue<? extends Number> ov,Number old_val, Number new_val) -> {
System.out.println(new_val.intValue());
						final String getSelectItem;final int selectId;
						if(new_val.intValue() == -1) {
						}else{
							getSelectItem = choiceItem.get(new_val.intValue());
							selectId = Integer.parseInt(getSelectItem.split(":")[0]);
//System.out.println(selectId);
							/**
							 * ���Ǹ��ǳ���Ҫ��һ�γ���
							 * �ڽʾ���֭֮�������һ�������Ǻܺõķ�ʽ������������
							 * ����Ժ����ٴο���һ��Ҫ��취���
							 * 
							 * ԭ�򣺲���Java8����ķ��������
							 */
							setItemFromItems(selectId, new_val.intValue());
						}
					}
				);
	}
	
	/**
	 * ��������������ɾ����Ŀ��Ϣ
	 * @param deleteId ---------�����ݿ���Ҫɾ����Id��
	 * @param getSelectId ------���б���Ҫɾ����Id��
	 */
	public void setItemFromItems(int deleteId, int getSelectId) {
		ufgi.SetPara(deleteId, getSelectId);
	}
	

	/**
	 * �����ݿ�ɾ��ָ����Ŀ��Ϣ
	 */
	public void deleteItemFromDatabase() {
		String sql_query = null;
		String  DB_URL = "jdbc:mysql://101.200.56.88/article?characterEncoding=utf-8";//һ��Ҫ�޸ı���
		String USER = "testroot";
		String PASS = "1111";
		progress.setProgress(10);
		String id,title;
		Statement stmt = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			progress.setProgress(20);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			progress.setProgress(50);
			sql_query = "Delete from articles where id = ?";
//System.out.println(sql_query);
//System.out.println(ufgi.getSelectId());
			ps = conn.prepareStatement(sql_query);
			progress.setProgress(60);
			ps.setInt(1, ufgi.getSelectId());
			ps.executeUpdate();
			progress.setProgress(70);
			choiceItem.remove(ufgi.getSelectIndex());
//System.out.println(choiceItem.get(ufgi.getSelectIndex()));
			choiceItem.remove(0, choiceItem.size());
			sql_query = "Select id,title from articles order by id;";
//System.out.println(sql_query);
			progress.setProgress(80);
			
			//ɾ�����֮�����¶�ȡ����������
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql_query);
			while(rs.next()) {
				id = rs.getString("id");title = rs.getString("title");
				choiceItem.add(new String(id+":"+title));
			}
			deleteItem.setItems(choiceItem);
			progress.setProgress(100);
			stmt.close();
			conn.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
			
		}		
	}
	
	/**
	 * �����࣬���ý���
	 * @author Mr.Hu
	 */
	class ManageProgressBar implements Runnable {
		@Override
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


















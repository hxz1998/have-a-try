package controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import controller.model.DataModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataController {
	
	@FXML
	private TableView<DataModel> database;
	@FXML
	private TableColumn<DataModel, String> idColumn;
	@FXML
	private TableColumn<DataModel, String> nameColumn;
	@FXML
	private TableColumn<DataModel, String> titleColumn;
	@FXML
	private TableColumn<DataModel, String> contColumn;
	@FXML
	private TableColumn<DataModel, String> linkColumn;
	@FXML
	private TableColumn<DataModel, String> dateColumn;
	
	//�ṩ���ݴ���λ��
	@FXML
	private static ObservableList<DataModel> data = FXCollections.observableArrayList();
	
	/**
	 * ��ʼ�����ݹ���
	 */
	@FXML
	public void initialize() {
		idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		contColumn.setCellValueFactory(cellData -> cellData.getValue().contProperty());
		linkColumn.setCellValueFactory(cellData -> cellData.getValue().linkProperty());
		dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
		
		clearDataFromDatabase();
		getDataFromDatabase();
	}
	
	/**
	 * ��ջ�ȡ����������
	 */
	public void clearDataFromDatabase() {
		data.remove(0, data.size());
	}
	
	/**
	 * �����ݿ��ȡ����
	 */
	public void getDataFromDatabase() {
		clearDataFromDatabase();
		String sql_query = null;
		String  DB_URL = "jdbc:mysql://101.200.56.88/article?characterEncoding=utf-8";//һ��Ҫ�޸ı���
		String USER = "testroot";
		String PASS = "1111";
		String id,name,cont,date,link,title;
		Statement stmt = null;
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			sql_query = "Select * from articles;";
System.out.println(sql_query);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql_query);
			while(rs.next()) {
				id = rs.getString("id");name = rs.getString("name");title = rs.getString("title");
				cont = rs.getString("cont");date = rs.getString("artdate");link = rs.getString("website");
				data.add(new DataModel(id, name, title, cont, link, date));
			}
			database.setItems(data);
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
	 * ��������
	 * @return
	 */
	public static ObservableList<DataModel> getData() {
		return data;
	}
	
	/**
	 * ��������
	 */
	public static void setData() {
		
	}
}

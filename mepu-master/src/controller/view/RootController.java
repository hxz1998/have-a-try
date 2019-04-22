package controller.view;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.controlsfx.dialog.Dialogs;

import controller.MePu;
import controller.model.DataModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController {
	
	@FXML
	private MenuItem showDatabase;
	@FXML
	private MenuItem showMessage;
	@FXML
	private MenuItem printData;
	@FXML
	private ProgressBar progressIndicator;
	@FXML
	private MenuItem deleteAction;	
	@FXML
	private MenuItem editAction; 	
	@FXML
	private MenuItem addAction;
	@FXML
    private ToggleGroup group;
	@FXML 
	private RadioMenuItem dark;
	@FXML 
	private RadioMenuItem light;
	@FXML
	private MenuItem exitAction;
	@FXML
	private ImageView close;
	@FXML
	private ImageView min;
	@FXML
	private ImageView max;
	@FXML 
	private CheckMenuItem messageWindow;
	@FXML 
	private CheckMenuItem chatWindow; 
	@FXML
	private MenuItem getHelp;
	@FXML
	private MenuItem getAbout;
	@FXML
	private static Stage helpStage;
	@FXML
	private static Stage aboutStage;
	
	private double X;
	private double Y;
	
	private static int[] windowInformation = new int[5]; 
	
	/**
	 * 在主页面展示数据库信息
	 */
	public void showDatabasePane() {
		progressIndicator.setProgress(10);
		BorderPane rootPane = MePu.getRootPane();
		progressIndicator.setProgress(20);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(RootController.class.getResource("DatabasePane.fxml"));
		progressIndicator.setProgress(40);
		AnchorPane databasePane;
		try {
			progressIndicator.setProgress(60);
			databasePane = loader.load();
			progressIndicator.setProgress(70);
			rootPane.setCenter(databasePane);
			progressIndicator.setProgress(100);
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(new ManageProgressBar()).start();
	}
	
	/**
	 * 在主页面展示消息发送信息
	 */
	public void showMessagePane() {
		progressIndicator.setProgress(10);
		BorderPane rootPane = MePu.getRootPane();
		FXMLLoader loader = new FXMLLoader();
		progressIndicator.setProgress(50);
		loader.setLocation(RootController.class.getResource("MainPane.fxml"));
		progressIndicator.setProgress(70);
		AnchorPane databasePane;
		try {
			databasePane = loader.load();
			progressIndicator.setProgress(90);
			rootPane.setCenter(databasePane);
			progressIndicator.setProgress(100);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		new Thread(new ManageProgressBar()).start();
	}
	
	/**
	 * 打印数据库信息
	 */
	public void printDatabase() {
		showDatabasePane();
		new Thread(new GetExcel()).start();
	}

	/**
	 * 展示删除页面
	 */
	public void showDeletePane() {
		FXMLLoader loader = new FXMLLoader();
		progressIndicator.setProgress(15);
		loader.setLocation(RootController.class.getResource("DeleteWindow.fxml"));
		progressIndicator.setProgress(30);
		try {
			progressIndicator.setProgress(39);
			AnchorPane page = loader.load();
			progressIndicator.setProgress(50);
			Scene scene = new Scene(page);
			Stage deleteStage = new Stage();
			deleteStage.setScene(scene);
			progressIndicator.setProgress(66);
			deleteStage.setTitle("您需要删除...");
			deleteStage.getIcons().add(new Image(RootController.class.getResourceAsStream("image/icon/paper-airplane.png")));	
			//固定首页面
			deleteStage.initModality(Modality.WINDOW_MODAL);
			deleteStage.initOwner(MePu.getRootStage());
			progressIndicator.setProgress(77);
			deleteStage.showAndWait();
			progressIndicator.setProgress(100);
			new Thread(new ManageProgressBar()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 展示更改页面
	 */
	public void showEditPane() {
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("抱歉");
    	alert.setHeaderText("功能尚未构建");
    	alert.setContentText("功能正在构建中，非常抱歉。\n\n提示：您可以删除条目后再添加实现相同功能。");
    	alert.showAndWait();
	}
	
	/**
	 * 展示增添页面
	 */
	public void showAddPane() {
		
	}
	
	/**
	 * 处理进度条归零
	 * @author Mr.Hu
	 */
	class ManageProgressBar implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				progressIndicator.setProgress(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}				
		}
	}
	
	/**
	 * 导出表格内容
	 * 使用线程实现
	 * @author Mr.Hu
	 */
	class GetExcel extends JFrame implements Runnable {
		public void run() {
			progressIndicator.setProgress(10);
			FileDialog fd = new FileDialog(this, "导出数据", FileDialog.SAVE);
//			File file = new File("/image/icon/paper-airplane.png");
//			try {
//				BufferedImage image = ImageIO.read(file);
//				fd.setIconImage(image);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			fd.setLocation(400, 250);  
			fd.setVisible(true);
			progressIndicator.setProgress(20);    
			String stringfile = fd.getDirectory()+fd.getFile()+".xls";    
			try {  
				GetExcel oDao = new GetExcel();  
				oDao.exportTable(DataController.getData(), new File(stringfile)); 
			     progressIndicator.setProgress(50); 
	        } catch (IOException ex) {  
System.out.println(ex.getMessage());  
	            ex.printStackTrace();  
	        }  
		}
		
		public void exportTable(ObservableList<DataModel> observableList, File file) throws IOException {  
	       BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));    
	       bWriter.write("文章ID号");bWriter.write("\t");
	       bWriter.write("标题");bWriter.write("\t");
	       bWriter.write("内容");bWriter.write("\t");
	       bWriter.write("链接");bWriter.write("\t");
	       bWriter.write("发表人");bWriter.write("\t");
	       bWriter.write("日期");bWriter.write("\t"); 
	       bWriter.newLine();  
	       for(int i=0; i< observableList.size(); i++) {  
//	           for(int j=0; j < 6; j++) {  
//	               bWriter.write(model.getValueAt(i,j).toString()); 
//	        	   if(observableList.get(j) == null) {
//	        		   bWriter.write("空");
//		               bWriter.write("\t");  
//		               continue;
//	        	   }
//	               bWriter.write(observableList.get(j).);
//	               bWriter.write("\t");  
//	           }  
	    	   bWriter.write(observableList.get(i).getId());
               bWriter.write("\t");  
	    	   bWriter.write(observableList.get(i).getTitle());
               bWriter.write("\t");   
	    	   bWriter.write(observableList.get(i).getCont());
               bWriter.write("\t");   
	    	   bWriter.write(observableList.get(i).getLink());
               bWriter.write("\t");   
	    	   bWriter.write(observableList.get(i).getName());
               bWriter.write("\t");   
	    	   bWriter.write(observableList.get(i).getDate());
               bWriter.write("\t");  
	           bWriter.newLine();  
	       }
		   progressIndicator.setProgress(100); 
	       bWriter.close();  
System.out.println(observableList.size());
System.out.println("write out to: " + file);  
	      new Thread(new ManageProgressBar()).start();
	   }  
	}
	
	/**
	 * 切换场景主题
	 * @author Mr.Hu
	 */
	public void setDartTheme() {
		MePu.changeThemeToDark();
	}
	public void setLightTheme() {
		MePu.changeThemeToLight();
	}
	
	/**
	 * 退出
	 */
	public void exitSystem() {
		System.exit(0);
	}
	
	/**
	 * 处理窗口事件
	 */
	public void closeWindow() {
		System.exit(0);
	}
	public void minWindow() {
		MePu.getRootStage().setIconified(true);
	}
	public void maxWindow() {
		if(windowInformation[4] == 1) {
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			MePu.getRootStage().setX(primaryScreenBounds.getMaxX()/12*1);
			MePu.getRootStage().setY(primaryScreenBounds.getMaxY()/12*1);
			MePu.getRootStage().setWidth(primaryScreenBounds.getWidth()/12*10);
			MePu.getRootStage().setHeight(primaryScreenBounds.getHeight()/12*10);
//			windowInformation[0] = (int) MePu.getRootStage().getWidth();
//			windowInformation[1] = (int) MePu.getRootStage().getHeight();
//			windowInformation[2] = (int) MePu.getRootStage().getX();
//			windowInformation[3] = (int) MePu.getRootStage().getY();
			windowInformation[4] = 0;
		}else{
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			MePu.getRootStage().setX(primaryScreenBounds.getMinX());
			MePu.getRootStage().setY(primaryScreenBounds.getMinY());
//			windowInformation[0] = (int) MePu.getRootStage().getWidth();
//			windowInformation[1] = (int) MePu.getRootStage().getHeight();
//			windowInformation[2] = (int) MePu.getRootStage().getX();
//			windowInformation[3] = (int) MePu.getRootStage().getY();
			MePu.getRootStage().setWidth(primaryScreenBounds.getWidth());
			MePu.getRootStage().setHeight(primaryScreenBounds.getHeight());
			windowInformation[4] = 1;
		}
	}
	public void getMouseX(MouseEvent e) {
		X = e.getSceneX() - MePu.getRootStage().getX();
		Y = e.getSceneY() - MePu.getRootStage().getY();
	}
	public void setRootStage(MouseEvent e) {
		MePu.getRootStage().setX(e.getSceneX() - X);
		MePu.getRootStage().setY(e.getSceneY() - Y);
	}
	
	/**
	 * 处理布局分布
	 * 其实就是显示不显示交互窗口和消息窗口
	 * 
	 * 不过该怎么做现在还没解决。
	 */
	public void showOrCloseMessageWindow() {
		System.out.println(666);
//		new MainController().closeMessageWindow();
	}
	public void showOrCloseChatWindow() {
		System.out.println(777);
//		new MainController().closeChatWindow();
	}
	
	/**
	 * 处理窗口事件特效
	 */
	public void changeStyleInToMin() {
		min.setOpacity(1.0);
	}
	public void changeStyleOutMin() {
		min.setOpacity(0.6);
	}
	public void changeStyleInToMax() {
		max.setOpacity(1.0);
	}
	public void changeStyleOutMax() {
		max.setOpacity(0.6);
	}
	public void changeStyleInToClose() {
		close.setOpacity(1.0);
	}
	public void changeStyleOutClose() {
		close.setOpacity(0.6);
	}

	/**
	 * 打开帮助
	 */
	public void showHelpPane() {
		FXMLLoader loader = new FXMLLoader();
		progressIndicator.setProgress(15);
		loader.setLocation(RootController.class.getResource("HelpPane.fxml"));
		progressIndicator.setProgress(30);
		try {
			progressIndicator.setProgress(39);
			AnchorPane page = loader.load();
			progressIndicator.setProgress(50);
			Scene scene = new Scene(page);
			helpStage = new Stage();
			helpStage.initStyle(StageStyle.TRANSPARENT);
			helpStage.setScene(scene);
			progressIndicator.setProgress(66);
			progressIndicator.setProgress(77);
			helpStage.show();
			progressIndicator.setProgress(100);
			new Thread(new ManageProgressBar()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 获取help的舞台
	 * @return
	 */
	public static Stage getHelpStage() {
		return helpStage;
	}
	
	/**
	 * 打开关于
	 */
	public void showAboutWindow() {
		FXMLLoader loader = new FXMLLoader();
		progressIndicator.setProgress(15);
		loader.setLocation(RootController.class.getResource("AboutWindow.fxml"));
		progressIndicator.setProgress(30);
		try {
			progressIndicator.setProgress(39);
			AnchorPane page = loader.load();
			progressIndicator.setProgress(50);
			Scene scene = new Scene(page);
			aboutStage = new Stage();
			aboutStage.initStyle(StageStyle.TRANSPARENT);
			aboutStage.setScene(scene);
			progressIndicator.setProgress(66);
			aboutStage.initModality(Modality.WINDOW_MODAL);
			aboutStage.initOwner(MePu.getRootStage());
			progressIndicator.setProgress(77);
			aboutStage.showAndWait();
			progressIndicator.setProgress(100);
			new Thread(new ManageProgressBar()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 * 获取关于的舞台
	 * @return
	 */
	public static Stage getAboutStage() {
		return aboutStage;
	}
}

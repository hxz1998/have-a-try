package controller.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import util.ErrorAlert;

public class MagnetizationController {
	@FXML
	private Button analyzeButton1;
	@FXML
	private Button analyzeButton2;
	@FXML
	private TextField UText;
	@FXML
	private TextField BText;
	@FXML
	private TextField HText;
	@FXML
	private TextField BText2;
	@FXML
	private TextField HText2;
	static boolean pressFirst = true; 
	static double x1 = 0;
	static double y1 = 0;
	static double x2 = 0;
	static double y2 = 0;
	
	/**
	 * 绘制基本磁化曲线与μ-H曲线
	 */
	public void calcForOne() {
		String UInput = UText.getText().trim();
		String BInput = BText.getText().trim();
		String HInput = HText.getText().trim();
		String[] UValue = UInput.split(" ");
		String[] BValue = BInput.split(" ");
		String[] HValue = HInput.split(" ");
		double[] U = new double[UValue.length];
		double[] B = new double[BValue.length];
		double[] H = new double[HValue.length];
		double[] niu = new double[U.length];
		if(U.length == B.length && U.length == H.length && (U.length != 0)) {
			try{
				for(int j = 0;j < U.length;j++) {
					U[j] = Double.parseDouble(UValue[j]);
					B[j] = Double.parseDouble(UValue[j]);
					H[j] = Double.parseDouble(HValue[j]);
					niu[j] = B[j] / H[j];
				}
				Stage stage = new Stage();
				stage.setTitle("您要的分析");
				TabPane tabpane = new TabPane();
				Tab tab = new Tab("基本磁化曲线");
				tabpane.getTabs().add(tab);
				
				final NumberAxis xAxis = new NumberAxis(); 
				final NumberAxis yAxis = new NumberAxis();
				final LineChart<Number, Number>lineChart = new LineChart<Number, Number>(xAxis, yAxis);
				xAxis.setLabel("H(A/m)");
				XYChart.Series series1 = new XYChart.Series();
				series1.getData().add(new XYChart.Data(0, 0));
				for(int j = 0;j < U.length;j++) {
					series1.getData().add(new XYChart.Data(H[j], B[j]));
				}
				series1.setName("基本磁化曲线");
				lineChart.getData().add(series1);
				
				//μ-H曲线
				XYChart.Series series2 = new XYChart.Series();
				series2.getData().add(new XYChart.Data(0, 0));
				for(int j = 0;j < U.length;j++) {
					series2.getData().add(new XYChart.Data(H[j], niu[j] * 1000));
				}
				series2.setName("μ-H曲线");
				lineChart.getData().add(series2);
				tab.setContent(lineChart);
				
				lineChart.getYAxis().setVisible(false);
				yAxis.setVisible(false);
				
				Scene scene = new Scene(lineChart, 800, 600);
				stage.setScene(scene);
				stage.show();
			
			}catch(RuntimeException e) {
				new ErrorAlert().showError();
			}
			
		} else {
			new ErrorAlert().showError();
		}
	}
	
	/**
	 * 绘制磁滞曲线
	 */
public void calcForTwo() {
	String BInput = BText2.getText().trim();
	String HInput = HText2.getText().trim();
	String[] BValue = BInput.split(" ");
	String[] HValue = HInput.split(" ");
	double[] B = new double[BValue.length];
	double[] H = new double[HValue.length];
	if(B.length != 0 && (B.length == H.length)) {
		double xStart = 300, yStart = 300;
		
		try{
			for(int j = 0;j < BValue.length;j++) {
				B[j] = Double.parseDouble(BValue[j]);
				H[j] = Double.parseDouble(HValue[j]);
			}
			Stage stage = new Stage();
			stage.setTitle("您要的分析");
			final NumberAxis xAxis = new NumberAxis();
			final NumberAxis yAxis = new NumberAxis();
			LineChart<Number, Number> linchart = new LineChart<Number, Number>(xAxis, yAxis);
			xAxis.setLabel("H(A/m)");
			yAxis.setLabel("B(T)");
			XYChart.Series<Number, Number> series = new XYChart.Series<>();
			for(int j = 0;j < BValue.length;j++) {
				series.getData().add(new XYChart.Data<>(H[j], B[j]));
			}
			series.setName("B-H曲线");
			linchart.getData().add(series);
			
			
			Canvas canvas = new Canvas(700, 700);
			Group root = new Group();
			root.getChildren().add(canvas);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setStroke(Color.BLACK);
			gc.setLineWidth(1);
			
			//绘制坐标轴
			gc.strokeLine(0, 300, 700, 300);
			gc.strokeLine(300, 0, 300, 700);
			
			double tX = H[H.length - 1]*1000, tY = -B[B.length - 1]*1000;
			double tranStartX, tranStartY, tranEndX, tranEndY;
			for(int j = 0;j < BValue.length;j++) {
				tranStartX = H[j]*1000;tranStartY = -B[j]*1000;
				gc.strokeLine((tX+xStart), (tY+yStart), (tranStartX+xStart), (tranStartY+yStart));
				tX = tranStartX;tY = tranStartY;
			}
			//没用的画图
			canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {   
					if(pressFirst) {
						pressFirst = false;
//							x1 = e.getSceneX();
//							y1 = e.getSceneY();
					} else {
						WritableImage image = canvas.snapshot(new SnapshotParameters(), null); 
						File file = new FileChooser().showSaveDialog(stage);
						String fileName = file.getAbsolutePath()+".png";
						File fileinput = new File(fileName);
						try {
							ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", fileinput);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			canvas.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
				}
			});
			gc.stroke();
			stage.setScene(new Scene(root, 600, 600));
			stage.setResizable(false);
			stage.show();
			
		} catch(RuntimeException e) {
			new ErrorAlert().showError();
			e.printStackTrace();
		}
	}
	
}
}






















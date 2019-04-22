package controller.view;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import util.ErrorAlert;

public class SolarCellController {
	@FXML
	private Button clearButton;
	@FXML
	private Button analyzeButton1;
	@FXML
	private TextField uText1;
	@FXML
	private TextField iText1;
	@FXML
	private ProgressBar progressBar;
	@FXML
	private Label topic1;
	@FXML
	private TextField LUX;
	@FXML
	private TextField Uoc;
	@FXML
	private TextField Isc;
	@FXML
	private Button analyzeButton2;
	@FXML
	private Label topic2;
	@FXML
	private Button analyzeButton3;
	@FXML
	private TextField LUX2;
	@FXML
	private TextField RText;
	@FXML
	private TextField UText;
	@FXML
	private TextField IText;
	@FXML
	private TextField PText;
	@FXML
	private TextField PMax;
	@FXML
	private TextField IMax;
	@FXML
	private TextField UMax;
	@FXML
	private TextField FF; 
	
	/**
	 * ���Ƶ�һ��Ҫ��
	 */
	public void calcForOne_solarCell() {
		String u = uText1.getText().trim();
		String i = iText1.getText().trim();
		String[] uu = u.split(" ");
		String[] ii = i.split(" ");
		double[] uuu = new double[uu.length];
		double[] iii = new double[ii.length];
		if(uuu.length == iii.length && (!u.equals("")) && (!i.equals(""))) {
			topic1.setVisible(false);
			try{
				for(int j = 0;j < uuu.length;j++) {
					uuu[j] = Double.parseDouble(uu[j]);
					iii[j] = Double.parseDouble(ii[j]);
				}
				Stage stage = new Stage();
				stage.setTitle("��Ҫ�ķ���");
				final NumberAxis xAxis = new NumberAxis();
				final NumberAxis yAxis = new NumberAxis();
				xAxis.setLabel("��ѹ");
				yAxis.setLabel("����");
				final LineChart<Number, Number>lineChart = new LineChart<Number, Number>(xAxis, yAxis);
				lineChart.setTitle("I-U����");
				XYChart.Series series = new XYChart.Series();
				series.setName("I-U����");
				for(int j = 0;j < uuu.length;j++) {
					series.getData().add(new XYChart.Data(uuu[j], iii[j]));
				}
				Scene scene = new Scene(lineChart, 800, 600);
				lineChart.getData().add(series);
				stage.setScene(scene);
				stage.show();
			}catch(RuntimeException e) {
				new ErrorAlert().showError();
			}
		} else {
			topic1.setVisible(true);
			topic1.setText("�������ݲ��Ϸ�");
		}
		
	}
	
	/**
	 * ���Ƶڶ���Ҫ��
	 */
	public void calcForTwo_solarCell() {
		String luxValue = LUX.getText().trim();
		String uocValue = Uoc.getText().trim();
		String iscValue = Isc.getText().trim();
		String[] lux2Array = luxValue.split(" ");
		String[] uoc2Array = uocValue.split(" ");
		String[] isc2Array = iscValue.split(" ");
		double[] lux = new double[lux2Array.length];
		double[] uoc = new double[uoc2Array.length];
		double[] isc = new double[isc2Array.length];
		if((lux.length != uoc.length || lux.length != isc.length || uoc.length != isc.length) || (lux.length == 0 || uoc.length == 0 || isc.length == 0)){
			topic2.setVisible(true);
			topic2.setText("�������ݲ��Ϸ�");
		} else {
			topic2.setVisible(false);
			try{
				for(int j = 0;j < lux.length;j++) {
					lux[j] = Double.parseDouble(lux2Array[j]);
					uoc[j] = Double.parseDouble(uoc2Array[j]);
					isc[j] = Double.parseDouble(isc2Array[j]);
				}
				Stage stage = new Stage();
				stage.setTitle("��Ҫ�ķ���");
				final NumberAxis xAxis = new NumberAxis();
				final NumberAxis yAxis = new NumberAxis();
				final LineChart<Number, Number>lineChart = new LineChart<Number, Number>(xAxis, yAxis);
				xAxis.setLabel("����ǿ��(LUX)");
				lineChart.setTitle("Isc-�����߼�Uoc-������");
				XYChart.Series series1 = new XYChart.Series();
				series1.setName("Isc-������");
				for(int j = 0;j < lux.length;j++) {
					series1.getData().add(new XYChart.Data(lux[j], isc[j]));
				}
				Scene scene = new Scene(lineChart, 800, 600);
				lineChart.getData().add(series1);
				XYChart.Series series2 = new XYChart.Series();
				series2.setName("Uoc-������");
				for(int j = 0;j < lux.length;j++) {
					series2.getData().add(new XYChart.Data(lux[j], uoc[j]));
				}
				lineChart.getData().add(series2);
				stage.setScene(scene);
				stage.show();
			} catch(RuntimeException e) {
				new ErrorAlert().showError();
			}

		}
		
	}
	
	/**
	 * ���Ƶ�����Ҫ��
	 */
	public void calcForThree_solarCell() {
		int index = 0;
		String lux = LUX2.getText().trim();
		String RValue = RText.getText().trim();
		String UValue = UText.getText().trim();
		String IValue = IText.getText().trim();
		String[] R2Array = RValue.split(" ");
		String[] U2Array = UValue.split(" ");
		String[] I2Array = IValue.split(" ");
		double[] P = new double[R2Array.length];
		double[] R = new double[R2Array.length];
		double[] U = new double[U2Array.length];
		double[] I = new double[I2Array.length];
		if(R.length != U.length || R.length != I.length || U.length != I.length || R.length == 0 || U.length == 0 || I.length == 0) {
			new ErrorAlert().showError();
		} else {
			try{
			for(int j = 0;j < R.length;j++) {
				R[j] = Double.parseDouble(R2Array[j]);
				U[j] = Double.parseDouble(U2Array[j]);
				I[j] = Double.parseDouble(I2Array[j]);
				P[j] = U[j] * I[j];
				DecimalFormat df = new DecimalFormat("#0.00");
				PText.appendText(df.format(P[j])+"  ");
			}
			
			for(int j = 0;j < P.length;j++) {
				if(P[index] < P[j]) {
					index = j;
				}
			}
			PMax.setText(P[index]+"");
			IMax.setText(I[index]+"");
			UMax.setText(U[index]+"");
			FF.setText(""+P[index]/(U[0]*I[I.length-1]));
			
			Stage stage1 = new Stage();
			stage1.setTitle("��Ҫ�ķ���");
			TabPane tabpane = new TabPane();
			Tab tab = new Tab("U-I����");
			Tab tab2= new Tab("P-R����");
			tabpane.getTabs().add(tab);
			tabpane.getTabs().add(tab2);
			Scene scene = new Scene(tabpane, 800, 600);

			//����U-I����
			final NumberAxis xAxis = new NumberAxis();
			final NumberAxis yAxis = new NumberAxis();
			final LineChart<Number, Number>lineChart = new LineChart<Number, Number>(xAxis, yAxis);
			xAxis.setLabel("����");
			yAxis.setLabel("��ѹ");
			lineChart.setTitle("U-I����");
			XYChart.Series series1 = new XYChart.Series();
			for(int j = 0;j < U.length;j++) {
				series1.getData().add(new XYChart.Data(I[j], U[j]));
			}
			series1.setName("U-I����");
			lineChart.getData().add(series1);
			tab.setContent(lineChart);
			
			//����P-R����
			final NumberAxis xAxis1 = new NumberAxis();
			final NumberAxis yAxis1 = new NumberAxis();
			final LineChart<Number, Number>lineChart1 = new LineChart<Number, Number>(xAxis1, yAxis1);
			xAxis1.setLabel("���ص�����ֵ");
			yAxis1.setLabel("����");
			lineChart1.setTitle("P-R����");
			tab2.setContent(lineChart1);
			XYChart.Series series2 = new XYChart.Series();
			for(int j = 0;j < U.length;j++) {
				series2.getData().add(new XYChart.Data(R[j], P[j]));
			}
			series2.setName("P-R����");
			lineChart1.getData().add(series2);
			
			
			stage1.setScene(scene);
			stage1.show();
			
			} catch(RuntimeException e) {
				new ErrorAlert().showError();
			}
			
		}
		
	}
	
	public void clearData() {
		
	}
}


















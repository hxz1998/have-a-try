package util;

import java.io.IOException;

import controller.MainFunction;
import javafx.fxml.FXMLLoader;

public class LayoutLoader {
	private FXMLLoader loader = new FXMLLoader();
	private String fileName;
	
	public LayoutLoader(String fileName) {
		this.fileName = fileName;
	}
	
	public Object getLayout() throws IOException{
		loader.setLocation(MainFunction.class.getResource(fileName));
		return loader.load();
	}
}

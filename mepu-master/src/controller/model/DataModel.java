package controller.model;

import javafx.beans.property.*;

public class DataModel {
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty title;
	private final SimpleStringProperty cont;
	private final SimpleStringProperty link;
	private final SimpleStringProperty date;

//	private  int id;
//	private  String name;
//	private  String title;
//	private  String cont;
//	private  String link;
//	private  String date;
	
	public DataModel(String id, String name, String title, String cont, String link, String date) {
//		this.id = id;
//		this.name = name;
//		this.title = title;
//		this.cont = cont;
//		this.link = link;
//		this.date = date;
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
		this.title = new SimpleStringProperty(title);
		this.cont = new SimpleStringProperty(cont);
		this.link = new SimpleStringProperty(link);
		this.date = new SimpleStringProperty(date);
	}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public SimpleStringProperty idProperty() {
		return id;
	}
	
	public String getTitle() {
		return title.get();
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	public StringProperty titleProperty() {
		return title;
	}
	
	public String getCont() {
		return cont.get();
	}
	public void setCont(String cont) {
		this.cont.set(cont);
	}
	public StringProperty contProperty() {
		return cont;
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	public String getLink() {
		return link.get();
	}
	public void setLink(String link) {
		this.link.set(link);
	}
	public StringProperty linkProperty() {
		return link;
	}
	
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.name.set(date);
	}
	public StringProperty dateProperty() {
		return date;
	}

	
//	public String getName() {
//		return name;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public String getCont() {
//		return cont;
//	}
//	public String getLink() {
//		return link;
//	}
//	public String getDate() {
//		return date;
//	}
}

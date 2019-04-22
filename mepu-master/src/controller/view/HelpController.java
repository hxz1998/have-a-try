package controller.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import controller.MePu;
import controller.util.WebViewPane;
import controller.view.RootController.ManageProgressBar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelpController {
	
	private String MYURL = "http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=1eTh4_Ps4eLl5_aVpKT7trq4%22%20";
	private String MYBLOG = "http://101.200.56.88/huxiaozhong/";
	
	@FXML
	private ImageView closeWindow;
	@FXML
	private ImageView minWindow;
	@FXML
	private Hyperlink myMail;
	@FXML
	private Hyperlink myblog;	
	@FXML
	private final WebView myBrowser = new WebView();
	private final WebEngine webengine = myBrowser.getEngine();
	
	/**
	 * ���Ǹ�ʧ�ܵķ�����
	 * Ŀ�ģ�ʹ���Լ����������ָ��URL����
	 * @serialData 2017/08/28
	 * @param url
	 */
	public void loadUrl(String url) {
		if(myBrowser == null) {
			System.out.println("�յ�");
		}else{
			
			webengine.load(url);
		}
	}
	
	/**
	 * д�Ÿ���
	 */
	public void sendMailToMe() {
		URI uri;
		try {
			uri = new URI(MYURL);
			Desktop dtp = Desktop.getDesktop();
			if(Desktop.isDesktopSupported()){
				dtp.browse(uri);
			}
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����ҵĲ���
	 */
	public void visitMyBlog() {
		URI uri;
		try {
			uri = new URI(MYBLOG);
			Desktop dtp = Desktop.getDesktop();
			if(Desktop.isDesktopSupported()){
				dtp.browse(uri);
			}
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �������¼�
	 */
	public void minWindow() {
		RootController.getHelpStage().setIconified(true);
	}
	public void closeWindow() {
		RootController.getHelpStage().close();
	}
}

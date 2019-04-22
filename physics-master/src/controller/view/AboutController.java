package controller.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutController {
	
	private String MYURL = "http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=1eTh4_Ps4eLl5_aVpKT7trq4%22%20";
	private String MYBLOG = "http://www.jianshu.com/u/34ec03873eba";
	
	public void showMailToMe() {
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
	
	public void showMyBlog() {
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
}

package controller.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AboutController {
	
	@FXML
	private Label first;
	@FXML
	private Label second;
	@FXML
	private Label third;
	@FXML
	private Label forth;
	@FXML
	private Label fifth;
	@FXML
	private Label sixth;
	@FXML
	private Label seventh;
	@FXML
	private Hyperlink eighth;
	@FXML
	private ImageView closeWindow;
	
	private static String MYURL = "http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=1eTh4_Ps4eLl5_aVpKT7trq4%22%20";
	private String[] message = {
			"嗯...",
			"我们是矿大信控学生...",
			"没错，是这样的...",
			"下面是我们的邮箱，如果您和我们一样有兴趣",
			"做一些奇奇怪怪的玩具..",
			"非常希望和您交朋友",
			"~ . ~",
			"我的邮箱"};
	
	/**
	 * 弹出我的邮箱
	 */
	public void sendEmailToMe() {
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
	 * 关闭窗口
	 */
	public void closeAboutWindow() {
		RootController.getAboutStage().close();
	}
	
	/**
	 * 启动输入
	 * 
	 * 暂时没做出来，日后再做，今天比较忙了。。哎。
	 * 
	 */
	public void setCont() {
//		first.setText("");
//		second.setText("");
//		third.setText("");
//		forth.setText("");
//		fifth.setText("");
//		sixth.setText("");
//		seventh.setText("");
//		eighth.setText("");
//		new Thread(new SetCont()).start();
	}
	
	/**
	 * 辅助类，用来处理文本动态输入。
	 * @author Mr.Hu
	 *
	 */
	class SetCont implements Runnable {
		public void run() {
			char[] firstMess = message[0].toCharArray();
			for(int i = 0;i < firstMess.length;i++) {
				for(int j = 0;j < i;j++) {
					//first.setText(firstMess[i]+"");
					System.out.print(firstMess[i]);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

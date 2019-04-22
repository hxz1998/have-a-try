package controller.util;

import java.util.Map;

import javax.swing.JTextArea;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.http.IGtPush;

public class GetRespond {
	JTextArea obj =  new JTextArea(); 
	//您应用的mastersecret
	private static final String MASTERSECRET = "O7JrXdABta5uuy0kJQhRN7";
	//您应用的appkey
	private static final String APPKEY = "uB4kX5w4vs5kByVaOpEIX4";
	//您要查询的taskid
	private static final String TASKID = "OSA-0721_unyWTE5Mf78RgauaMRwLhA";
	static String host ="http://sdk.open.api.igexin.com/apiex.htm";
	public void getResponed(JTextArea obj) {
		this.obj = obj;
		IGtPush push = new IGtPush(host,APPKEY, MASTERSECRET);
		Map<String, Object> res = (Map<String, Object>) push.getPushResult(TASKID).getResponse();
		String gt = res.get("GT").toString();
	}

}

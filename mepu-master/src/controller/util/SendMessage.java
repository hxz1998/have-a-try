package controller.util;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendMessage {

    private static String appId = "IVOjrEdRUIA8mgxMmH77U1";
    private static String appKey = "SosCHfUNvxAeOAJj0UFEO5";
    private static String masterSecret = "ufJ2RVJMnp7Sq08dfy2BE1";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void sendMessage(String title,String content, String website) throws IOException {

        IGtPush push = new IGtPush(url, appKey, masterSecret);

        // ����"������Ӵ�֪ͨģ��"�������ñ��⡢���ݡ�����
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle(title);
        template.setText(content);
        template.setUrl(website);

        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // ����"AppMessage"������Ϣ����������Ϣ����ģ�塢���͵�Ŀ��App�б��Ƿ�֧�����߷��͡��Լ�������Ϣ��Ч��(��λ����)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 86400);/* ��Ϣ���ߴ���24Сʱ*/

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}


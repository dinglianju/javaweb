package org.dlj.demo1.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * MyHttpSessionListener类实现了HTTPSessionListener接口，
 * 因此可以对HttpSession对象的创建和销毁这两个动作进行监听
 * @author zhxg
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(se.getSession() + " 创建了!!");
	}
	
	/**
	 * HTTPSession的销毁时机需要在web.xml中进行配置，如下：
	 * 	<session-config>
	 * 		<session-timeout>1</session-timeout>
	 * 	</session-config>
	 * 这样配置表示session在一分钟之后销毁
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁了！！");
	}
}

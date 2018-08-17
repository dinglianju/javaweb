package org.dlj.web.view;

import javax.servlet.http.HttpServletRequest;

import org.dlj.web.context.WebContext;

/**
 * 需要发送到客户端显示的数据模型
 * @author zhxg
 *
 */
public class ViewData {

	private HttpServletRequest request;
	
	public ViewData() {
		initRequest();
	}
	
	private void initRequest() {
		// 从requestHodler中获取request对象
		this.request = WebContext.requestHodler.get();
	}
	
	public void put(String name, Object value) {
		this.request.setAttribute(name, value);
	}
}
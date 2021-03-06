package org.dlj.demo1.observer;

/**
 * 设计一个Person类作为事件源，这个类的对象的行为（比如吃饭、跑步）可以被其他的对象监听
 * @ClassName: Person（事件源）
 * @author zhxg
 *
 */
public class Person {

	/*
	 * 在Person类中定义一个PersonListener变量来记住传递进来的监听器
	 */
	private PersonListener listener;
	
	public void eat() {
		if (listener != null) {
			/*
			 * 调用监听器的doeat方法监听Person类对象eat这个动作，将事件对象Event传递给doeat方法，
			 * 事件对象封装了事件源，new Event(this)中的this代表的就是事件源
			 */
			listener.doeat(new Event(this));
		}
	}
	
	public void run() {
		if (listener != null) {
			listener.dorun(new Event(this));
		}
	}
	
	/**
	 * 注册对Person类对象的行为进行监听的监听器
	 * @param listener
	 */
	public void registerListener(PersonListener listener) {
		this.listener = listener;
	}
}

interface PersonListener {
	
	/**
	 * 这个方法用来监听Person对象eat这个行为动作
	 * 当实现类实现doeat方法时就可以监听到Person类对象eat这个动作
	 * @param e
	 */
	void doeat(Event e);
	
	/**
	 * 这个方法用来监听Person对象run这个行为动作
	 * @param e
	 */
	void dorun(Event e);
}

class Event {
	
	private Person source;
	
	public Event() {
		
	}
	
	public Event(Person source) {
		this.source = source;
	}
	
	public Person getSource() {
		return source;
	}
	
	public void setSource(Person source) {
		this.source = source;
	}
}
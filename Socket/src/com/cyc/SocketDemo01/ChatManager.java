//
// 管理对话、连接
//


package com.cyc.SocketDemo01;

import java.util.Vector;

public class ChatManager {

	// 单例化类
	private ChatManager() {}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager() {
		return cm;
	}
	
	// 新建集合对象来存储ChatSocket
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	// 为当前集合添加socket对象
	public void add(ChatSocket cs) {
		
		vector.add(cs);
		
	}
	
	
	// 线程调用方法向其他线程发送信息
	public void publish(ChatSocket cs, String out) {
		
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket csChatSocket = vector.get(i);
			if (!cs.equals(csChatSocket)) {
				csChatSocket.out(out);
			}
		}
	}
}

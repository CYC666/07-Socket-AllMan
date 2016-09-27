//
// 本线程用于监听客户端的接入
//

package com.cyc.SocketDemo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {


	// 复写run方法
	@Override
	public void run() {
		//		// TODO Auto-generated method stub
		//		super.run();

		// 新建一个socket对象	指定端口：1-65535，一般取很大的值 捕获异常
		try {
			ServerSocket serverSocket = new ServerSocket(12345);

			// 循环监听设备接入
			while (true) {
			// 建立一个连接，会阻塞线程
			// 每当有一个客户端连接到服务器，就会返回一个socket
			Socket socket = serverSocket.accept();

			// 建立连接
			JOptionPane.showMessageDialog(null, "曹老师连接到了本机端口12345");
			
			// 将socket传递给新的线程
			ChatSocket chatSocket =  new ChatSocket(socket);
			chatSocket.start();
			
			// 将chatSocket添加到聊天管理器当中 
			ChatManager.getChatManager().add(chatSocket);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

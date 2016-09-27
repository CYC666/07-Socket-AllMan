//
// 本线程用于socket通信
//


package com.cyc.SocketDemo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	
	private Socket socket;
	
	public ChatSocket (Socket s) {
		
		this.socket = s;
		
	}
	
	// 添加输出方法out
	public void out (String out) {
		try {
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	// 复写run方法,执行后台功能
	@Override
	public void run() {
////		// TODO Auto-generated method stub
////		super.run();
//		
//		// 获取socket输出流,通过输出流向外输出数据(添加异常捕获)
//		try {
////			socket.getOutputStream();
//			
////			 数据的输出
//			BufferedWriter bfw = new BufferedWriter(
//									new OutputStreamWriter(
//											socket.getOutputStream()));
//			
//			int count = 0;
//			while (true) {
//				bfw.write("CYC666"+count);
//				sleep(1000);
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		int count = 0;
		
		// 创建读数据流
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			String line = null;
			// 是否读取到数据
			while ((line = bufferedReader.readLine()) != null) {
				// 发送
//				out("CYC"+count);
//				count++;
//				try {
//					sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				// 接收
				ChatManager.getChatManager().publish(this, line);
				
			}
			// 关闭当前流
			bufferedReader.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

}

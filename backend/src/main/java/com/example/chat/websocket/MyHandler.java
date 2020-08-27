package com.example.chat.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

	private final List<WebSocketSession> allConn = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		if(allConn.size() < 2) {
			allConn.add(session);
		}

		if (allConn.size() == 2) {
			System.out.println(allConn.get(1));
		}


	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		allConn.remove(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		if (allConn.size() == 2) {
			System.out.println(message);
			int mySession = allConn.indexOf(session);
			if (mySession == 0) {
				WebSocketSession userSession = allConn.get(1);
				userSession.sendMessage(message);
			} else {
				WebSocketSession userSession = allConn.get(0);
				userSession.sendMessage(message);
			}
		}

	}

}

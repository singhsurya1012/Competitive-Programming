package com.spring.websocket;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        //Invoked after WebSocket negotiation has succeeded and the WebSocket connection is opened and ready for use.
        System.out.println("Session - " + session.getAttributes());
        sessions.add(session);
        System.out.println("Connection Established");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus status) throws IOException {
        //Invoked after the WebSocket connection has been closed by either side, or after a transport error has occurred
        session.close();
        sessions.remove(session);
        System.out.println("Closing Connection");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
            TextMessage message) throws IOException {
        //Invoked when a new WebSocket message arrives.

        System.out.println("Inside handleTextMessage");
        System.out.println(message);
        for (WebSocketSession webSocketSession: sessions){
            if(webSocketSession.isOpen()) {
                System.out.println("Session - " + webSocketSession + " Message - " + message);
                webSocketSession.sendMessage(message);
            }
        }
        //session.sendMessage(message);

        /*for(WebSocketSession webSocketSession : sessions) {
            Map value = new Gson().fromJson(message.getPayload(), Map.class);
            webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
        }*/
    }

}
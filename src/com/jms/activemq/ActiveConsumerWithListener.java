package com.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *@author   quyf
 *@version  1.0.0
 *@date 	2015-8-18  下午9:12:11 
 */

public class ActiveConsumerWithListener {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory;		//连接工厂
		Connection connection;
		Session session;
		Destination destination;
		MessageConsumer consumer;
		
		factory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_USER,
				"tcp://127.0.0.1:61616");
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//		destination=session.createQueue("test1");
		destination=session.createTopic("testTopic");
		consumer = session.createConsumer(destination);
		consumer.setMessageListener(new MessageListener(){

			@Override
			public void onMessage(Message message) {
				System.out.println( "shoudao:"+message );
			}
			
		});
		
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		session.close();
		connection.close();
//		while(true){
//			TextMessage msg=(TextMessage) consumer.receive(1000);
//			if( msg!=null ){
//				System.out.println( msg );
//			}else{
//				continue;
//			}
//		}
		//connection.close();
	}

}

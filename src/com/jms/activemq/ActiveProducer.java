package com.jms.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *@author   quyf
 *@version  1.0.0
 *@date 	2015-8-18  下午3:00:05 
 *admin url:http://127.0.0.1:8161/admin/index.jsp
 */

public class ActiveProducer {
	
	/**
	 * @param args
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory;	//连接工厂，JMS用它创建连接
		Connection connection;		//JMS客户端到Provider的连接
		Session session;			//一个发送或接收消息的线程
		Destination destination;	//消息目的地，消息发送给谁
		MessageProducer producer;	//消息发送者
		
		factory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, 
				"tcp://localhost:61616");
		//从工厂得到连接对象
		connection = factory.createConnection();
		//启动
		connection.start();
		//获取操作连接
		session= connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//destination = session.createQueue("test1");
		destination = session.createTopic("testTopic");
		producer = session.createProducer( destination );
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
		sendMessage(session,producer);
		session.commit();
		
		connection.close();
	}

	private static void sendMessage(Session session, MessageProducer producer) throws JMSException {
		for(int i=0;i<5;i++){
			TextMessage message=session.createTextMessage("activemq msg:"+i);
			System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
			producer.send(message);
		}
	}

}

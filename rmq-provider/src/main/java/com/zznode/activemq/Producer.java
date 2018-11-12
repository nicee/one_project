package com.zznode.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author rookie
 * @project one_project
 * @time 2018/11/7.14:44
 */
public class Producer {

    static final int SEND_NUMBER = 10000;

    public static void main(String[] args) {
        //ConnectionFactory: 连接工厂，JMS用它创建连接
        ConnectionFactory connectionFactory;
        //Connection: JMS客户端到JMS Provider的连接
        Connection connection = null;
        //Session: 一个发送或接收消息的线程
        Session session;
        //Destination: 消息的目的地；消息的接收者
        Destination destination;
        //MessageProducer:消息发送者
        MessageProducer producer;

        //TextMessage message;
        //构造ConnectionFactory实例对象，此处采用ActiveMQ的实现jar
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://192.168.38.1:61616"
        );

        try {
            //构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            //启动
            connection.start();
            //获取操作连接
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue,须在ActiveMQ的console配置
            // destination = session.createQueue("jyQueue");
            destination = session.createTopic("cmdTopic");
            //得到消息生成者（也就是发送者）
            // producer = session.createProducer(destination);
            producer = session.createProducer(destination);
            //设置不持久化，此处学习所用，实际情况请根据项目决定
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            //构造消息，这里写死了，项目就是参数，或者方法获取
            sendMessage(session, producer);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
                // nothing to do
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 1; i <= SEND_NUMBER; i++) {
            TextMessage message = session.createTextMessage("ActiveMQ...发送消息..." + i);
            //发送消息到目的地
            System.out.println("发送消息：" + "ActiveMQ...发送的消息..." + i);
            producer.send(message);
        }
    }

}

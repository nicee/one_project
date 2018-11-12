package com.zznode.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author rookie
 * @project one_project
 * @time 2018/11/7.14:49
 */
public class Consumer {

    public static void main(String[] args) {
        //ConnectionFactory : 连接工厂，JMS用它来创建连接
        ConnectionFactory connectionFactory;
        //Connection: JMS客户端到JMS Provider的连接
        Connection connection = null;
        //Session: 一个发送或接收消息的线程
        Session session;
        //Destination: 消息的目的地；消息的接收者
        Destination destination;
        //消费者，消息接收者
        MessageConsumer consumer;

        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://192.168.38.1:61616"
        );
        try {
            //构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            connection.setClientID("idea");

            //启动
            connection.start();
            //获取操作连接
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在ActiveMQ的console配置
            destination = session.createQueue("Q_DS_1");
            consumer = session.createConsumer(destination);
            // destination = session.createTopic("cmdTopic");
            // consumer = session.createConsumer(destination);

//            consumer.setMessageListener(message -> {
//                if (null != message && message instanceof TextMessage) {
//                    try {
//                        System.out.println("收到消息..." + ((TextMessage) message).getText());
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });

            while (true) {
                //设置接收者接收消息的时间，为了便于测试，这里定位100s
                TextMessage message = (TextMessage) consumer.receive(100000);
                if (null != message) {
                    System.out.println("收到消息..." + message.getText().length());
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) connection.close();
            } catch (Throwable ignore) {
                // nothing to do
            }
        }
    }

}

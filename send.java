package javafile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class send {
    public static void main(String[] args) throws Exception {
        
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.sina.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //ʹ��JavaMail�����ʼ���5������
        //1������session
        Session session = Session.getInstance(prop);
        //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
        session.setDebug(true);
        //2��ͨ��session�õ�transport����
        Transport ts = session.getTransport();
        //3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp��������
        //�û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
        ts.connect("smtp.sina.com", "dorm6331", "lihaohao12");
        //4�������ʼ�
        Message message = createSimpleMail(session);
        //5�������ʼ�
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
    
 
    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
        //�����ʼ�����
        MimeMessage message = new MimeMessage(session);
        //ָ���ʼ��ķ�����
        message.setFrom(new InternetAddress("dorm6331@sina.com"));
        //ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("dorm6331@sina.com"));
        //�ʼ��ı���
        System.out.println("�������⣺"); 
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));  
        String input1 = a.readLine();
        message.setSubject(input1);
          //�ʼ����ı�����
          
          
          System.out.println("�������ݣ�"); 
          BufferedReader b = new BufferedReader(new InputStreamReader(System.in));  
          String input2 = b.readLine();
          message.setContent(input2, "text/html;charset=UTF-8");
          //���ش����õ��ʼ�����
          return message;
    }
}
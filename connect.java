package javafile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class connect {
    public static boolean connectionn(String username,String password) {
        
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.sina.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //ʹ��JavaMail�����ʼ���5������
        //1������session
        try {
        	
        
        Session session = Session.getInstance(prop);
        //����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
        session.setDebug(true);
        //2��ͨ��session�õ�transport����
        Transport ts = session.getTransport();
        //3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp��������
        //�û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
        ts.connect("smtp.sina.com", username, password);
        //4�������ʼ�
       
        ts.close();
        return true;
        }catch (Exception e){
			return false;
		}
    }
    
 
    
}
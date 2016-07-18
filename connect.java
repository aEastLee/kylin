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
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        try {
        	
        
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，
        //用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.sina.com", username, password);
        //4、创建邮件
       
        ts.close();
        return true;
        }catch (Exception e){
			return false;
		}
    }
    
 
    
}
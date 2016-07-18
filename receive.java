package javafile;

    import java.io.BufferedReader;  
    import java.io.InputStreamReader;  
    import java.util.Properties;   
    import javax.mail.Folder;  
    import javax.mail.Message;  
    import javax.mail.Session;  
    import javax.mail.Store;  
    
    public class receive0 {  
        public static void main(String[] args) throws Exception {  
            // 连接pop3服务器的主机名、协议、用户名、密码  
            String pop3Server = "pop3.sina.com";  
            String protocol = "pop3";  
            String user = "dorm6331@sina.com";  
            String pwd = "lihaohao12";  
              
            // 创建一个有具体连接信息的Properties对象  
            Properties props = new Properties();  
            props.setProperty("mail.store.protocol", protocol);  
            props.setProperty("mail.pop3.host", pop3Server);  
              
            // 使用Properties对象获得Session对象  
            Session session = Session.getInstance(props);  
            session.setDebug(true);  
              
            // 利用Session对象获得Store对象，并连接pop3服务器  
            Store store = session.getStore();  
            store.connect(pop3Server, user, pwd);  
            System.out.println("以上是connect的部分");
            // 获得邮箱内的邮件夹Folder对象，以"只读"打开  
            Folder folder = store.getFolder("inbox");  
            folder.open(Folder.READ_ONLY);  
              
            // 获得邮件夹Folder内的所有邮件Message对象  
            Message [] messages = folder.getMessages();  
              
            int mailCounts = messages.length;
            System.out.println("共有 " + mailCounts + "封邮件的主题，以下是其主题和地址：" );
            for(int i = 0; i < mailCounts; i++) {  
                  
                String subject = messages[i].getSubject();  
                String from = (messages[i].getFrom()[0]).toString();  
                  
                System.out.println("第 " + (i+1) + "封邮件的主题：" + subject);  
                System.out.println("第 " + (i+1) + "封邮件的发件人地址：" + from);  
                System.out.println("  ");
            } 
            
            for(; ; ) {  
                
            	System.out.println("输入您要打开的邮件编号（以#取消查看）：");
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
                String input = br.readLine(); 
                if("#".equalsIgnoreCase(input))
            	{
            		break;
            	}
                for(int i = 0; i < mailCounts; i++) {  
                	String s = String.valueOf(i+1);
                	if(s.equalsIgnoreCase(input))
                	{
                		String subject = messages[i].getSubject();  
                        String from = (messages[i].getFrom()[0]).toString(); 
                		System.out.println("第 " + (i+1) + "封邮件的主题：" + subject);  
                        System.out.println("第 " + (i+1) + "封邮件的发件人地址：" + from);
                		messages[i].writeTo(System.out); 
                		
                	}

                }
                 
            }
            folder.close(false);  
            store.close();  
        }  
    } 
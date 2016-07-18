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
            // ����pop3����������������Э�顢�û���������  
            String pop3Server = "pop3.sina.com";  
            String protocol = "pop3";  
            String user = "dorm6331@sina.com";  
            String pwd = "lihaohao12";  
              
            // ����һ���о���������Ϣ��Properties����  
            Properties props = new Properties();  
            props.setProperty("mail.store.protocol", protocol);  
            props.setProperty("mail.pop3.host", pop3Server);  
              
            // ʹ��Properties������Session����  
            Session session = Session.getInstance(props);  
            session.setDebug(true);  
              
            // ����Session������Store���󣬲�����pop3������  
            Store store = session.getStore();  
            store.connect(pop3Server, user, pwd);  
            System.out.println("������connect�Ĳ���");
            // ��������ڵ��ʼ���Folder������"ֻ��"��  
            Folder folder = store.getFolder("inbox");  
            folder.open(Folder.READ_ONLY);  
              
            // ����ʼ���Folder�ڵ������ʼ�Message����  
            Message [] messages = folder.getMessages();  
              
            int mailCounts = messages.length;
            System.out.println("���� " + mailCounts + "���ʼ������⣬������������͵�ַ��" );
            for(int i = 0; i < mailCounts; i++) {  
                  
                String subject = messages[i].getSubject();  
                String from = (messages[i].getFrom()[0]).toString();  
                  
                System.out.println("�� " + (i+1) + "���ʼ������⣺" + subject);  
                System.out.println("�� " + (i+1) + "���ʼ��ķ����˵�ַ��" + from);  
                System.out.println("  ");
            } 
            
            for(; ; ) {  
                
            	System.out.println("������Ҫ�򿪵��ʼ���ţ���#ȡ���鿴����");
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
                		System.out.println("�� " + (i+1) + "���ʼ������⣺" + subject);  
                        System.out.println("�� " + (i+1) + "���ʼ��ķ����˵�ַ��" + from);
                		messages[i].writeTo(System.out); 
                		
                	}

                }
                 
            }
            folder.close(false);  
            store.close();  
        }  
    } 
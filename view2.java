package javafile;

import javafile.connect;
import javafile.view3;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class view2{
 
	//frame����һ���´���
	static Frame frm = new Frame("�ʼ�");
 
    public static void main(String[] args){
     BorderLayout border = new BorderLayout(5,10);//ˮƽ��ࡢ��ֱ���
     //GridLayout grid = new GridLayout(2,2);
     //panel����һ������,���ﴴ��������,
     Panel pan1 = new Panel();
     
     pan1.setLayout(null);//ȡ��panel��Ĭ�ϸ�ʽ
     pan1.setSize(500,40);//���
     Panel pan2 = new Panel();
     pan2.setLayout(null);
     pan2.setSize(500,150);
     Panel pan3 = new Panel();
     pan3.setLayout(null);
     pan3.setSize(500,150);
     //label���ı�
     Label label1 = new Label("sina�����¼",Label.CENTER);
     label1.setSize(500,40);
     Label label2 = new Label("�û�����",Label.RIGHT);
     label2.setLocation(60,10);
     label2.setSize(100,30);
     
     Label label3 = new Label("��    �룺",Label.RIGHT);
     label3.setLocation(60,70);
     label3.setSize(100,30);

     Label label4 = new Label("@sina.com");
     label4.setLocation(350,10);
     label4.setSize(150,30);

     //textfield�����
     final TextField tf1 = new TextField("",20);
     tf1.setBounds(200, 10, 150, 30);
     final TextField tf2 = new TextField("",20);
     tf2.setEchoChar('*');
     tf2.setBounds(200, 70, 150, 30);
     //button��ť
     Button bt1 = new Button("��¼");
     bt1.setBounds(220,70,80,30);   
     //actionlistener�¼�����
     bt1.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			connect c = new connect();
			String username = tf1.getText();
			String password = tf2.getText();
			int flag = -1;
			if(c.connectionn(username, password)){
				new view2().frm.dispose();
				   
				new OpenJFrame("��¼�ɹ�");
			}
			else {
				new view2().frm.dispose();
				   
				new OpenJFrame("��¼ʧ��");
			}
		}
    	 
    	 
     });


    
     

     //����frame����
     frm.setLayout(border);//��Ҳ����
     frm.setSize(500,350);//��С
     frm.setBackground(Color.white);//����
     frm.setLocation(350,100);//����λ��
     
        pan1.add(label1);//�����ӵ�panel����
        pan2.add(label2);
        pan2.add(tf1);
        pan2.add(label4);
        pan2.add(label3);
        
        pan2.add(tf2);
        pan3.add(bt1);

     frm.add(pan1,BorderLayout.NORTH);//�����ŵ�����,���ڷ�λ��
     frm.add(pan2,BorderLayout.CENTER);
     frm.add(pan3,BorderLayout.SOUTH);
     
     frm.setVisible(true);//���ÿɼ�
     frm.addWindowListener(new WinCloser());//�رմ���
    }
    public static class WinCloser extends WindowAdapter{
      public void windowClosing(WindowEvent e){ 
       System.exit(0);
 
      }
 
    }
    }


 
class OpenJFrame extends JFrame{
	 public OpenJFrame(final String s){
	  JPanel jp2 = new JPanel(new BorderLayout());
	  this.setSize(380,245);//this��ʾ���openjframe�����һ������,ֱ����panel�Ϳ���
	  this.add(jp2,BorderLayout.CENTER);
	  //���ô˴�����ԶΪ���Ϸ� ��window�ķ���
	  this.setAlwaysOnTop(true);
	  //�������û��ı䴰�ڵĴ�С
	  this.setResizable(false);
	  //�ô�������Ļ�����м���ʾ
	  this.setLocationRelativeTo(null); 
	  this.setTitle(s);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);

	  JLabel labresult = new JLabel("123");
	  labresult.setSize(380, 150);
	  
	  jp2.add(labresult);
	  System.out.println(s);

	  
			if("��¼�ɹ�".equalsIgnoreCase(s)){
				
				this.dispose();
				view3 newview = new view3();
				newview.totalview();
				System.out.println("��½�ɹ�");

				
			}
			else {
				System.out.println("��½ʧ��");
				System.exit(0);
				
			}
			
		
		  
		  
	
	  
	  
	  
	 }
	}




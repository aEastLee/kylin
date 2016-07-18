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
 
	//frame创建一个新窗口
	static Frame frm = new Frame("邮件");
 
    public static void main(String[] args){
     BorderLayout border = new BorderLayout(5,10);//水平间距、垂直间距
     //GridLayout grid = new GridLayout(2,2);
     //panel创建一个容器,这里创建了三个,
     Panel pan1 = new Panel();
     
     pan1.setLayout(null);//取消panel的默认格式
     pan1.setSize(500,40);//宽高
     Panel pan2 = new Panel();
     pan2.setLayout(null);
     pan2.setSize(500,150);
     Panel pan3 = new Panel();
     pan3.setLayout(null);
     pan3.setSize(500,150);
     //label是文本
     Label label1 = new Label("sina邮箱登录",Label.CENTER);
     label1.setSize(500,40);
     Label label2 = new Label("用户名：",Label.RIGHT);
     label2.setLocation(60,10);
     label2.setSize(100,30);
     
     Label label3 = new Label("密    码：",Label.RIGHT);
     label3.setLocation(60,70);
     label3.setSize(100,30);

     Label label4 = new Label("@sina.com");
     label4.setLocation(350,10);
     label4.setSize(150,30);

     //textfield输入框
     final TextField tf1 = new TextField("",20);
     tf1.setBounds(200, 10, 150, 30);
     final TextField tf2 = new TextField("",20);
     tf2.setEchoChar('*');
     tf2.setBounds(200, 70, 150, 30);
     //button按钮
     Button bt1 = new Button("登录");
     bt1.setBounds(220,70,80,30);   
     //actionlistener事件监听
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
				   
				new OpenJFrame("登录成功");
			}
			else {
				new view2().frm.dispose();
				   
				new OpenJFrame("登录失败");
			}
		}
    	 
    	 
     });


    
     

     //设置frame窗口
     frm.setLayout(border);//我也不懂
     frm.setSize(500,350);//大小
     frm.setBackground(Color.white);//背景
     frm.setLocation(350,100);//设置位置
     
        pan1.add(label1);//组件添加到panel容器
        pan2.add(label2);
        pan2.add(tf1);
        pan2.add(label4);
        pan2.add(label3);
        
        pan2.add(tf2);
        pan3.add(bt1);

     frm.add(pan1,BorderLayout.NORTH);//容器放到窗口,并摆放位置
     frm.add(pan2,BorderLayout.CENTER);
     frm.add(pan3,BorderLayout.SOUTH);
     
     frm.setVisible(true);//设置可见
     frm.addWindowListener(new WinCloser());//关闭窗口
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
	  this.setSize(380,245);//this表示这个openjframe类就是一个窗口,直接用panel就可以
	  this.add(jp2,BorderLayout.CENTER);
	  //设置此窗口永远为最上方 是window的方法
	  this.setAlwaysOnTop(true);
	  //不允许用户改变窗口的大小
	  this.setResizable(false);
	  //让窗口在屏幕的正中间显示
	  this.setLocationRelativeTo(null); 
	  this.setTitle(s);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);

	  JLabel labresult = new JLabel("123");
	  labresult.setSize(380, 150);
	  
	  jp2.add(labresult);
	  System.out.println(s);

	  
			if("登录成功".equalsIgnoreCase(s)){
				
				this.dispose();
				view3 newview = new view3();
				newview.totalview();
				System.out.println("登陆成功");

				
			}
			else {
				System.out.println("登陆失败");
				System.exit(0);
				
			}
			
		
		  
		  
	
	  
	  
	  
	 }
	}




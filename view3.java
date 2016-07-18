package javafile;


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
 
import javafile.view2.WinCloser;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class view3 {

	/**
	 * @param args
	 */
	
	static Frame frm = new Frame("成功登录");
	public static void totalview() {
		// TODO Auto-generated method stub
		
		Panel p1 = new Panel();
		p1.setLayout(null);
		p1.setSize(500,200);
		Button b1 = new Button("发邮件");
		b1.setSize(100,50);
		b1.setLocation(60, 30);
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new view3().frm.dispose();
				new view3().sendview();
			}
			
		});
		Button b2 = new Button("收邮件");
		b2.setSize(100,50);
		b2.setLocation(200, 30);
		p1.add(b1);
		p1.add(b2);
		frm.setSize(500,300);
		frm.setLocation(350, 100);
		frm.add(p1);
		frm.setVisible(true);
		frm.addWindowListener(new WinCloser());
    }
    public static class WinCloser extends WindowAdapter{
      public void windowClosing(WindowEvent e){ 
       System.exit(0);
 
      }
 
    }
    public static void sendview() {
		// TODO Auto-generated method stub
		Frame frm = new Frame("发邮件");
		Panel p1 = new Panel();
		p1.setLayout(null);
		p1.setSize(500,200);
		
		Label lb1 = new Label("收件人:");
		lb1.setLocation(50,50);
	    lb1.setSize(100,30);
		Label lb2 = new Label("主题:");
		lb2.setLocation(50,50);
	    lb2.setSize(100,30);
		Label lb3 = new Label("正文:");
		lb3.setLocation(50,50);
	    lb3.setSize(100,30);
		TextField tf1 = new TextField();
		tf1.setBounds(170, 50, 300, 50);
		TextField tf2 = new TextField();
		tf2.setBounds(170, 150, 300, 50);
		TextField tf3 = new TextField();
		tf3.setBounds(170, 300, 300, 200);
		Button b1 = new Button("确认发送");
		Button b2 = new Button("返回");
		b1.setSize(100,50);
		b1.setLocation(60, 30);

		b2.setSize(100,50);
		b2.setLocation(200, 30);
		
		p1.add(lb1);
		p1.add(lb2);
		p1.add(lb3);
		p1.add(tf1);
		p1.add(tf2);
		p1.add(tf3);
		p1.add(b1);
		p1.add(b2);
		frm.setSize(600,600);
		frm.setLocation(350, 100);
		frm.add(p1);
		frm.setVisible(true);
		frm.addWindowListener(new WinCloser());
    }
    
	}



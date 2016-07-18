package javafile;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class view1 extends JFrame{
	
	private JPanel panes;
	private JLabel lab = new JLabel();
	public view1 (){
		init();
		
	}
	/**
	 * @param args
	 */
	public void init(){
		
		setTitle("Simple Email System");
		setSize(500,300);//设置窗口大小
		setResizable(true);//设置是否可变大小
		Toolkit tk=Toolkit.getDefaultToolkit();
		setLocation((tk.getScreenSize().width-getSize().width)/2,(tk.getScreenSize().height-getSize().height)/2);//设置窗口显示位置
		
		panes = new JPanel();//窗口添加面板

		panes.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY),"主面板"));//设置面板的边框和标题
		lab.setText("主窗口");//设置标签的文本
		panes.add(lab);//标签添加到面板
		add(panes);//面板添加到窗口
		setVisible(true);//设置窗口显示
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new view1();
	}

}

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
		setSize(500,300);//���ô��ڴ�С
		setResizable(true);//�����Ƿ�ɱ��С
		Toolkit tk=Toolkit.getDefaultToolkit();
		setLocation((tk.getScreenSize().width-getSize().width)/2,(tk.getScreenSize().height-getSize().height)/2);//���ô�����ʾλ��
		
		panes = new JPanel();//����������

		panes.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY),"�����"));//�������ı߿�ͱ���
		lab.setText("������");//���ñ�ǩ���ı�
		panes.add(lab);//��ǩ��ӵ����
		add(panes);//�����ӵ�����
		setVisible(true);//���ô�����ʾ
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new view1();
	}

}

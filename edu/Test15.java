package edu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test15 {
	public static void main(String[] args) {
		 JFrame jframe = new JFrame("������Դ����ϵͳ") ; 
		   Dimension d = new Dimension(300,400);
		   Point p = new Point (250,350);
		   jframe.setSize(d);
		   jframe.setLocation(p);
		   jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   jframe.setVisible(true);
		   JButton button1 = new JButton("���");
		   JButton button2 = new JButton("�޸�");
		   JButton button3 = new JButton("��ѯ");
		   JButton button4 = new JButton("ɾ��");
		   JButton button5 = new JButton("���");
		   JButton button6 = new JButton("����");
		   FlowLayout flow = new FlowLayout(FlowLayout.LEFT,20,30);
		   JPanel panel = new JPanel(flow);
		   panel.setSize(300,400); 
		   panel.setBackground(Color.red); 
		   panel.add(button1);
		   panel.add(button2);
		   panel.add(button3);
		   panel.add(button4);
		   panel.add(button5);
		   panel.add(button6);
		   jframe.getContentPane().add(panel);
		   button1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				Add add =new Add();
				}			
			});
		   button2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Change change =new Change();
				}			
			});
		   button3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){		
					Ask ask =new Ask();
				}			
			});
		   button4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
				Delete delete =new Delete();
				}			
			});
		   button5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				Look look =new Look();
		}			
			});
		   button6.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				Db db =new Db();
		}			
			});
		   
	}
}
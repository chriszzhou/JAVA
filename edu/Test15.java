package edu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test15 {
	public static void main(String[] args) {
		 JFrame jframe = new JFrame("人力资源管理系统") ; 
		   Dimension d = new Dimension(300,400);
		   Point p = new Point (250,350);
		   jframe.setSize(d);
		   jframe.setLocation(p);
		   jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   jframe.setVisible(true);
		   JButton button1 = new JButton("添加");
		   JButton button2 = new JButton("修改");
		   JButton button3 = new JButton("查询");
		   JButton button4 = new JButton("删除");
		   JButton button5 = new JButton("浏览");
		   JButton button6 = new JButton("部门");
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
package edu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Add extends JFrame {
	private static final long serialVersionUID = -1928970409928880648L;
	JLabel jlpno = new JLabel("工      号：");
	JLabel jlname = new JLabel("姓      名：");
	JLabel jlsex = new JLabel("性      别：");
	JLabel jldepartment = new JLabel("部      门：");
	JLabel jldno = new JLabel("部 门  号：");
	JLabel jlduty = new JLabel("职      务：");
	JLabel jlrank = new JLabel( "职务等级：");
	JLabel jlexperience = new JLabel("工作经验：");
	
	JTextField jtpno = new JTextField("",20);
	JTextField jtname = new JTextField("",20);
	JTextField jtsex = new JTextField("",20);
	JTextField jtdepartment = new JTextField("",20);
	JTextField jtdno = new JTextField("",20);
	JTextField jtduty = new JTextField("",20);
	JTextField jtrank = new JTextField("",20);
	JTextField jtexperience = new JTextField("",20);

	JButton buttonadd = new JButton("添加");
	JButton buttonreturn = new JButton("返回");
	
	public Add() {
		JPanel jppno = new JPanel();
		JPanel jpname = new JPanel();
		JPanel jpsex = new JPanel();
		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();
		JPanel jpduty = new JPanel();
		JPanel jprank = new JPanel();
		JPanel jpexperience = new JPanel();
	
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
		
		jppno.add(jlpno);
		jppno.add(jtpno);
		
		jpname.add(jlname);
		jpname.add(jtname);
		
		jpsex.add(jlsex);
		jpsex.add(jtsex);
		
		jpdepartment.add(jldepartment);
		jpdepartment.add(jtdepartment);
		
		jpdno.add(jldno);
		jpdno.add(jtdno);
		
		jpduty.add(jlduty);
		jpduty.add(jtduty);
		
		jprank.add(jlrank);
		jprank.add(jtrank);
		
		jpexperience.add(jlexperience);
		jpexperience.add(jtexperience);
		
		jpforbutton.add(buttonadd);
		jpforbutton.add(buttonreturn);
		   buttonadd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Connection conn = null; 
					PreparedStatement ps=null;		
					    String xdno= jtdno.getText();
						String xdepart = jtdepartment.getText();
						String xduty = jtduty.getText();
						String xname = jtname.getText();
						String xpno = jtpno.getText();
						String xrank =jtrank.getText();
						String xsex =jtsex.getText();
					String sql = "INSERT INTO staff(pno,name,sex,dno,department,duty,rank,experience) "
							+ "values(?,?,?,?,?,?,?,?)";
					String sql3 = "INSERT INTO salary(pno,pname,sex,dno,department,duty,rank,salary) "
							+ "values(?,?,?,?,?,?,?,?)";
					try{
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						System.out.println("JBDC 加载成功!");
					}catch(Exception a){
						System.out.println("JBDC 狗带!");
						a.printStackTrace();
					}
					try{
						conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;datebaseName=source","admin.","123456");
						ps=conn.prepareStatement(sql);
						
						ps.setString(1,xpno);
						ps.setString(2,xname);
						ps.setString(3,xsex);
						ps.setString(4,xdno);
						ps.setString(5,xdepart);
						ps.setString(6,xduty);
						ps.setString(7,xrank);
						ps.setString(8,jtexperience.getText());
						ps.executeUpdate();
						int i=Integer.parseInt(xrank);
						ps=conn.prepareStatement(sql3);
						ps.setString(1,xpno);
						ps.setString(2,xname);
						ps.setString(3,xsex);
						ps.setString(4,xdno);
						ps.setString(5,xdepart);
						ps.setString(6,xduty);
						ps.setString(7,xrank);
						ps.setInt(8,i*1000+5000);
						ps.executeUpdate();
		                }catch (SQLException b){
		                	System.out.println("1 ");
					b.printStackTrace();
				}finally{
					try{
						conn.close();
						System.out.println("MySQL 关闭成功");
					}catch (SQLException c){
						System.out.println("MySQL 关闭失败 ");
						c.printStackTrace();
					}		
		   }
				}
		   });
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){		
			}			
		});
		this.setTitle("添加员工信息");
		this.setLayout(new GridLayout(9,1));	
		this.add(jppno);	
		this.add(jpname);
		this.add(jpsex);
		this.add(jpdno);
	    this.add(jpdepartment);
		this.add(jpduty);
		this.add(jprank);
		this.add(jpexperience);
		this.add(jpforbutton);
		this.setLocation(400,300);
		this.setSize(350,300);
		this.setVisible(true);
	}
}

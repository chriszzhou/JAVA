package edu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import edu.Test15;

public class Ask extends JFrame {
		private static final long serialVersionUID = -1928970409928880648L;
		JLabel jlpno = new JLabel("工      号：");
		JLabel jlname = new JLabel("姓      名：");
		JLabel jlsex = new JLabel("性      别：");
		JLabel jldepartment = new JLabel("部      门：");
		JLabel jldno = new JLabel("部 门  号：");
		JLabel jlduty = new JLabel("职      务：");
		JLabel jlrank = new JLabel( "职务等级：");
		JLabel jlsalary = new JLabel("工      资：");
		
		JTextField jtpno = new JTextField("",20);
		
		JLabel jname = new JLabel();
		JLabel jsex = new JLabel();
		JLabel jdepartment = new JLabel();
		JLabel jdno = new JLabel();
		JLabel jduty = new JLabel();
		JLabel jrank = new JLabel();
		JLabel jsalary= new JLabel();
		
		JButton buttonask = new JButton("查询");
		JButton buttonreturn = new JButton("返回");
		
		public Ask() {
			JPanel jppno = new JPanel();
			JPanel jpname = new JPanel();
			JPanel jpsex = new JPanel();
			JPanel jpdno = new JPanel();
			JPanel jpdepartment = new JPanel();
			JPanel jpduty = new JPanel();
			JPanel jprank = new JPanel();
			JPanel jpsalary = new JPanel();
			JPanel jpforbutton = new JPanel(new GridLayout(1,1));
			
			jppno.add(jlpno);
			jppno.add(jtpno);
			
			jpname.add(jlname);
			jpname.add(jname);
			
			jpsex.add(jlsex);
			jpsex.add(jsex);
			
			jpdno.add(jldepartment);
			jpdno.add(jdepartment);
			
			jpdepartment.add(jldno);
			jpdepartment.add(jdno);
			
			jpduty.add(jlduty);
			jpduty.add(jduty);
			
			jprank.add(jlrank);
			jprank.add(jrank);
			
			jpsalary.add(jlsalary);
			jpsalary.add(jsalary);
			
			
			jpforbutton.add(buttonask);
			jpforbutton.add(buttonreturn);
			buttonask.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					Connection conn = null;
					ResultSet res = null;
					Statement stat = null;
					
					String sql = "SELECT pno,pname,sex,dno,department,duty,rank,salary FROM salary;";
					try{
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						System.out.println("jdbc haha");
					}catch(Exception d){
						System.out.println("jdbc fall");
						d.printStackTrace();
					}
					try{
						conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;datebaseName=source","admin.","123456");
						stat=conn.createStatement();
						res=stat.executeQuery(sql);
						while (res.next())
						{
							String i = res.getString(1).trim();
							if (i.equals(jtpno.getText()))
							{
								jname.setText(res.getString(2));
								jsex.setText(res.getString(3));
								jdno.setText(res.getString(4));
								jdepartment.setText(res.getString(5));
								jduty.setText(res.getString(6));
								jrank.setText(res.getString(7));
								jsalary.setText(res.getString(8));
								break;
							}
						}
					}catch (SQLException e1) {
						e1.printStackTrace();
					
					
				}
					finally{
						try{
							conn.close();
						}catch(SQLException ar){
							ar.printStackTrace();
						}
				
					}}}
				
					);
			buttonreturn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){		
				}			
			});
			this.setTitle("员工工资条");
			this.setLayout(new GridLayout(9,1));
			this.add(jppno);
			this.add(jpname);
			this.add(jpsex);
			this.add(jpdno);
			this.add(jpdepartment);
			this.add(jpduty);
			this.add(jprank);
			this.add(jpsalary);
			this.add(jpforbutton);
			this.setLocation(400,300);
			this.setSize(350,300);
			this.setVisible(true);

          }
}

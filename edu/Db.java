package edu;

import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Db extends JFrame {
	private static final long serialVersionUID = -1928970409928880648L;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();
	
	JButton buttonask = new JButton("查询");
	
		JLabel jldepartment = new JLabel("部      门：");
		JLabel jldno = new JLabel("部 门  号：");
		
	Vector columnNames = null;
	Vector rowData = null;	
	
	JTextField jtdno = new JTextField("",20);
	JTextField jtdepartment = new JTextField("",20);
	
	public Db() {
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
		
	

		
		JPanel jpdno = new JPanel();
		JPanel jpdepartment = new JPanel();
		
		jpdno.add(jldno);
		jpdno.add(jtdno);
		
		jpdepartment.add(jldepartment);
		jpdepartment.add(jtdepartment);
		
		jpforbutton.add(buttonask);
		
		columnNames = new Vector();
		columnNames.add("工      号：");
		columnNames.add("姓      名：");
		columnNames.add("性      别: ");
		columnNames.add("职      务：");
		columnNames.add("职务等级：");
		rowData = new Vector();
		buttonask.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;datebaseName=source","admin.","123456");
					ps = conn.prepareStatement("SELECT pno,pname,sex,dno,duty,rank FROM salary ");
					res = ps.executeQuery();
					while (res.next())
					{
						String i = res.getString(4).trim();
						System.out.println(jtdno.getText()+res.getString(4).trim()+i.equals(jtdno.getText()));
						if (i.equals(jtdno.getText()))
						{
						Vector hang = new Vector();
						hang.add(res.getString(1));
						hang.add(res.getString(2));
						hang.add(res.getString(3));
						hang.add(res.getString(5));
						hang.add(res.getString(6));
						rowData.add(hang);
						System.out.println(hang.add(res.getString(1))+res.getString(1));
						}
					}
					System.out.println("load  ok!");
				}catch (Exception q){
					q.printStackTrace();
					System.out.println("go die");
				}
				finally{
					try{
						res.close();
						ps.close();
						conn.close();
					}catch(SQLException ar){
						ar.printStackTrace();
					}
			
				}

				}}
				);
		jtable = new JTable(rowData,columnNames);
		jscrollpane = new JScrollPane(jtable);
		
	    this.add(jscrollpane);
		this.setTitle("部门信息表");
		this.setLayout(new GridLayout(4,1));
		this.add(jpdno);
		this.add(jpdepartment);
		this.add(jpforbutton);
		this.setLocation(300,300);
		this.setSize(500,300);

		this.setVisible(true);
		this.setResizable(false);

      }
}
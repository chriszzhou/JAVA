package edu;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Look extends JFrame {
	private static final long serialVersionUID = -1928970409928880648L;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();
	
	Vector columnNames = null;
	Vector rowData = null;
	
	public Look() {
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
 
		columnNames = new Vector();
		columnNames.add("工      号：");
		columnNames.add("姓      名：");
		columnNames.add("性      别: ");
		columnNames.add("部 门 号：");
		columnNames.add("部      门  ：");
		columnNames.add("职      务：");
		columnNames.add("职务等级：");
		columnNames.add("工      资：");
		rowData = new Vector();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;datebaseName=source","admin.","123456");
			ps = conn.prepareStatement("SELECT * FROM salary");
			res = ps.executeQuery();
			while (res.next())
			{
				Vector hang = new Vector();
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				hang.add(res.getString(3));
				hang.add(res.getString(4));
				hang.add(res.getString(5));
				hang.add(res.getString(6));
				hang.add(res.getString(7));
				hang.add(res.getString(8));
				rowData.add(hang);
				
			}
			System.out.println("load  ok!");
		}catch (Exception q){
			q.printStackTrace();
			System.out.println("go die");
		}finally{
			try{
				res.close();
				ps.close();
				conn.close();
				System.out.println("close ok");
			}catch (SQLException o){
				o.printStackTrace();
				System.out.println("go die 2");
			}
		}
		jtable = new JTable(rowData,columnNames);
		jscrollpane = new JScrollPane(jtable);
		
		this.add(jscrollpane);
		this.setTitle("员工信息表");
		this.setLayout(new GridLayout(2,5));
		this.add(jpforbutton);
		this.setLocation(300,300);
		this.setSize(500,300);
		this.setVisible(true);
		this.setResizable(false);
	}
}

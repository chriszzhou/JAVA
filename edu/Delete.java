package edu;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
   
public class Delete extends JFrame {
	private static final long serialVersionUID = -1928970409928880648L;
			   
	JLabel jlpno = new JLabel("工      号：");
	
	JTextField jtpno = new JTextField("",20);
	
	JButton buttondelete = new JButton("删除");
	JButton buttonreturn = new JButton("返回");
	
	
	public Delete() {
		JPanel jpnumber = new JPanel();
		JPanel jpforbutton = new JPanel(new GridLayout(1,1));
		
		jpnumber.add(jlpno);
		jpnumber.add(jtpno);
		
		jpforbutton.add(buttondelete);
		jpforbutton.add(buttonreturn);
		
		buttondelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String pno = jtpno.getText();
				
				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;
				String sql = "DELETE FROM salary WHERE pno='"+pno+"'";
				String sql2 = "DELETE FROM staff WHERE pno='"+pno+"'";
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				}catch(Exception a){
					a.printStackTrace();
				}
				try{
					conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;datebaseName=source","admin.","123456");
					stat = conn.createStatement();
					stat.executeUpdate(sql);
					stat.executeUpdate(sql2);
				}catch(SQLException h){
					h.printStackTrace();
					
				}finally{
					try{
						conn.close();
						System.out.println("close success!");
					}catch(SQLException j){
						System.out.println("close go die!");
					    j.printStackTrace();
					}
					
				}
				
			}
			
			
		});
		
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
			}			
		});
		this.setTitle("删除学生信息");
		this.setLayout(new GridLayout(9,1));
		this.add(jpnumber);
		this.add(jpforbutton);
		this.setLocation(400,300);
		this.setSize(350,300);
		this.setVisible(true);
		
		
	}  
}
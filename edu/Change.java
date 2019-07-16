package edu;
 
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
 
public class Change extends JFrame {
	private static final long serialVersionUID = -1928970409928880648L;
	
	JLabel jlpno = new JLabel("��      �ţ�");
	JLabel jlname = new JLabel("��      ����");
	JLabel jlsex = new JLabel("��      ��");
	JLabel jldepartment = new JLabel("��      �ţ�");
	JLabel jldno = new JLabel("�� ��  �ţ�");
	JLabel jlduty = new JLabel("ְ      ��");
	JLabel jlrank = new JLabel( "ְ��ȼ���");
	JLabel jlexperience = new JLabel("�������飺");
	
	JTextField jtpno = new JTextField("",20);
	JTextField jtname = new JTextField("",20);
	JTextField jtsex = new JTextField("",20);
	JTextField jtdepartment = new JTextField("",20);
	JTextField jtdno = new JTextField("",20);
	JTextField jtduty = new JTextField("",20);
	JTextField jtrank = new JTextField("",20);
	JTextField jtexperience = new JTextField("",20);
	
	JButton buttonchange = new JButton("�޸�");
	JButton buttonreturn = new JButton("����");
	
	
	public Change() {
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
		
		jpforbutton.add(buttonchange);
		jpforbutton.add(buttonreturn);
		
		buttonchange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			    String xdno= jtdno.getText();
				String xdepart = jtdepartment.getText();
				String xduty = jtduty.getText();
				String xname = jtname.getText();
				String xpno = jtpno.getText();
				String xrank =jtrank.getText();
				String xsex =jtsex.getText();
				String xexperience =jtexperience.getText();
				int num = Integer.parseInt(xrank)*1000+5000;
				
				String xsalary=Integer.toString(num);
				
				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;
				
				String sql = "SELECT pno,name,sex,dno,department,duty,rank,experience FROM staff;";
				try{
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					
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
							String sql2="UPDATE staff SET name='"+xname+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql3="UPDATE staff SET sex='"+xsex+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql4="UPDATE staff SET dno='"+xdno+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql5="UPDATE staff SET department='"+xdepart+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql6="UPDATE staff SET duty='"+xduty+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql7="UPDATE staff SET rank='"+xrank+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql8="UPDATE staff SET experience='"+xexperience+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql9="UPDATE salary SET pname='"+xname+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql10="UPDATE salary SET sex='"+xsex+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql11="UPDATE salary SET dno='"+xdno+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql12="UPDATE salary SET department='"+xdepart+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql13="UPDATE salary SET duty='"+xduty+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql14="UPDATE salary SET rank='"+xrank+"'  WHERE pno='"+jtpno.getText()+"'";
							String sql15="UPDATE salary SET salary='"+xsalary+"'  WHERE pno='"+jtpno.getText()+"'";

								stat=conn.createStatement();
								stat.executeUpdate(sql2);
								stat.executeUpdate(sql3);
								stat.executeUpdate(sql4);
								stat.executeUpdate(sql5);
								stat.executeUpdate(sql6);
								stat.executeUpdate(sql7);
								stat.executeUpdate(sql8);
								stat.executeUpdate(sql9);
								stat.executeUpdate(sql10);
								stat.executeUpdate(sql11);
								stat.executeUpdate(sql12);
								stat.executeUpdate(sql13);
								stat.executeUpdate(sql14);
								stat.executeUpdate(sql15);
						try{
								stat.close();
								conn.close();
							}catch(SQLException ar){
								ar.printStackTrace();
						}
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
				}	
			}
		});
		buttonreturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){		
			}			
		});
		
		this.setTitle("�޸�Ա����Ϣ");
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
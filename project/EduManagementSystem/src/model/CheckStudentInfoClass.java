package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.sun.java_cup.internal.runtime.Scanner;

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {

	
	static int ID=13012;//�����ѧ��ID
	static ArrayList<String> studentInfo = new ArrayList<String>();
	@Override
	public ArrayList<String> checkStudentInfo() {
		// TODO �Զ����ɵķ������
		//��Ҫ�鿴�����������䣬�Ա���ѧ��ݡ�������ò������������
		System.out.println("�鿴ѧ��������Ϣ");
//		Vector<String> info=new Vector<String>();
//		info.add("����");
//		info.add("18");
//		info.add("2019");
//		info.add("��Ա");
//		info.add("����");
//		return info;
//		public static void main(String []args) {
	
		return studentInfo;
		
	}

	public static void main(String []args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("���سɹ�");
	        } catch (Exception ex) {
	        	System.out.println("����ʧ��");
	            // handle the error
	        }
		
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/��С����Ŀ","����ͥ","1234");
		       //�˴�����ĿС��Ϊmysql��ǰ���������ݿ⣬����ͥΪ�û��������Ϊ���룺1234

		   System.out.println("���ӳɹ�");

		   //һ�²���������ݿ������ݣ���ǰ�����ݿ��ڽ���user�����num��name
		   
		  // ps = conn.prepareStatement("select ѧ��ID,ѧ������ from ��С����Ŀ.ѧ����;");
		   ps = conn.prepareStatement(""
		   		+ "select ѧ����.ѧ��ID,ѧ����.ѧ������,ѧ����.��������, ѧ����.�Ա�,ѧ����.��ѧ���,ѧ����.������ò, ��ʦ��.��ʦ��\n" + 
		   		"from ��С����Ŀ.ѧ����,��С����Ŀ.`������-ѧ����`,��С����Ŀ.`ѧ��-�༶-�����α�`,��С����Ŀ.��ʦ��\n" + 
		   		"where ѧ����.ѧ��ID=`������-ѧ����`.ѧ��ID and `ѧ��-�༶-�����α�`.`ѧ��-�༶-������ID`=`������-ѧ����`.`ѧ��-�༶-������ID` \n" + 
		   		"and ѧ����.ѧ��ID="+ID+" and `ѧ��-�༶-�����α�`.��ʦID=��ʦ��.��ʦID;");
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   
			   int num = rs.getInt("ѧ��ID");
			   String name = rs.getString("ѧ������");
			   String birthDay  = rs.getString("��������").substring(0, 4);
			   String gender = rs.getString("�Ա�");
			   int enrollmentYear = rs.getInt("��ѧ���");
			   String politicsStatus = rs.getString("������ò");
			   String teacherName = rs.getString("��ʦ��");
			   int age = 2021- Integer.parseInt(birthDay);
			   System.out.print(num+"\t"+name+"\t"+age+"\t"+gender+"\t"+enrollmentYear+"\t"+politicsStatus+"\t"+teacherName);
			   System.out.println("");
			   
			
			   studentInfo.add(name);
			   studentInfo.add(Integer.toString(num));
			   studentInfo.add(Integer.toString(age));
			   studentInfo.add(gender);
			   studentInfo.add(Integer.toString(enrollmentYear));
			   studentInfo.add(politicsStatus);
			   studentInfo.add(teacherName);
			   
			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("����ʧ��");
		}
		//System.out.println(studentInfo);����Ƿ���ȷ����
	}
	
}




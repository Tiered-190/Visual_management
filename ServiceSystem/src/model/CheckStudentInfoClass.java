package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.sun.java_cup.internal.runtime.Scanner;

public class CheckStudentInfoClass implements CheckStudentInfoBehavior {//�鿴ѧ������

	
//	//static int ID=13012;//�����ѧ��ID
//	static String ID="13012";
//	static 
//	
//	 public void setStudentInfo(String ID) {
//			this.ID=ID;
//		}
//	 
	@Override
	public ArrayList<String> checkStudentInfo(String ID) {//����ѧ����Ϣ��Ԫ��
		ArrayList<String> studentInfo = new ArrayList<String>();//���ȫ�ֱ����������洢����ѧ����Ϣ��Ԫ��
		//��Ҫ�鿴�����������䣬�Ա���ѧ��ݡ�������ò������������
		//System.out.println("�鿴ѧ��������Ϣ");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {// ����Ƿ����������ݿ�
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("���سɹ�");
	        } catch (Exception ex) {
	        	System.out.println("����ʧ��");
	            // �������
	        }
		
		try {
		    conn =DriverManager.getConnection("jdbc:mysql://10.22.27.7:3306/��С����Ŀ","����ͥ","1234");
		       //�˴�����ĿС��Ϊmysql��ǰ���������ݿ⣬����ͥΪ�û��������Ϊ���룺1234
		       System.out.println("���ӳɹ�");
		      //һ�²���������ݿ������ݣ���ǰ�����ݿ��ڽ���user�����num��name
		      // ps = conn.prepareStatement("select ѧ��ID,ѧ������ from ��С����Ŀ.ѧ����;");
		   ps = conn.prepareStatement(""
		   		+ "select distinct ѧ����.ѧ��ID,ѧ����.ѧ������,ѧ����.��������, ѧ����.�Ա�,ѧ����.��ѧ���,ѧ����.������ò,(��ʦ��.��ʦ��)as ������\r\n" + 
		   		"from ��С����Ŀ.ѧ����,��С����Ŀ.ѧ���༶��,��С����Ŀ.��ʦ��,��С����Ŀ.`ѧ��-��ʦ-ѧ��-�༶��`\r\n" + 
		   		"where ѧ����.ѧ��ID=ѧ���༶��.ѧ��ID and ѧ����.ѧ��ID="+ID+" and ѧ���༶��.������ID=��ʦ��.��ʦID" );
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   //���±�����Ӧ�����������䣬�Ա���ѧ��ݡ�������ò������������
			   int num = rs.getInt("ѧ��ID");
			   String name = rs.getString("ѧ������");
			   String birthDay  = rs.getString("��������").substring(0, 4);
			   String gender = rs.getString("�Ա�");
			   int enrollmentYear = rs.getInt("��ѧ���");
			   String politicsStatus = rs.getString("������ò");
			   String teacherName = rs.getString("������");
			   int age = 2021- Integer.parseInt(birthDay);
			   System.out.print(num+"\t"+name+"\t"+age+"\t"+gender+"\t"+enrollmentYear+"\t"+politicsStatus+"\t"+teacherName);
			   System.out.println("");
			   
			   //�����������䣬�Ա���ѧ��ݡ�������ò����������������studentInfo��list��
			   studentInfo.add(name);
			   studentInfo.add(Integer.toString(num));
			   studentInfo.add(Integer.toString(age));
			   studentInfo.add(gender);
			   studentInfo.add(Integer.toString(enrollmentYear));
			   studentInfo.add(politicsStatus);
			   studentInfo.add(teacherName);
			   //System.out.println(studentInfo);
		   }

		} catch (SQLException ex) { // �������
		   
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("����ʧ��");
		}
		//System.out.println(studentInfo);//����Ƿ���ȷ����
		
		return studentInfo;
	}
	


	
		
		


}





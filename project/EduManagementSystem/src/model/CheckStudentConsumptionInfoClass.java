package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentConsumptionInfoClass implements CheckStudentConsumptionInfoBehavior {

	static int ID=13012;//�����ѧ��ID
	static ArrayList<ArrayList<String>> studentInfo = new ArrayList<ArrayList<String>>();
	@Override
	public ArrayList<ArrayList<String>> checkStudentConsumptionInfo() {
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
			   		+ "select ѧ����.ѧ������,ѧ����.ѧ��ID,����ʱ��,���ѽ��\n" + 
			   		"from ��С����Ŀ.ѧ����,��С����Ŀ.���ѱ�\n" + 
			   		"where ѧ����.ѧ��ID=���ѱ�.ѧ��ID \n" + 
			   		"and ѧ����.ѧ��ID="+ID);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   
			   int num = rs.getInt("ѧ��ID");
			   String name = rs.getString("ѧ������");
			   String consumptionTime = rs.getString("����ʱ��");
			   double consumptionAmount = rs.getInt("���ѽ��");
			   System.out.print(num+"\t"+name+"\t"+consumptionTime+"\t"+consumptionAmount);
			   System.out.println("");
			   
			   ArrayList<String> people =new ArrayList<String>();
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(consumptionTime);
			   people.add(String.valueOf(consumptionAmount));
			   studentInfo.add(people);
			   
			   /*ArrayList<String> name1=new ArrayList<String>();
			   ArrayList<String> consumptionTime1=new ArrayList<String>();
			   ArrayList<String> consumptionAmount1=new ArrayList<String>();
			   ArrayList<String> num1=new ArrayList<String>();*/
			   
			   /*name1.add(name);
			   num1.add(Integer.toString(num));
			   consumptionTime1.add(consumptionTime);
			   consumptionAmount1.add(String.valueOf(consumptionAmount));*/
			   
			   /*studentInfo.add(name1);
			   studentInfo.add(num1);
			   studentInfo.add(consumptionTime1);
			   studentInfo.add(consumptionAmount1);*/
			   
			   
			   
			   
		   }

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("����ʧ��");
		}
		System.out.println(studentInfo);//����Ƿ���ȷ����
	}
	
}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckStudentConsumptionInfoClass implements CheckStudentConsumptionInfoBehavior {//��ѯѧ�����Ѽ�¼

//	static String ID="15888";//�����ѧ��ID
//	static int n=5;
	//static ArrayList<Double>studentInfo= new ArrayList<Double>();
	//static ArrayList<Double>studentInfo3= new ArrayList<Double>();
	//static ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//���ȫ�ֱ����������洢����ѧ�����Ѽ�¼
	//static ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//���ȫ�ֱ����������洢����ѧ���������Ѽ�¼

	@Override
	public  ArrayList<Double> checkStudentConsumptionInfo(String ID,int n) {//���ص�ѧ�����Ѽ�¼
		 ArrayList<Double>studentInfo= new ArrayList<Double>();
		 ArrayList<Double>studentInfo3= new ArrayList<Double>();
		 ArrayList<ArrayList<String>> studentInfo2 = new ArrayList<ArrayList<String>>();//���ȫ�ֱ����������洢����ѧ�����Ѽ�¼
		 ArrayList<ArrayList<String>> studentInfo1 = new ArrayList<ArrayList<String>>();//���ȫ�ֱ����������洢����ѧ���������Ѽ�¼

		//System.out.println("�鿴ѧ��������Ϣ");
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
		       DriverManager.getConnection("jdbc:mysql://172.16.107.100:3306/��С����Ŀ","����ͥ","1234");
		       //�˴�����ĿС��Ϊmysql��ǰ���������ݿ⣬����ͥΪ�û��������Ϊ���룺1234

		   System.out.println("���ӳɹ�");

		   //һ�²���������ݿ������ݣ���ǰ�����ݿ��ڽ���user�����num��name
		   
		  // ps = conn.prepareStatement("select ѧ��ID,ѧ������ from ��С����Ŀ.ѧ����;");
		   ps = conn.prepareStatement(""
			   		+ "select ѧ����.ѧ������,ѧ����.ѧ��ID,����ʱ��,���ѽ��\r\n" + 
			   		"from ��С����Ŀ.ѧ����,��С����Ŀ.���ѱ�\r\n" + 
			   		"where ѧ����.ѧ��ID=���ѱ�.ѧ��ID\r\n" + 
			   		"      and ѧ����.ѧ��ID=" +ID);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   ArrayList<String> people =new ArrayList<String>();//�洢һ��ѧ�����Ѽ�¼��Ԫ��
			   //ѧ��ID��ѧ������������ʱ�䣬���ѽ��
			   int num = rs.getInt("ѧ��ID");
			   String name = rs.getString("ѧ������");
			   String consumptionTimeYear = rs.getString("����ʱ��").substring(0, 4);
			   String consumptionTimeMonth = rs.getString("����ʱ��").substring(5,6);
			   double consumptionAmount = rs.getInt("���ѽ��");
			   System.out.print(num+"\t"+name+"\t"+consumptionTimeYear+"\t"+consumptionTimeMonth+"\t"+consumptionAmount);
			   System.out.println("");
			   
			  
			   
			 //��ѧ��ID��ѧ������������ʱ�䣬���ѽ�����people
			   people.add(name);
			   people.add(Integer.toString(num));
			   people.add(consumptionTimeYear);
			   people.add(consumptionTimeMonth);
			   people.add(String.valueOf(consumptionAmount));
			   //��people����studentInfo
			   studentInfo2.add(people);
			   
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
		String FLAG=studentInfo2.get(0).get(3);
		double sum=0.0;
		for(int i=0;i<studentInfo2.size();i++) {
			if (studentInfo2.get(i).get(3).equals(FLAG)) {
				
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				if(i==studentInfo2.size()-1) studentInfo3.add(sum);
				}
			
			else 
			{
				FLAG=studentInfo2.get(i).get(3);
				studentInfo3.add(sum);
				sum=0;
				sum += Double.parseDouble(studentInfo2.get(i).get(4));
				
			
		}
		
		
	}
		if(studentInfo3.size()<n) 
			n=studentInfo3.size();
		
		for (int c=0;c<n;c++) {
			studentInfo.add(studentInfo3.get(c));
			
		}
		//System.out.println(studentInfo3);//����Ƿ���ȷ����
	
		return studentInfo;
		
	}


}


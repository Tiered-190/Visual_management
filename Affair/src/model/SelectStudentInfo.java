package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentInfo implements DatabaseOperation{
	/**
	 * ѧ��ID���������Ա����塢��ѧ��ݡ��������ڡ���ͥסַ����ͥ���͡�������ò����ѧ����������š��Ƿ���ѧ
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectStudentInfo(ArrayList<String> data) {
		
		ArrayList<ArrayList<String>> selectStudentInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���� WHERE ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuInt = null;//ѧ��ID
			String name = null;//����
			String gender = null;//�Ա�
			String people = null;//����
			Integer enrollmentYear = null;//��ѧ���
			String birthday = null;//��������
			String home = null;//��ͥסַ
			String homeType = null;//��ͥ����
			String politics = null;//������ò
			Integer entranceRanking = null;//��ѧ����
			Integer dormitoryNo = null;//�����
			Integer dropOut = null;//�Ƿ���ѧ
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
	        	stuInt = rs.getInt("ѧ��ID");//��ȡѧ��ID
	        	name = rs.getString("����");//��ȡ����
	        	gender = rs.getString("�Ա�");//��ȡ�Ա�
	        	people = rs.getString("����");//��ȡ����
	        	enrollmentYear = rs.getInt("��ѧ���");//��ȡ��ѧ���
	        	birthday = rs.getString("��������");//��ȡ��������
	        	home = rs.getString("��ͥסַ");//��ȡ��ͥסַ
	        	homeType = rs.getString("��ͥ����");//��ȡ��ͥ����
	        	politics = rs.getString("������ò");//��ȡ������ò
	        	entranceRanking = rs.getInt("��ѧ����");//��ѧ����
	        	dormitoryNo = rs.getInt("�����");//�����
	        	dropOut = rs.getInt("�Ƿ���ѧ");//�Ƿ���ѧ
				
				
        		
				//���������ͽ���ת��
				String stu = Integer.toString(stuInt);
				String enrollmentYearstr = Integer.toString(enrollmentYear);
				String entranceRankingstr = Integer.toString(entranceRanking);
				String dormitoryNostr = Integer.toString(dormitoryNo);
				String dropOutstr = Integer.toString(dropOut);
				
				//д������
				onerow.add(stu);
        		onerow.add(name);
        		onerow.add(gender);
        		onerow.add(people);
        		onerow.add(enrollmentYearstr);
        		onerow.add(birthday);
        		onerow.add(home);
        		onerow.add(homeType);
        		onerow.add(politics);
        		onerow.add(entranceRankingstr);
        		onerow.add(dormitoryNostr);
        		onerow.add(dropOutstr);
				
        		selectStudentInfoList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectStudentInfoList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		
		switch(choose) {
		case 1:
			result = selectStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}
}


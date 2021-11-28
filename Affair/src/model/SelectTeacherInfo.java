package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTeacherInfo implements DatabaseOperation{
	/**
	 * ��ʦID���������Ա����塢������ò��ѧ�����������ڡ���ϵ�绰������
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectTeacherInfo(ArrayList<String> data) {
		
		
		ArrayList<ArrayList<String>> selectTeacherInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ��ʦ��  WHERE ��ʦID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer teacherInt = null;//��ʦID
			String name = null;//����
			String gender = null;//�Ա�
			String people = null;//����
			String degree = null;//ѧ��
			String birthday = null;//��������
			String politics = null;//������ò
			Integer phone = null;//��ϵ�绰
			String email = null;//����
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
	        	teacherInt = rs.getInt("��ʦID");//��ȡ��ʦID
	        	name = rs.getString("����");//��ȡ����
	        	gender = rs.getString("�Ա�");//��ȡ�Ա�
	        	people = rs.getString("����");//��ȡ����
	        	degree = rs.getString("ѧ��");//��ȡѧ��
	        	birthday = rs.getString("��������");//��ȡ��������
	        	politics = rs.getString("������ò");//��ȡ������ò
	        	phone = rs.getInt("��ϵ�绰");//��ϵ�绰
	        	email = rs.getString("����");//����
				
				
        		
				//���������ͽ���ת��
				String teacher = Integer.toString(teacherInt);
				String phonestr = Integer.toString(phone);
				
				
				//д������
				onerow.add(teacher);
        		onerow.add(name);
        		onerow.add(gender);
        		onerow.add(people);
        		onerow.add(degree);
        		onerow.add(birthday);
        		onerow.add(politics);
        		onerow.add(phonestr);
        		onerow.add(email);

        		selectTeacherInfoList.add(onerow);
        		
        		
        	}
        	rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectTeacherInfoList;
	}
	
	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		switch(choose) {
		case 1:
			result = selectTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}
}



package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTermTeacherSubjectClass implements DatabaseOperation{
	/**
	 * ѧ��ID����ʦID��ѧ��ID���༶ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectTeacherTeachingInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ����ʦ ���̵����а༶��ѧ�ơ�ѧ��
		 * */
		
		ArrayList<ArrayList<String>> selectTeacherTeachingInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ��-��ʦ-ѧ��-�༶��  WHERE ��ʦID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer teacherInt = null;
			Integer semesterInt = null;
			Integer subjectInt = null;
			Integer classInt = null;
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
	        	teacherInt = rs.getInt("��ʦID");//��ȡ��ʦID
	        	semesterInt = rs.getInt("ѧ��ID");//��ȡѧ��ID
	        	subjectInt = rs.getInt("ѧ��ID");//��ȡѧ��ID
	        	classInt = rs.getInt("�༶ID");//��ȡ�༶ID
				
				
				
        		
				//���������ͽ���ת��
				String teacher = Integer.toString(teacherInt);
				String semester = Integer.toString(semesterInt);
				String subject = Integer.toString(subjectInt);
				String classstr = Integer.toString(classInt);
				
				//д������
				onerow.add(teacher);
        		onerow.add(semester);
        		onerow.add(subject);
        		onerow.add(classstr);
				
        		selectTeacherTeachingInfoList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectTeacherTeachingInfoList;
	}

	public ArrayList<ArrayList<String>> selectTeacherSingleSemesterTeachingInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ����ʦ��ĳ��ѧ�� ���̵İ༶��ѧ�ơ�ѧ��
		 * */
		
		ArrayList<ArrayList<String>> selectTeacherSingleSemesterTeachingInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ��-��ʦ-ѧ��-�༶��  WHERE ��ʦID = ?, ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer teacherInt = null;
			Integer semesterInt = null;
			Integer subjectInt = null;
			Integer classInt = null;
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
	        	teacherInt = rs.getInt("��ʦID");//��ȡ��ʦID
	        	semesterInt = rs.getInt("ѧ��ID");//��ȡѧ��ID
	        	subjectInt = rs.getInt("ѧ��ID");//��ȡѧ��ID
	        	classInt = rs.getInt("�༶ID");//��ȡ�༶ID
				
				
				
        		
				//���������ͽ���ת��
				String teacher = Integer.toString(teacherInt);
				String semester = Integer.toString(semesterInt);
				String subject = Integer.toString(subjectInt);
				String classstr = Integer.toString(classInt);
				
				//д������
				onerow.add(teacher);
        		onerow.add(semester);
        		onerow.add(subject);
        		onerow.add(classstr);
				
        		selectTeacherSingleSemesterTeachingInfoList.add(onerow);
        		
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectTeacherSingleSemesterTeachingInfoList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		
		switch(choose) {
		case 1:
			result = selectTeacherTeachingInfo(data); // ��ѯĳ����ʦ ���̵����а༶��ѧ�ơ�ѧ��(������)
			break;
		case 2:
			result = selectTeacherSingleSemesterTeachingInfo(data); //��ѯĳ����ʦ��ĳ��ѧ�� ���̵İ༶��ѧ�ơ�ѧ��
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}

}

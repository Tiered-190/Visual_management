package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentGrade implements DatabaseOperation{
	/**
	 * ѧ��ID�����Կ�ʼʱ�䡢��������ID��ѧ��ID��ѧ��ID�����Գɼ���Z-Score��T-Score���ȵ�
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectSingleSubjectGrade(ArrayList<String> data) {
		/**
		 * ��ѯ�����ɼ���¼ ĳһѧ��
		 * */
		
		ArrayList<ArrayList<String>> selectSingleSubjectGradeList = new ArrayList<ArrayList<String>>();
		
		database.connect();
		
		try {
			
			String sql = "SELECT * FROM ѧ���ɼ���  WHERE ѧ��ID = ?, ��������ID = ?��ѧ��ID = ?, ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuint = null;
			Integer examtypeint = null;
			Integer subjectint = null;
			Integer semesterint = null;
			Integer gradeint = null;
			String ZScore = null;
			String TScore = null;
			String ranking = null;
			String timestart = null;
			
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
				stuint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				examtypeint = rs.getInt("��������ID");//��ȡ��������ID
				subjectint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				semesterint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				gradeint = rs.getInt("���Գɼ�");//��ȡ���Գɼ�
				ZScore = rs.getString("Z-Score");//��ȡZ-Score
				TScore = rs.getString("T-Score");//��ȡT-Score
				ranking = rs.getString("�ȵ�");//��ȡ�ȵ�
				timestart = rs.getString("���Կ�ʼʱ��");//��ȡ���Կ�ʼʱ��
				
				
        		
				//���������ͽ���ת��
				String stu = Integer.toString(stuint);
				String examtype = Integer.toString(examtypeint);
				String subject = Integer.toString(subjectint);
				String semester = Integer.toString(semesterint);
				String grade = Integer.toString(gradeint);
				
				//д������
				onerow.add(stu);
        		onerow.add(examtype);
        		onerow.add(subject);
        		onerow.add(semester);
        		onerow.add(grade);
        		onerow.add(ZScore);
        		onerow.add(TScore);
        		onerow.add(ranking);
        		onerow.add(timestart);
				
        		selectSingleSubjectGradeList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectSingleSubjectGradeList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleExamGrade(ArrayList<String> data) {
		/**
		 * ��ѯ���γɼ���¼ ĳһ�ο���ȫ��ѧ��
		 * */
		
		ArrayList<ArrayList<String>> selectSingleExamGradeList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			
			String sql = "SELECT * FROM ѧ���ɼ���  WHERE ѧ��ID = ?, ��������ID = ?��ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuint = null;
			Integer examtypeint = null;
			Integer subjectint = null;
			Integer semesterint = null;
			Integer gradeint = null;
			String ZScore = null;
			String TScore = null;
			String ranking = null;
			String timestart = null;
			
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
				stuint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				examtypeint = rs.getInt("��������ID");//��ȡ��������ID
				subjectint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				semesterint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				gradeint = rs.getInt("���Գɼ�");//��ȡ���Գɼ�
				ZScore = rs.getString("Z-Score");//��ȡZ-Score
				TScore = rs.getString("T-Score");//��ȡT-Score
				ranking = rs.getString("�ȵ�");//��ȡ�ȵ�
				timestart = rs.getString("���Կ�ʼʱ��");//��ȡ���Կ�ʼʱ��
				
				
        		
				//���������ͽ���ת��
				String stu = Integer.toString(stuint);
				String examtype = Integer.toString(examtypeint);
				String subject = Integer.toString(subjectint);
				String semester = Integer.toString(semesterint);
				String grade = Integer.toString(gradeint);
				
				//д������
				onerow.add(stu);
        		onerow.add(examtype);
        		onerow.add(subject);
        		onerow.add(semester);
        		onerow.add(grade);
        		onerow.add(ZScore);
        		onerow.add(TScore);
        		onerow.add(ranking);
        		onerow.add(timestart);
				
        		selectSingleExamGradeList.add(onerow);
        		
        		
        	}
        	rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectSingleExamGradeList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleStudentGrade(ArrayList<String> data) {
		/**
		 * ��ѯĳ��ѧ��ȫ���ɼ���¼
		 * */
		
		ArrayList<ArrayList<String>> selectSingleStudentGradeList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���ɼ���  WHERE ѧ��ID = ?";			
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuint = null;
			Integer examtypeint = null;
			Integer subjectint = null;
			Integer semesterint = null;
			Integer gradeint = null;
			String ZScore = null;
			String TScore = null;
			String ranking = null;
			String timestart = null;
			
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
				stuint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				examtypeint = rs.getInt("��������ID");//��ȡ��������ID
				subjectint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				semesterint = rs.getInt("ѧ��ID");//��ȡѧ��ID
				gradeint = rs.getInt("���Գɼ�");//��ȡ���Գɼ�
				ZScore = rs.getString("Z-Score");//��ȡZ-Score
				TScore = rs.getString("T-Score");//��ȡT-Score
				ranking = rs.getString("�ȵ�");//��ȡ�ȵ�
				timestart = rs.getString("���Կ�ʼʱ��");//��ȡ���Կ�ʼʱ��
				
				
        		
				//���������ͽ���ת��
				String stu = Integer.toString(stuint);
				String examtype = Integer.toString(examtypeint);
				String subject = Integer.toString(subjectint);
				String semester = Integer.toString(semesterint);
				String grade = Integer.toString(gradeint);
				
				//д������
				onerow.add(stu);
        		onerow.add(examtype);
        		onerow.add(subject);
        		onerow.add(semester);
        		onerow.add(grade);
        		onerow.add(ZScore);
        		onerow.add(TScore);
        		onerow.add(ranking);
        		onerow.add(timestart);
				
        		selectSingleStudentGradeList.add(onerow);
        		
        		
        	}
        	rs.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return selectSingleStudentGradeList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		switch(choose) {
		case 1:
			result = selectSingleSubjectGrade(data); // ��ѯ�����ɼ���¼ ĳһѧ��
			break;
		case 2:
			result = selectSingleExamGrade(data); // ��ѯ���γɼ���¼ ĳһ�ο���ȫ��ѧ��
			break;
		case 3:
			result = selectSingleStudentGrade(data); //��ѯĳ��ѧ��ȫ���ɼ���¼
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}

}

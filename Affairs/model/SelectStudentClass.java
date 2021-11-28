package model;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentClass implements DatabaseOperation{
	/**
	 * ѧ��ID��ѧ��ID���༶ID��������ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public ArrayList<ArrayList<String>> selectSingleStudentClassInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ��ѧ�������а༶��Ϣ
		 * */
		ArrayList<ArrayList<String>> selectSingleStudentClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
        		
        		stuIdint = rs.getInt("ѧ��ID");
        		semesterIdint = rs.getInt("ѧ��ID");
        		classIdint = rs.getInt("�༶ID");
        		teacherIdint = rs.getInt("������ID");
 
        		//���������ͽ���ת��
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(semesterIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//д������
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleStudentClassInfoList.add(onerow);
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return selectSingleStudentClassInfoList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleStudentSingleSemesterClassInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ��ѧ����ĳ��ѧ�ڵİ༶��Ϣ
		 * */
		
		
		
		ArrayList<ArrayList<String>> selectSingleStudentSingleSemesterClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ѧ��ID = ?, ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
        		
        		stuIdint = rs.getInt("ѧ��ID");
        		semesterIdint = rs.getInt("ѧ��ID");
        		classIdint = rs.getInt("�༶ID");
        		teacherIdint = rs.getInt("������ID");
 
        		//���������ͽ���ת��
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//д������
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleStudentSingleSemesterClassInfoList.add(onerow);
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectSingleStudentSingleSemesterClassInfoList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleTeacherClassInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ�������ι���������а༶��Ϣ
		 * */
		
		ArrayList<ArrayList<String>>  selectSingleTeacherClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ������ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
        		
        		stuIdint = rs.getInt("ѧ��ID");
        		semesterIdint = rs.getInt("ѧ��ID");
        		classIdint = rs.getInt("�༶ID");
        		teacherIdint = rs.getInt("������ID");
 
        		//���������ͽ���ת��
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//д������
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		 selectSingleTeacherClassInfoList.add(onerow);
        		
        	}
        	rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  selectSingleTeacherClassInfoList;
	}
	
	public ArrayList<ArrayList<String>>  selectSingleTeacherSingleSemesterClassInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ����������ĳ��ѧ��������İ༶��Ϣ
		 * */
		ArrayList<ArrayList<String>> selectSingleTeacherSingleSemesterClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ������ID = ?, ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
        		
        		stuIdint = rs.getInt("ѧ��ID");
        		semesterIdint = rs.getInt("ѧ��ID");
        		classIdint = rs.getInt("�༶ID");
        		teacherIdint = rs.getInt("������ID");
 
        		//���������ͽ���ת��
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//д������
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleTeacherSingleSemesterClassInfoList.add(onerow);
        		
        	}
        	rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectSingleTeacherSingleSemesterClassInfoList;
	}
	
	public ArrayList<ArrayList<String>> selectSingleClassInfo(ArrayList<String> data) {
		/**
		 * ��ѯĳ���༶��Ϣ
		 * */
		ArrayList<ArrayList<String>> selectSingleClassInfoList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE �༶ID = ?";
			ResultSet rs=database.execResult(sql,data);
			
			Integer stuIdint = null;
			Integer semesterIdint = null;
			Integer classIdint = null;
			Integer teacherIdint = null;
        	
        	while(rs.next()) {
        		
        		
        		//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
        		
        		stuIdint = rs.getInt("ѧ��ID");
        		semesterIdint = rs.getInt("ѧ��ID");
        		classIdint = rs.getInt("�༶ID");
        		teacherIdint = rs.getInt("������ID");
 
        		//���������ͽ���ת��
        		String stuId = Integer.toString(stuIdint);
        		String semesterId = Integer.toString(semesterIdint);
        		String classId = Integer.toString(classIdint);
        		String teacherId = Integer.toString(teacherIdint);
        		
        		//д������
        		onerow.add(stuId);
        		onerow.add(semesterId);
        		onerow.add(classId);
        		onerow.add(teacherId);
				
        		selectSingleClassInfoList.add(onerow);
        		
        	}
        	rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectSingleClassInfoList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		switch(choose) {
		case 1:
			result = selectSingleStudentClassInfo(data); // ��ѯĳ��ѧ�������а༶��Ϣ(������)
			
			break;
		case 2:
			result = selectSingleStudentSingleSemesterClassInfo(data); // ��ѯĳ��ѧ����ĳ��ѧ�ڵİ༶��Ϣ
			break;
		case 3:
			result = selectSingleTeacherClassInfo(data); // ��ѯĳ�������ι���������а༶��Ϣ(������)
			break;
		case 4:
			result = selectSingleTeacherSingleSemesterClassInfo(data); // ��ѯĳ����������ĳ��ѧ��������İ༶��Ϣ
			break;
		case 5:
			result = selectSingleClassInfo(data); // ��ѯĳ���༶��Ϣ
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}
}

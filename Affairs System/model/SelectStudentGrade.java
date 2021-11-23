package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentGrade implements DatabaseOperation{
	/**
	 * ѧ��ID�����Կ�ʼʱ�䡢��������ID��ѧ��ID��ѧ��ID�����Գɼ���Z-Score��T-Score���ȵ�
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectStudentGrade1(ArrayList<String> data) {
		/**
		 * ��ѯ�����ɼ���¼ ĳһѧ��
		 * */
		
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���ɼ���  WHERE ѧ��ID = ?, ��������ID = ?��ѧ��ID = ?, ѧ��ID = ?";
			database.exec(sql,data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentGrade2(ArrayList<String> data) {
		/**
		 * ��ѯ���γɼ���¼ ĳһ�ο���ȫ��ѧ��
		 * */
		
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���ɼ���  WHERE ѧ��ID = ?, ��������ID = ?��ѧ��ID = ?";
			database.exec(sql,data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentGrade3(ArrayList<String> data) {
		/**
		 * ��ѯĳ��ѧ��ȫ���ɼ���¼
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���ɼ���  WHERE ѧ��ID = ?";
			database.exec(sql,data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		switch(choose) {
		case 1:
			selectStudentGrade1(data); // ��ѯ�����ɼ���¼ ĳһѧ��
			break;
		case 2:
			selectStudentGrade2(data); // ��ѯ���γɼ���¼ ĳһ�ο���ȫ��ѧ��
			break;
		case 3:
			selectStudentGrade3(data); //��ѯĳ��ѧ��ȫ���ɼ���¼
			break;
		default:
			System.out.println("ERROR!");
		}
	}

}

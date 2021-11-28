package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentGrade implements DatabaseOperation{
	/**
	 * ѧ��ID�����Կ�ʼʱ�䡢��������ID��ѧ��ID��ѧ��ID�����Գɼ���Z-Score��T-Score���ȵ�
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentGrade1(ArrayList<String> data) {
		/**
		 * ɾ�������ɼ���¼ ĳһѧ��
		 * */
		
		database.connect();
		
		try {

			String sql = "DELETE FROM ѧ���ɼ��� WHERE ѧ��ID = ?, ��������ID = ?��ѧ��ID = ?, ѧ��ID = ?";
			database.exec(sql, data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentGrade2(ArrayList<String> data) {
		/**
		 * ɾ�����γɼ���¼ ĳһ�ο���ȫ��ѧ��
		 * */
		
		database.connect();
		
		try {

			String sql = "DELETE FROM ѧ���ɼ��� WHERE ѧ��ID = ?, ��������ID = ?��ѧ��ID = ?";
			database.exec(sql, data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentGrade3(ArrayList<String> data) {
		/**
		 * ɾ��ĳ��ѧ��ȫ���ɼ���¼
		 * */
		
		database.connect();
		
		try {
			
			database.delete("ѧ���ɼ���", "ѧ��ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		switch(choose) {
		case 1:
			deleteStudentGrade1(data); // ɾ�������ɼ���¼ ĳһѧ��
			break;
		case 2:
			deleteStudentGrade2(data); // ɾ�����γɼ���¼ ĳһ�ο���ȫ��ѧ��
			break;
		case 3:
			deleteStudentGrade3(data); // ɾ��ĳ��ѧ��ȫ���ɼ���¼
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}

}

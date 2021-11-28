package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentSubject implements DatabaseOperation{
	/**
	 * ѧ��ID������ѧ��ID������ѧ��ID1������ѧ��ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentSubject1(ArrayList<String> data) {
		/**
		 * ����ѧ��ID ɾ��ѧ�� ѡ�� ��Ϣ
		 * */
		
		database.connect();
		
		try {
			
			database.delete("ѧ����ѡ����", "ѧ��ID", data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudentSubject2(ArrayList<String> data) {
		/**
		 * �����ض�ѡ����Ϣ ɾ������ѧ�� ��������ѡ�Ƶ���Ϣ
		 * */
		
		database.connect();
		
		try {
			String sql = "DELETE FROM ѧ����ѡ���� WHERE ����ѧ��ID = ?, ����ѧ��ID1 = ?, ����ѧ��ID2 = ?";
			database.exec(sql, data);

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
			deleteStudentSubject1(data); // ����ѧ��ID ɾ��ѧ�� ѡ�� ��Ϣ
			break;
		case 2:
			deleteStudentSubject2(data); // �����ض�ѡ����Ϣ ɾ������ѧ�� ��������ѡ�Ƶ���Ϣ
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

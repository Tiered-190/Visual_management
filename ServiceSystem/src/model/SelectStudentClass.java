package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentClass implements DatabaseOperation{
	/**
	 * ѧ��ID��ѧ��ID���༶ID��������ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectStudentClass1(ArrayList<String> data) {
		/**
		 * ��ѯĳ��ѧ�������а༶��Ϣ
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ѧ��ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass2(ArrayList<String> data) {
		/**
		 * ��ѯĳ��ѧ����ĳ��ѧ�ڵİ༶��Ϣ
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ѧ��ID = ?, ѧ��ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass3(ArrayList<String> data) {
		/**
		 * ��ѯĳ�������ι���������а༶��Ϣ
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ������ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass4(ArrayList<String> data) {
		/**
		 * ��ѯĳ����������ĳ��ѧ��������İ༶��Ϣ
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE ������ID = ?, ѧ��ID = ?";
			database.exec(sql,data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudentClass5(ArrayList<String> data) {
		/**
		 * ��ѯĳ���༶��Ϣ
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���༶��  WHERE �༶ID = ?";
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
			selectStudentClass1(data); // ��ѯĳ��ѧ�������а༶��Ϣ(������)
			break;
		case 2:
			selectStudentClass2(data); // ��ѯĳ��ѧ����ĳ��ѧ�ڵİ༶��Ϣ
			break;
		case 3:
			selectStudentClass3(data); // ��ѯĳ�������ι���������а༶��Ϣ(������)
			break;
		case 4:
			selectStudentClass4(data); // ��ѯĳ����������ĳ��ѧ��������İ༶��Ϣ
			break;
		case 5:
			selectStudentClass5(data); // ��ѯĳ���༶��Ϣ
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}

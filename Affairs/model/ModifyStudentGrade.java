package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyStudentGrade implements DatabaseOperation{
	/**
	 * ѧ��ID�����Կ�ʼʱ�䡢��������ID��ѧ��ID��ѧ��ID�����Գɼ���Z-Score��T-Score���ȵ�
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyStudentGrade(ArrayList<String> data) {
		
		database.connect();
		
		try {
			String sql = "UPDATE ѧ���ɼ��� SET ���Կ�ʼʱ�� = ?, ��������ID = ?, ѧ��ID = ?,"
					+ "ѧ��ID = ?, ���Գɼ� = ?, Z-Score = ?, T-Score = ?, �ȵ� = ?"
					+ "WHERE ѧ��ID = ?";
			database.update(sql, data);

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
			modifyStudentGrade(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

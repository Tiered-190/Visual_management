package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyStudentSubject implements DatabaseOperation{
	/**
	 * ѧ��ID������ѧ��ID������ѧ��ID1������ѧ��ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyStudentSubject(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "UPDATE ѧ����ѡ���� SET ����ѧ��ID=?, ����ѧ��ID1=?, ����ѧ��ID2=? WHERE ѧ��ID=?";
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
			modifyStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}

}

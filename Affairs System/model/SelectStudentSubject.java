package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentSubject implements DatabaseOperation{
	/**
	 * ѧ��ID������ѧ��ID������ѧ��ID1������ѧ��ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();

	public void selectStudentSubject(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ����ѡ����  WHERE ѧ��ID = ?";
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
			selectStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}

}

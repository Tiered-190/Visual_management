package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddStudentSubject implements DatabaseOperation {
	/**
	 * ѧ��ID������ѧ��ID������ѧ��ID1������ѧ��ID2
	 * */
	public static DatabaseModel database = new DatabaseModel();

	public void addStudentSubject(ArrayList<String> data) {
		// TODO Auto-generated method stub

		database.connect();
		
		try {
			database.insert("ѧ����ѡ����",data);
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
			addStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}

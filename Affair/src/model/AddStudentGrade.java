package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddStudentGrade implements DatabaseOperation{
	/**
	 * ѧ��ID�����Կ�ʼʱ�䡢��������ID��ѧ��ID��ѧ��ID�����Գɼ���Z-Score��T-Score���ȵ�
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void addStudentGrade(ArrayList<String> data) {
		// TODO Auto-generated method stub
		database.connect();
		
		try {
			database.insert("ѧ���ɼ���",data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		switch(choose){
		case 1:
			addStudentGrade(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

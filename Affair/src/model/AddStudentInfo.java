package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddStudentInfo implements DatabaseOperation{
	/**
	 * ID���������Ա����塢��ѧ��ݡ��������ڡ���ͥסַ����ͥ���͡�������ò����ѧ����������š��Ƿ���ѧ
	 * */
	public static DatabaseModel database = new DatabaseModel();

	public void addStudentInfo(ArrayList<String> data) {
		// TODO Auto-generated method stub
		database.connect();
		
		try {
			database.insert("ѧ����",data);
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
			addStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

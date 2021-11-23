package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentInfo implements DatabaseOperation{
	/**
	 * ѧ��ID���������Ա����塢��ѧ��ݡ��������ڡ���ͥסַ����ͥ���͡�������ò����ѧ����������š��Ƿ���ѧ
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectStudentInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ���� WHERE ѧ��ID = ?";
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
			selectStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}


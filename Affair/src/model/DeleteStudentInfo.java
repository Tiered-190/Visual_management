package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentInfo implements DatabaseOperation{
	/**
	 * ID���������Ա����塢��ѧ��ݡ��������ڡ���ͥסַ����ͥ���͡�������ò����ѧ����������š��Ƿ���ѧ
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void deleteStudentInfo(ArrayList<String> data) {
		/**
		 * ����ѧ��ID ɾ��ѧ����Ϣ
		 * */
		
		database.connect();
		
		try {
			
			database.delete("ѧ����", "ѧ��ID", data);

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
			deleteStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

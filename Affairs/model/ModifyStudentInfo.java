package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyStudentInfo implements DatabaseOperation{
	/**
	 * ѧ��ID���������Ա����塢��ѧ��ݡ��������ڡ���ͥסַ����ͥ���͡�������ò����ѧ����������š��Ƿ���ѧ
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyStudentInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			
			String sql = "UPDATE ѧ���� SET ����=?, �Ա�=?, ����=?, ��ѧ���=?,"
					+ "��������=?, ��ͥסַ=?, ��ͥ����=?, ������ò=?, ��ѧ����=?, �����=?, �Ƿ���ѧ=?"
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
			modifyStudentInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

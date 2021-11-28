package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyTeacherInfo implements DatabaseOperation{
	/**
	 * ��ʦID���������Ա����塢������ò��ѧ�����������ڡ���ϵ�绰������
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void modifyTeacherInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "UPDATE ��ʦ�� SET ����=?, �Ա�=?, ����?, ������ò=?, ѧ��=?, ��������=?, ��ϵ�绰=?, ����=?"
					+ "WHERE ��ʦID=?";
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
			modifyTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return null;
	}
}

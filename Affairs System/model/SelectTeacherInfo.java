package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTeacherInfo implements DatabaseOperation{
	/**
	 * ��ʦID���������Ա����塢������ò��ѧ�����������ڡ���ϵ�绰������
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectTeacherInfo(ArrayList<String> data) {
		database.connect();
		
		try {
			String sql = "SELECT * FROM ��ʦ��  WHERE ��ʦID = ?";
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
			selectTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}



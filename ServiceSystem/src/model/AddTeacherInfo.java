package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddTeacherInfo implements DatabaseOperation{
	/**
	 * ��ʦID���������Ա����塢������ò��ѧ�����������ڡ���ϵ�绰������
	 * */
	public static DatabaseModel database = new DatabaseModel();

	public void addTeacherInfo(ArrayList<String> data) {
		// TODO Auto-generated method stub

		database.connect();
		
		try {
			database.insert("��ʦ��",data);
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
			addTeacherInfo(data);
			break;
		default:
			System.out.println("ERROR!");
		}
	}
}

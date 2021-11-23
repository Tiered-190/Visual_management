package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectTermTeacherSubjectClass implements DatabaseOperation{
	/**
	 * ѧ��ID����ʦID��ѧ��ID���༶ID
	 * */
	public static DatabaseModel database = new DatabaseModel();
	
	public void selectTermTeacherSubjectClass1(ArrayList<String> data) {
		/**
		 * ��ѯĳ����ʦ ���̵����а༶��ѧ�ơ�ѧ��
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ��-��ʦ-ѧ��-�༶��  WHERE ��ʦID = ?";
			database.exec(sql,data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectTermTeacherSubjectClass2(ArrayList<String> data) {
		/**
		 * ��ѯĳ����ʦ��ĳ��ѧ�� ���̵İ༶��ѧ�ơ�ѧ��
		 * */
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ��-��ʦ-ѧ��-�༶��  WHERE ��ʦID = ?, ѧ��ID = ?";
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
			selectTermTeacherSubjectClass1(data); // ��ѯĳ����ʦ ���̵����а༶��ѧ�ơ�ѧ��(������)
			break;
		case 2:
			selectTermTeacherSubjectClass2(data); //��ѯĳ����ʦ��ĳ��ѧ�� ���̵İ༶��ѧ�ơ�ѧ��
			break;
		default:
			System.out.println("ERROR!");
		}
	}

}

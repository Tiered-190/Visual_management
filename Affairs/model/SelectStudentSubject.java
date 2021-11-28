package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectStudentSubject implements DatabaseOperation{
	/**
	 * ѧ��ID������ѧ��ID������ѧ��ID1������ѧ��ID2
	 * */
	
	
	
	public static DatabaseModel database = new DatabaseModel();

	public ArrayList<ArrayList<String>> selectStudentSubject(ArrayList<String> data) {
		
		
		
		ArrayList<ArrayList<String>> selectStudentSubjectList = new ArrayList<ArrayList<String>>();
		database.connect();
		
		try {
			String sql = "SELECT * FROM ѧ����ѡ����  WHERE ѧ��ID = ?";
			ResultSet rs=database.execResult(sql,data);
	
			
			
			Integer stuInt = null;//ѧ��ID
			Integer mainSubjectId = null;//����ѧ��ID
			Integer Id1 = null;//����ѧ��ID1
			Integer Id2 = null;//����ѧ��ID2
			
			
			
			
			
			while(rs.next()) {
				
				//д��Arraylist������
	        	ArrayList<String> onerow = new ArrayList<String>();	// ����һά��������
				
	        	stuInt = rs.getInt("ѧ��ID");//��ȡѧ��ID
	        	mainSubjectId = rs.getInt("����ѧ��ID");//��ȡ����ѧ��ID
	        	Id1 = rs.getInt("����ѧ��ID1");//��ȡ����ѧ��ID1
	        	Id2 = rs.getInt("����ѧ��ID2");//��ȡ����ѧ��ID2
	        	
				
				
        		
				//���������ͽ���ת��
				String stu = Integer.toString(stuInt);
				String mainSubjectIdstr = Integer.toString(mainSubjectId);
				String Id1str = Integer.toString(Id1);
				String Id2str = Integer.toString(Id2);
				
				//д������
				onerow.add(stu);
        		onerow.add(mainSubjectIdstr);
        		onerow.add(Id1str);
        		onerow.add(Id2str);
        	
				
        		selectStudentSubjectList.add(onerow);
        		
        		
        	}
        	rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return selectStudentSubjectList;
	}

	@Override
	public ArrayList<ArrayList<String>> databaseOperation(ArrayList<String> data, int choose) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		switch(choose) {
		case 1:
			result = selectStudentSubject(data);
			break;
		default:
			System.out.println("ERROR!");
		}
		return result;
	}

}

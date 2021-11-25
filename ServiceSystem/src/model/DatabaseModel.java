package model;

import java.sql.*;
import java.util.ArrayList;
 
/**
 * 
 * ���ݿ������
 * �������ݿ�Ĳ���
 * 
 * **�����ܽ�**
 * 1����������
 * 2���������ݿ� DriverManager
 * 3����ȡִ��SQL�Ķ��� Statement
 * 4����÷��صĽ���� ResultSet
 * 5���ͷ�����
 * 
 */
public class DatabaseModel {
    //1����������
    private final static String driver = "com.mysql.jdbc.Driver";
    
    //2.�û���Ϣ��url
    private String url = "jdbc:mysql://localhost:3306/wechat?useUnicode=true&characterEncoding=utf-8";
    //mysql Ĭ�϶˿�3306
    //Э�� ��// ������ַ �� �˿ں� / ���ݿ��� �� ����1 & ����2 & ����3
    private String userName = "root";
    private String password = "123456";
    
    //3�����ӳɹ������ݿ���� Connection �������ݿ�
    private Connection connection;
    //connection = DriverManager.getConnection(url, userName, password);
    
    //4��ִ��sql�Ķ���
    private Statement statement;//��̬��ѯ
    private PreparedStatement preparedStatement;//��̬��ѯ
    
    public DatabaseModel() {
 
    }
    
    /*
    �������ݿ�
     */
    public void connect(){
        try {
            Class.forName(driver); //�̶�д������������
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**	��ѯ
     *
     * �÷�������ִ��Sql��䲢���ؽ���� �ʺ���Ҫ���ؽ�����Ĳ�ѯ��� 
     * ����   execResult("select*from user where id = ? and name = ?","1","jack");
     * ���ʺ�ռλ Ȼ�����String��������Ӧ�ʺŵ�ֵ �÷������ظ������ �� ResultSet
     *
     * @param Sql: String
     * @param data: ArrayList<String>
     * @return ResultSet
     * @throws SQLException
     * 
     */
    public ResultSet execResult(String Sql, ArrayList<String> data) throws SQLException {
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
            preparedStatement.setString(i, data.get(i-1));
        }
        return preparedStatement.executeQuery(); //��ѯ����������ResultSet
    }
 
    /**	�� ɾ ��
     *
     * ִ��Sql��� �������κζ��� 
     * ����exec("update user set password = ? where account = ?","password","name");
     * exec("delete from user where name = ? and account = ?","name","account");
     * exec("insert into user values(?,?,?,?,?,?,?,?,?)",1,2,3,4,5,6,7,8,9);
     * @param Sql: String
     * @param data: ArrayList<String>
     * @throws SQLException
     * 
     */
    public void exec(String Sql, ArrayList<String> data) throws SQLException {
 
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
            preparedStatement.setString(i, data.get(i-1));
        }
        preparedStatement.executeUpdate();
       //���롢ɾ�������£�����executeUpdate()
    }
 
    
    /**
     * ִ�о�̬SQL���  
     * ����exec("delete from user");
     * @param Sql��String
     */
    public void exec(String Sql) {
        try
        {
            preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.executeUpdate();
        }catch (Exception e){
        }
    }
    
    
    /**
     * �÷�������Ԫ��  
     * ����insert(����,Ҫ���������(String�������ʽ))
     * Sql = "INSERT INTO " + tableName + " VALUES(" + pre + ")"
     *
     * @param tableName��String
     * @param data��ArrayList<String> 
     * @throws SQLException
     */
    public void insert(String tableName, ArrayList<String> data) throws SQLException {
 
        String pre = "";
        for (int i = 0; i < data.size(); i++) {
 
            if (i != data.size() - 1)
                pre += "?,";
            else
                pre += "?";
 
        }
 
        String Sql = "INSERT INTO " + tableName + " VALUES(" + pre + ")";
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
 
            preparedStatement.setString(i, data.get(i-1));
 
        }
        preparedStatement.executeUpdate();
 
    }
 
    
    /**
     * �÷���ɾ��Ԫ��
     * "DELETE FROM " + tableName + " WHERE " + condition + "= ?";
     * 
     * @param tableName��String
     * @param condition��String
     * @param data��ArrayList<String>
     * @throws SQLException
     */
    public void delete(String tableName, String condition, ArrayList<String> data) throws SQLException {
 
 
        String Sql = "DELETE FROM " + tableName + " WHERE " + condition + "= ?";
 
 
        preparedStatement = connection.prepareStatement(Sql);
        for (int i = 1; i <= data.size(); i++) {
 
            preparedStatement.setString(i, data.get(i-1));
 
        }
        preparedStatement.executeUpdate();
 
    }
 
    
	/**
	 * �޸Ĳ��������룬�޸�ʱǰ���������ݣ�ԭ���ݣ���ʾ���޸ĺ���ԭ������ͷ��ʽ���������ݷ��ظ���ˣ�
	 * ����û�޸ĵ�����Ҳ��һ�𷵻� \\
	 * !!���⣺UPDATE ѧ����ѡ���� SET ����ѧ��ID=?, ����ѧ��ID1=?, ����ѧ��ID2=? WHERE ѧ��ID=? 
	 * ��Ϊ ������������ ���Ӧֵ��λ����Ҫǰ�˲��루�����ص������� ֵ��˳�� ���⣩
	 * 
	 * @param tableName��String
     * @param data��ArrayList<String> 
     * @throws SQLException
	 * */
    public void update(String Sql, ArrayList<String> data) throws SQLException {

//        String pre = "";
//        for (int i = 0; i < data.size(); i++) {
// 
//            if (i != data.size() - 1)
//                pre += "?,";
//            else
//                pre += "?";
// 
//        }
//    	
//        String Sql = "UPDATE " + tableName + " SET " + pre + " WHERE " + condition + "= ?";
        
        preparedStatement = connection.prepareStatement(Sql);
 
        for (int i = 1; i <= data.size(); i++) {
 
            preparedStatement.setString(i, data.get(i-1));
 
        }
        preparedStatement.executeUpdate();
 
    }
 
    /**
     * ��̬��ѯ����  
     * ����select(����,��ѯ����(String�������ʽ))
     * Sql = "SELECT" + targets + "FROM" + tables + " WHERE" + datas;
     *
     * @param tableName��String
     * @param data��ArrayList<String> 
     * @throws SQLException
     */
    public ResultSet select(ArrayList<String> tableName, ArrayList<String> target, ArrayList<String> data) throws SQLException {
 
        String tables = "", targets = "", datas = "";
        
        for (int i = 0; i < tableName.size(); i++) {
        	 
            if (i != tableName.size() - 1)
                tables += "?,";
            else
                tables += "?";
 
        }        
        
        for (int i = 0; i < target.size(); i++) {
 
            if (i != target.size() - 1)
            	targets += "?,";
            else
            	targets += "?";
 
        }
        for (int i = 0; i < data.size(); i++) {
 
            if (i != data.size() - 1)
                datas += "?,";
            else
                datas += "?";
 
        }
 
        String Sql = "SELECT" + targets + "FROM" + tables + " WHERE" + datas;
        
        preparedStatement = connection.prepareStatement(Sql);
        
        for (int i = 1; i <= target.size(); i++) {

            preparedStatement.setString(i, target.get(i-1));
 
        }
        
        for (int i = 1; i <= tableName.size(); i++) {

            preparedStatement.setString(i, tableName.get(i-1));
 
        }
        
        for (int i = 1; i <= data.size(); i++) {

            preparedStatement.setString(i, data.get(i-1));
 
        }
        
        return preparedStatement.executeQuery();
 
    }
    
    /**
     * ��̬��ѯ
     * 
     * @param Sql
     * @return
     * @throws SQLException
     */
    public ResultSet select(String Sql) throws SQLException {
 
        statement = connection.createStatement();
        return statement.executeQuery(Sql);
 
    }
 
    
    /**
     * �õ���̬��ѯ����
     * @return
     */
    public Statement getStatement() {
        return statement;
    }
 
    
    /**
     * �õ���̬��ѯ����
     * @return
     */
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
 
    
    /**
     * �õ����ݿ����Ӷ���
     * @return
     */
    public Connection getConnection() {
        return connection;
    }
 
    
    /**
     * ���ݿ�����
     * @param Url
     * @param UserName
     * @param Password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void reConnection(String Url, String UserName, String Password) throws ClassNotFoundException, SQLException {
 
        Class.forName(driver);
        connection = DriverManager.getConnection(Url, UserName, Password);
 
    }
    
}
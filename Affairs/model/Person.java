package model;

public class Person {
	
	protected String name=" ";
	protected int id=0;
	private String password=" ";
	protected int identity=0;
	
	protected boolean register(int id, String password) {
		/*��¼����*/
		boolean status=true;
		return status;
	}
	
	protected boolean changePassword(int id, String password) {
		/*��¼�����޸�*/
		boolean status=true;
		return status;
	}
	
	protected int getId() {
		/*���ص�½�ߵ�ID*/
		return this.id;
	}
	
	protected void setIdentity() {
		/*����״̬��1��ʾ�Ѿ���¼��0��ʾδ��¼*/
		this.identity = 0;
	}
	
}

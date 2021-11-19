package model;

import java.util.ArrayList;
import java.util.Vector;

public class Parents extends Person{
	/*ȫ�� ��˽�б�����ͨ��set���������ݿ��л�ȡ��ͨ��get�����ṩ���ⲿ����*/
	/*�������͸������ݿ���ƣ����������Ҫ�޸�*/
	//	private String gender=" ";
	//	private int enrollemtYear=0;
	//	private int age=0;
	//	private String politicsStatus=" ";
	//	private String teacherName =" ";
	
	/*���˲鿴ѧ��������Ϣ�Ĺ��ܣ��������ܵ����ݽṹʹ��java���еĹ��߰����ṩ����������*/
	/*ʹ����Ϊ�ӿ������������ñ���*/
	CheckStudentInfoBehavior checkStudentInfoBehavior;
	CheckStudentTrackInfoBehavior checkStudentTrackInfoBehavior;
	CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior;
	CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior;
	CheckStudentAttendanceRecordBehavior checkStudentAttendanceRecordBehavior;
	AddStudentInfoBehavior addStudentInfoBehavior;
	
	/*��Ϊί�и���Ϊ��-��Ҫд��return ����,��˷���ֵ��Ҫ�ı�*/
	public ArrayList<String> performCheckStudentInfo() {
		//�鿴ѧ��������Ϣ
		return checkStudentInfoBehavior.checkStudentInfo();
	}
	
	public void performCheckStudentTrackInfo() {
		//�鿴�ɳ�����
		checkStudentTrackInfoBehavior.checkStudentTrackInfo(this.id);
	}
	
	public ArrayList<ArrayList<String>> performCheckStudentGradeInfo() {
		//�鿴ѧҵ����
		return checkStudentGradeInfoBehavior.checkStudentGradeInfo();
	}
	
	public void performCheckStudentConsumptionInfo() {
		//�鿴�������
		checkStudentConsumptionInfoBehavior.checkStudentConsumptionInfo();
	}
	
	public void performCheckStudentAttendanceRecord() {
		//�鿴�������
		checkStudentAttendanceRecordBehavior.checkStudentAttendanceRecord();
		
	}
	
	public void performAddStudentInfo() {
		//������Ϣ��д�����ݿ�
		addStudentInfoBehavior.addStudentInfo();
	}
	
	/*��̬�趨��Ϊ��ʵ���ϴ����Ӧ����һ�����ʵ��*/
	public void setCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		this.checkStudentInfoBehavior = checkStudentInfoBehavior;
	}
	
	public void setCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		this.checkStudentTrackInfoBehavior = checkTrackInfoBehavior;
	}
	
	public void setCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		this.checkStudentGradeInfoBehavior = checkStudentGradeInfoBehavior;
	}
	
	public void setCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		this.checkStudentConsumptionInfoBehavior = checkStudentConsumptionInfoBehavior;
	}
	
	public void setCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		this.checkStudentAttendanceRecordBehavior = checkAttendanceRecordBehavior;
	}
	
	public void setAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		this.addStudentInfoBehavior = addStudentInfoBehavior;
	}
	
	
}
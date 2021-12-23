<<<<<<< HEAD
package Controller;
import model.*;

import java.util.Vector;

public class ParentsController {
	private Parents parents;

	
	public ParentsController(){
	}
	
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}

	
	/*��̬����Parents���е���Ϊ����:���޸Ŀ���*/
	public void setParentsCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		parents.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	public void setParentsCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		parents.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);
	}
	
	public void setParentsCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		parents.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}
	
	public void setParentsCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		parents.setCheckStudentConsumptionInfoBehavior(checkStudentConsumptionInfoBehavior);
	}
	
	public void setParentsCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		parents.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}
	
	public void setParentsAddStudentInfoBehavior(AddStudentInfoBehavior addStudentInfoBehavior) {
		parents.setAddStudentInfoBehavior(addStudentInfoBehavior);
	}
=======
package Controller;
import model.*;

import java.util.ArrayList;
import java.util.Vector;

import View.*;

public class ParentsController {
	private Parents parents;
	
	public ParentsController(){
	}
	
	public void setParentsModel(Parents parents) {
		this.parents=parents;
	}
	
	public ArrayList<String> getStudentInfoView(String ID) {
		//��ӡѧ���Ļ�����Ϣ
		return parents.performCheckStudentInfo(ID);
	}
	
	public ArrayList<ArrayList<Integer>> getStudentGradeInfoView(String ID, String num) {
		//��ӡѧ��ѧҵ��Ϣ
		int n = Integer.parseInt(num);
		return parents.performCheckStudentGradeInfo(ID, n);
	}
	
	public ArrayList<Integer> getStudentAttendanceRecordView(String ID, String num) {
		//��ӡ���ڼ�¼
		int n = Integer.parseInt(num);
		int studentID = Integer.parseInt(ID);
		return parents.performCheckStudentAttendanceRecord(studentID, n);
	}
	
	public ArrayList<Integer> getStudentTrackInfoView(String ID, String num) {
		//��ӡ�ɳ�����
		int n = Integer.parseInt(num);
		return parents.performCheckStudentTrackInfo(ID, n);
	}
	
	public ArrayList<Double> getStudentConsumptionInfoView(String ID, String num) {
		//��ӡ�ɳ�����
		int n = Integer.parseInt(num);
		return parents.performCheckStudentConsumptionInfo(ID, n);
	}
	
	/*��̬����Parents���е���Ϊ����:���޸Ŀ���*/
	public void setParentsCheckStudentInfoBehavior(CheckStudentInfoBehavior checkStudentInfoBehavior) {
		parents.setCheckStudentInfoBehavior(checkStudentInfoBehavior);
	}
	
	public void setParentsCheckStudentTrackInfoBehavior(CheckStudentTrackInfoBehavior checkTrackInfoBehavior) {
		parents.setCheckStudentTrackInfoBehavior(checkTrackInfoBehavior);
	}
	
	public void setParentsCheckStudentGradeInfoBehavior(CheckStudentGradeInfoBehavior checkStudentGradeInfoBehavior) {
		parents.setCheckStudentGradeInfoBehavior(checkStudentGradeInfoBehavior);
	}
	
	public void setParentsCheckStudentConsumptionInfoBehavior(CheckStudentConsumptionInfoBehavior checkStudentConsumptionInfoBehavior) {
		parents.setCheckStudentConsumptionInfoBehavior(checkStudentConsumptionInfoBehavior);
	}
	
	public void setParentsCheckStudentAttendanceRecordBehavior(CheckStudentAttendanceRecordBehavior checkAttendanceRecordBehavior) {
		parents.setCheckStudentAttendanceRecordBehavior(checkAttendanceRecordBehavior);
	}
	

>>>>>>> 408f01557a212803392a6fde5c7b35e7b8cd5c8b
}
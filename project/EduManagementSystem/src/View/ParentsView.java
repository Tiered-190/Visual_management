   
package View;
import java.util.ArrayList;
import java.util.Vector;

import model.*;

public class ParentsView {
	
	/*�������������Ҫ���������-������Ҫ�ı�*/
	public void printStudentInfo(ArrayList<String> studentInfo) {
		//��ӡѧ���Ļ�����Ϣ
		System.out.println(studentInfo);
	}
	
	public void printStudentGradeInfo(ArrayList<ArrayList<String>> gradeInfo) {
		//��ӡѧ��ѧҵ��Ϣ
		System.out.println(gradeInfo);
		
	}
	
	public void printStudentConsumptionInfo() {
		//��ӡѧ��������Ϣ
	}
	
	public void printStudentAttendanceRecord() {
		//��ӡ���ڼ�¼
	}
	
	public void printStudentTrackInfo() {
		//��ӡ�ɳ�����
	}
	
}
package Controller;
import model.*;
import View.*;

public class main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//�ȴ���һ��controller��
		
		ParentsController parentsController=new ParentsController();
		//��Controller�������趨model��View
		parentsController.setParentsModel(new Parents());
		parentsController.setParentsView(new ParentsView());
		
		//��Ҫ�趨�鿴ѧ��������Ϣ����Ϊ��
		parentsController.setParentsCheckStudentInfoBehavior(new CheckStudentInfoClass());
		//������ͼ�Ϳ��Բ鿴ѧ���Ļ�����Ϣ��
		parentsController.getStudentInfoView();
		
		parentsController.setParentsCheckStudentGradeInfoBehavior(new CheckStudentGradeInfoClass());
		parentsController.getStudentGradeInfoView();
		
		
	}

}
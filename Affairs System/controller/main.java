package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import model.Dept;

public class main {
    public static void main(String[] args){
		// TODO �Զ����ɵķ������
		//�ȴ���һ��controller��
		DeptController deptController = new DeptController();
		//��Controller�������趨model��View
		deptController.setDeptModel(new Dept());
//		��ʱ��ûд View
//		deptController.setDeptView(new DeptView());
		
		Socket socket = null;
	    try {
	    	socket = new Socket("localhost",8081);//����Socket, ��������
	    	System.out.println("�ͻ����Ѿ�������");
    		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		PrintStream ps = new PrintStream(socket.getOutputStream());
    		Scanner scanner = new Scanner(System.in);   // ����Scanner
    		System.out.println("������һ���ַ���:");    // ������ʾ����
            scanner.useDelimiter("\r\n");
            String msg = null;
            while( !(msg = scanner.next()).equals("Bye") ){
                System.out.printf("Send Msg --> %s \n", msg);
	    		ps.println(msg);//���͵������
	    		ps.flush(); // �������ͣ�������Ҫ���۵�һ����С��һ���Է���
	    		if((socket.getInputStream().available())==0)
	    			System.out.println(br.readLine());// ��ȡ����˷��ص��ַ���, ��ӡ  
	    	}
            scanner.close();
            
	    } catch (Exception e){
	    	e.printStackTrace();
	    }finally{
	    	if(socket != null){
	    		try {
	    			socket.close();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	}
}


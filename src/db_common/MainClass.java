package db_common;

import java.util.Scanner;

import db_dto.NewStDTO;
import db_manager.DBManager;
import db_manager.DBManagerlmpl;
import db_student.DBStudent;
import db_student.DBStudentlmpl;

public class MainClass {
	
	
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int num;
	String id,manager, name;
	NewStDTO dto;
	dto = new NewStDTO();
	DBStudent student = new DBStudentlmpl();
	DBManager mng = new DBManagerlmpl();
	
	while(true) {
		System.out.println("모드를 선택해주세요");
		System.out.println("1. 관리자 등록");
		System.out.println("2. 관리자 로그인");
		System.out.println("3. 학생 로그인");
		num = input.nextInt();
		switch(num) {
		case 1 : System.out.println("관리자 등록");
		manager = input.next();
		dto.setManager(manager);
		System.out.println("등록완료");
		break;
		case 2 : System.out.println("관리자 로그인");
		manager = input.next();
		if(manager.equals(dto.getManager())) {
			mng.display(); break;
		}else { System.out.println("없는 id입니다, 다시 입력해주세요");
	} break;
		case 3: 
			System.out.println("학생 id 입력");
			id = input.next();
			if(id.equals(dto.getId())) {
				student.display(); break;
			}else { System.out.println("없는 id입니다, 다시 입력해주세요");
		}break;
	
	
	}
}
}
}
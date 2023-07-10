package db_manager;

import java.util.ArrayList;
import java.util.Scanner;

import db_dao.NewStDAO;
import db_dto.NewStDTO;

public class DBManagerlmpl implements DBManager {
	String name;
	int kor, eng, mat, sum, avg;
	NewStDAO dao;
	
	public DBManagerlmpl() {
		dao = new NewStDAO();
	}

	public void display() {
		Scanner input = new Scanner(System.in);
		int num;

		System.out.println("1.성적 조회");
		System.out.println("2.성적 추가");
		System.out.println("3.성적 수정");
		System.out.println("4.성적 삭제");
		num = input.nextInt();

		switch(num) {
		case 1: 
			ArrayList<NewStDTO> list = getlist();
			System.out.println("============ 성적 정보 ===========");
			System.out.println("name\tkor\teng\tmath\tsum\tavg");
			System.out.println("===============================");
			for(NewStDTO d : list) {
				System.out.print( d.getName()+"\t" );
				System.out.print( d.getKor()+"\t" );
				System.out.println( d.getEng()+"\t" );
				System.out.println( d.getMat()+"\t" );
				System.out.println( d.getSum()+"\t" );
				System.out.println( d.getAvg() );
				System.out.println("--------------");
			}

			break;
		case 2: 
			while(true) {
				System.out.println("추가할 학생 입력 : ");
				name = input.next();
				NewStDTO d = search(name);
				if(d == null) {
					break;
				}
				System.out.println("존재하는 학생입니다");
			}
			System.out.println("국어 점수 입력 : ");
			kor = input.nextInt();
			System.out.println("영어 점수 입력 : ");
			eng = input.nextInt();
			System.out.println("수학 점수 입력 : ");
			mat = input.nextInt();
			System.out.println("합계 입력 : ");
			sum = input.nextInt();
			System.out.println("평균 입력 : ");
			avg = input.nextInt();

			int re = insert(name, kor, eng, mat, sum, avg);
			if(re == 1) {
				System.out.println("추가하였습니다.");
			}else {
				System.out.println("있는 정보입니다.");
			}
			break;
		case 3: 
			while(true) {
				System.out.println("수정 할 학생 입력 : ");
				name = input.next();
				NewStDTO d = search(name);
				if(d != null) {
					break;
				}
				System.out.println("존재하지 않는 학생입니다");
			}
			System.out.println("수정 할 국어 점수 입력 : ");
			kor = input.nextInt();
			System.out.println("수정 할 영어 점수 입력 : ");
			eng = input.nextInt();
			System.out.println("수정 할 수학 점수 입력 : ");
			mat = input.nextInt();
			System.out.println("수정 할 합계 입력 : ");
			sum = input.nextInt();
			System.out.println("수정 할 평균 입력 : ");
			avg = input.nextInt();

			NewStDTO d = new NewStDTO(name, kor, eng, mat, sum, avg);

			int re1 = modify( d );
			if(re1 == 1) {
				System.out.println("수정하였습니다.");
			}else {
				System.out.println("문제발생");
			}
			break;
		case 4: 
			System.out.println("삭제할 학생 입력");
			name = input.next();
			int result = delete( name );

			if(result == 1) {
				System.out.println("삭제하였습니다");
			}else {
				System.out.println("문제발생");
			}
			break;
		}
	}

	public int modify( NewStDTO d ) {
		return dao.modify( d );
	}

	public int delete(String name) {
		return dao.delete(name);
	}


	public int insert(String name, int kor, int eng, int mat, int sum, int avg) {
		NewStDTO dto = new NewStDTO();

		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setSum(sum);
		dto.setAvg(avg);
		return dao.insert( dto );
	}


	public ArrayList<NewStDTO> getlist() {
		ArrayList<NewStDTO> list = dao.getList();
		return list;
	}


	public NewStDTO search( String name ) {
		NewStDTO dto = dao.search( name );
		return dto;
	}
}

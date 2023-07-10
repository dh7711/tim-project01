package db_dto;

public class NewStDTO {
	private String manager; 
	private String id;
	private String name;
	private int kor, eng, mat, avg, sum;
	
	public NewStDTO(String name, int kor, int eng, int math, int sum, int avg ) {
		this.name = name; this.kor = kor; this.eng = eng; this.mat = mat; this.sum = sum; this.avg = avg;
	}
	public NewStDTO() {

	}
	public String getId() {
		return id; 
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}

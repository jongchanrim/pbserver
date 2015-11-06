package kr.pb.dto;

import java.sql.Date;

//DTO(Data Transfer Object) = VO(Value Object) = JavaBean
public class Member {
	
	private String email; // �ʵ忡���� ���������ڸ� private���� ����Ѵ�. ��ü���� Ư������ �������� Ư��������
	private String passwd;
	private String name;

	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return passwd;
	}
	public void setPw(String pw) {
		this.passwd = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

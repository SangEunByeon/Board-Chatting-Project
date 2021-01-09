package com.example.demo.dto;

import lombok.Data;

@Data
public class MemberDto {

	private String id;
	private String password;
	private String name;
	private String mail1;
	private String mail2;
	private String phone;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	
	public MemberDto( String id, String password, String name, String mail1, String mail2, String phone,
			String address1, String address2, String address3, String address4) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
	}
	
	
}

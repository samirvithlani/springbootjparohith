package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountBean {

	@Id
	@GeneratedValue
	private int aId;

	private String aType;

	@OneToOne(mappedBy = "accounts")
	private UserBean users;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	public UserBean getUsers() {
		return users;
	}

	public void setUsers(UserBean users) {
		this.users = users;
	}

}

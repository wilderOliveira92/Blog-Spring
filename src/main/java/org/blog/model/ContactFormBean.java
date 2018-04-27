package org.blog.model;

import java.util.List;

import org.blog.utils.BaseBean;

public class ContactFormBean extends BaseBean {

	private static final long serialVersionUID = 201404020249L;

	private List<ContactBean> contacts;

	public ContactFormBean() {
	}

	public List<ContactBean> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<ContactBean> contacts) {
		this.contacts = contacts;
	}
}

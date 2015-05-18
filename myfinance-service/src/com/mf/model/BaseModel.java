package com.mf.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseModel implements Serializable {

	private Integer id;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}

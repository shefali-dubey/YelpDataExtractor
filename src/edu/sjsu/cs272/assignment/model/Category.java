package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;

import edu.sjsu.cs272.assignment.util.CommonUtils;

/*
 * Table : CATEGORY
 */
public class Category implements Serializable {
	private static final long serialVersionUID = -4775996034505988253L;
	private static final String ID = "ID";
	private static final String NAME = "NAME";
	private static final String TABLE_NAME = "CATEGORY";
	public int id = -1;
	public String name;

	public Category(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public Category() {
	}

	@Override
	public String toString() {
		return new StringBuilder().append(id).append(",")
				.append(CommonUtils.getString(name).replaceAll(",", "")).append("\n").toString();
	}

	public static String getCsvHeaderName() {
		return new StringBuilder().append(ID).append(",").append(NAME)
				.append("\n").toString();
	}

	public static String getDDL() {
		return new StringBuilder("CREATE TABLE ").append(TABLE_NAME)
				.append(" ( ").append(ID).append(" INT ,").append(NAME)
				.append(" VARCHAR(50));").toString();
	}

}

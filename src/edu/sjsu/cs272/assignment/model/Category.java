package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;

/*
 * Table : Category
 */
public class Category implements Serializable {
	private static final long serialVersionUID = -4775996034505988253L;
	public int id = -1;
	public String name;

	public Category(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public Category() {
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Category) {
			Category c = (Category) obj;
			if (c.name.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}

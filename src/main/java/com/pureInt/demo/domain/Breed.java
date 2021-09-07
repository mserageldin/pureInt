package com.pureInt.demo.domain;

import java.util.List;



public class Breed implements Comparable<Breed> {
	public Breed(String name, List<String> types) {
		super();
		Name = name;
		this.types = types;
	}

	public Breed() {
		Name = "";
		this.types = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Breed other = (Breed) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	public String Name;
	public List<String> types;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public int compareTo(Breed arg0) {
		// TODO Auto-generated method stub
		return this.Name.compareTo(arg0.Name);
	}

}

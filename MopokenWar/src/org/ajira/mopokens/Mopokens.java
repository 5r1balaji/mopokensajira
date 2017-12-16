package org.ajira.mopokens;

public class Mopokens {
	private String name;
	private int level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	@Override
	public String toString() {
		return "Mopokens [name=" + name + ", level=" + level + "]";
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Mopokens() {
		// TODO Auto-generated constructor stub
	}
	
	public Mopokens(String name,int level) {
		this.name=name;
		this.level=level;
	}

}

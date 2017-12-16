package org.ajira.mopokens;

public class Mopokens {
	String name;
	int level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
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

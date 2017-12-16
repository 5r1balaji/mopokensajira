package org.ajira.mopokens;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MopokenAdapter implements Adaptable {
	private MopokenStrength strength;
	private  Map<String, Mopokens> opponents=new HashMap<String, Mopokens>();
	public MopokenAdapter( Map<String, Mopokens> opponents) {
		this.opponents=opponents;
		this.setMopokenStrength();
	}
	
	
	private void setMopokenStrength() {
		// TODO Auto-generated method stub
		this.strength=MopokenStrength.getInstance();
	}

  
	public Mopokens match(Mopokens mopoken) {
		return null;
	}
	
	public Mopokens getTypeAdvantage(Mopokens player) {
		List<String> oppAdv=this.strength.getMopokenStrength().get(player.name);
		Map<String,Mopokens> enemies=this.opponents;
		for(String s:oppAdv) {
			if(enemies.containsKey(s)) {
				Mopokens opponent=enemies.get(s);
				if(opponent.getLevel()<player.getLevel()) {
					return opponent;
				}
			}
		}
		return null;
	}
	
	public Mopokens getLevelAdvantage(Mopokens player) {
		for(String s:this.opponents.keySet()) {
			if(player.getLevel()>this.opponents.get(s).getLevel()) {
				return this.opponents.get(s);
			}
		}
		return null;
	}
	
	public Mopokens makeDraw(Mopokens player) {
		for(String s:this.opponents.keySet()) {
			if(player.getLevel()==this.opponents.get(s).getLevel()) {
				return this.opponents.get(s);
			}
		}
		return null;
	}
	
}

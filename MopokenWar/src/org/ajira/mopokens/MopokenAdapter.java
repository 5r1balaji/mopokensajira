package org.ajira.mopokens;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MopokenAdapter implements Adaptable {
	private MopokenStrength strength;
	private  Map<String, Mopokens> mySquad=new LinkedHashMap<String, Mopokens>();
	public  static int deciderCount=0;
	public MopokenAdapter( Map<String, Mopokens> opponents) {
		this.mySquad=opponents;
		this.setMopokenStrength();
	}
	
	
	private void setMopokenStrength() {
		// TODO Auto-generated method stub
		this.strength=MopokenStrength.getInstance();
	}

  
	public Mopokens match(Mopokens mopoken) {
		Mopokens result=null;
		result=getWeakAdvantage(mopoken);
		if(result==null) {
			result=getTypeAdvantage(mopoken);
			if(result==null) {
				result=makeDraw(mopoken);
				if(result==null) {
					result=getLevelAdvantage(mopoken);
					if(result==null) {
						Map<String, Mopokens> mySquad=this.mySquad;
						for(Map.Entry<String,Mopokens> s:mySquad.entrySet()) {
							result=s.getValue();
							this.mySquad.remove(s.getKey());
							System.out.println(mopoken.getName()+"won against "+result.getName());
							break;
						}
					}
				}
				
			}
		}
		
		
		return result;
	}
	
	
	public Mopokens getWeakAdvantage(Mopokens opponent) {
		
		List<String> oppAdv=this.strength.getMopokenStrength().get(opponent.getName());
		Map<String,Mopokens> mySquad=this.mySquad;
		for(String s :oppAdv) {
			if(mySquad.containsKey(s)) {
				Mopokens player=mySquad.get(s);
				if(player.getLevel()>= (2*opponent.getLevel())) {
					deciderCount++;
					this.mySquad.remove(s);
					System.out.println("type but level");
					return player;
				}
			}
		}
		
		return null;
	}
	public Mopokens getTypeAdvantage(Mopokens opponent) {
		
		Map<String,Mopokens> mysquad=this.mySquad;
		for(Map.Entry<String,Mopokens> map:mysquad.entrySet()) {
			List<String> oppAdv=this.strength.getMopokenStrength().get(map.getKey());
			for(String s :oppAdv) {
				if(opponent.getName().equals(s) ){
					if(opponent.getLevel()<map.getValue().getLevel() ||  opponent.getLevel()< ( 2*map.getValue().getLevel() )) {
						this.mySquad.remove(map.getKey());
						deciderCount++;
						System.out.println("type and level");
						return map.getValue();
					}
					
				}
			}
		}
		
		
		return null;
	}
	
	
	
	
	public Mopokens getLevelAdvantage(Mopokens opponent) {
		Map<String,Mopokens> mySquad=this.mySquad;
		for(Map.Entry<String,Mopokens> s:mySquad.entrySet()) {
			if(s.getValue().getLevel()>opponent.getLevel()) {
				deciderCount++;
				this.mySquad.remove(s.getKey());
				System.out.println("level advantage");
				return s.getValue();
			}
		}
		return null;
	}
	
	public Mopokens makeDraw(Mopokens opponent) {
		Map<String,Mopokens> mySquad=this.mySquad;
		for(Map.Entry<String,Mopokens> s:mySquad.entrySet()) {
			
			if(s.getValue().getLevel()==opponent.getLevel()) {
				this.mySquad.remove(s.getKey());
				System.out.println("Draw");
				return s.getValue();
			}
		}
		return null;
	}
	
}

package org.ajira.mopokens;




import java.util.Map;

public class MopokenSquad implements BattleNominees{
	
	
	public MopokenSquad() {
		
	}
	
	public MopokenSquad(String myPlayers, String opponents) {
		parseMopokensList(myPlayers,mySquad);
		parseMopokensList(opponents,enemySquad);
	}

	
	@Override
	public void parseMopokensList(String parseString,Map<String,Mopokens> mopokensMap){
		String[] mopokens=parseString.split(";");
		for(int i=0;i<mopokens.length;i++) {
			String s[]=mopokens[0].split("#");
			mopokensMap.put(s[0],new Mopokens(s[0],Integer.parseInt(s[1])));
		}
		
	}

	
	
	
	
}

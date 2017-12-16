package org.ajira.mopokens;


import java.util.LinkedHashMap;
import java.util.Map;

public interface BattleNominees {
	 public   Map<String,Mopokens> mySquad=new LinkedHashMap<String,Mopokens>();
	 public   Map<String,Mopokens> enemySquad=new LinkedHashMap<String,Mopokens>();
	  public void parseMopokensList(String parseString,Map<String,Mopokens>mopokensMap);
	 
}

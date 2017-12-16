package org.ajira.mopokens;


import java.util.HashMap;

import java.util.Map;

public interface BattleNominees {
	 public   Map<String,Mopokens> mySquad=new HashMap<String,Mopokens>();
	 public   Map<String,Mopokens> enemySquad=new HashMap<String,Mopokens>();
	  public void parseMopokensList(String parseString,Map<String,Mopokens>mopokensMap);
	 
}

package org.ajira.mopokens.actions;


import java.util.LinkedHashMap;
import java.util.Map;

import org.ajira.mopokens.model.Mopokens;

public interface BattleNominees {
	 public   Map<String,Mopokens> breederSquad=new LinkedHashMap<String,Mopokens>(); // Collection of mopokens that of the breeder
	 public   Map<String,Mopokens> opponentSquad=new LinkedHashMap<String,Mopokens>();// Collections of mopokens of the opponent
	  public void parseMopokensList(String parseString,Map<String,Mopokens>mopokensMap);
	 
}

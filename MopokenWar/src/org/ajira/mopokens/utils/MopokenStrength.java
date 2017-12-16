package org.ajira.mopokens.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MopokenStrength {
	
	/* Singleton class keeps the strength of each mopokens as a reference thoroughout */
	
	
	private static MopokenStrength mopokenStrength=null;
	private  Map<String,List<String>> strength=new LinkedHashMap<String,List<String>>();
	
	private MopokenStrength() {
		
	}
	public static MopokenStrength getInstance(){
		mopokenStrength=new MopokenStrength();
		return mopokenStrength;
	}
	
	public Map<String,List<String>> getMopokenStrength(){
		strength.put("Fire", Arrays.asList("Grass","Ghost"));
		strength.put("Water", Arrays.asList("Fire"));
		strength.put("Grass", Arrays.asList("Electric","Fighting"));
		strength.put("Electric", Arrays.asList("Water"));
		strength.put("Psychic", Arrays.asList("Ghost"));
		strength.put("Ghost", Arrays.asList("Fighting","Fire","Electric"));
		strength.put("Fighting", Arrays.asList("Electric"));
		return strength;
	}
}

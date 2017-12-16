package org.ajira.mopokens;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MopokenStrength {
	private static MopokenStrength mopokenStrength=null;
	private  Map<String,List<String>> strength=new HashMap<String,List<String>>();
	
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

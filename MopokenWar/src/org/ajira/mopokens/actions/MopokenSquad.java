package org.ajira.mopokens.actions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.ajira.mopokens.model.Mopokens;

public class MopokenSquad implements BattleNominee {

	/*
	 * This class allows you to parse the input strings and get the hashmap for
	 * opponent and mysquad
	 */
	public Map<String, Mopokens> mopokens = new LinkedHashMap<String, Mopokens>(); // Collection of mopokens that of the
																					// breeder

	public MopokenSquad() {

	}

	public MopokenSquad(String myPlayers) {
		parseMopokensList(myPlayers);

	}

	public void parseMopokensList(String parseString) {
		String[] mopoken = parseString.split(";");
		for (int i = 0; i < mopoken.length; i++) {
			String s[] = mopoken[i].split("#");
			mopokens.put(s[0], new Mopokens(s[0], Integer.parseInt(s[1])));
		}

	}

	@Override
	public Map<String, Mopokens> getMopokens() {
		return this.mopokens;
	}

}

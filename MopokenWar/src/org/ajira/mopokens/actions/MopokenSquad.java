package org.ajira.mopokens.actions;

import java.util.Map;

import org.ajira.mopokens.model.Mopokens;

public class MopokenSquad implements BattleNominees {

	/*
	 * This class allows you to parse the input strings and get the hashmap for
	 * opponent and mysquad
	 */

	public MopokenSquad() {

	}

	public MopokenSquad(String myPlayers, String opponents) {
		parseMopokensList(myPlayers, breederSquad);
		parseMopokensList(opponents, opponentSquad);
	}

	@Override
	public void parseMopokensList(String parseString, Map<String, Mopokens> mopokensMap) {
		String[] mopokens = parseString.split(";");
		for (int i = 0; i < mopokens.length; i++) {
			String s[] = mopokens[i].split("#");
			mopokensMap.put(s[0], new Mopokens(s[0], Integer.parseInt(s[1])));
		}

	}

}

package org.ajira.mopokens.actions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.ajira.mopokens.model.Mopokens;

public interface BattleFixtures {

	public static Map<Mopokens, Mopokens> fights = new LinkedHashMap<Mopokens, Mopokens>();// Maintains the battle
																							// fixture for every
																							// mopokens i.e Mopoken vs
																							// Mopoken

	public void organizeMopokens();

}

package org.ajira.mopokens.actions;

import java.util.List;
import java.util.Map;

import org.ajira.mopokens.model.Mopokens;
import org.ajira.mopokens.utils.MopokenStrength;

public class MopokenAdapter implements Adaptable {

	/* Adapter class adapts the best suited mopokens for each opponent */

	private MopokenStrength strength;
	private Map<String, Mopokens> mySquad;
	private Mopokens result = null;
	public static int deciderCount = 0;
	public boolean isWin = false;

	public MopokenAdapter(Map<String, Mopokens> breeder) {
		this.mySquad = breeder;
		this.setMopokenStrength();
	}

	private void setMopokenStrength() {

		this.strength = MopokenStrength.getInstance();
	}

	public Mopokens match(Mopokens mopoken) {
		result = null;

		getLevelAdvantage(mopoken);
		getWeakAdvantage(mopoken);
		getTypeAdvantage(mopoken);

		if (!isWin) {
			makeDraw(mopoken);
			if (result == null) {
				Map<String, Mopokens> mySquad = this.mySquad;
				for (Map.Entry<String, Mopokens> s : mySquad.entrySet()) {
					result = s.getValue();
					break;
				}
			}
		}

		this.mySquad.remove(result.getName());

		if (isWin) {
			deciderCount++;
		}
		isWin = false;
		return result;
	}

	/*
	 * Mopokens which are weak compared to the opponent but still holds advantage
	 * over the levels
	 */

	public void getWeakAdvantage(Mopokens opponent) {

		List<String> oppAdv = this.strength.getMopokenStrength().get(opponent.getName());
		Map<String, Mopokens> mySquad = this.mySquad;
		for (String s : oppAdv) {
			if (mySquad.containsKey(s)) {
				Mopokens player = mySquad.get(s);
				if (player.getLevel() >= (2 * opponent.getLevel())) {

					if (result != null) {
						chooseClosestLevel(opponent, player);

						break;
					} else {
						isWin = true;
						result = player;
						break;
					}

				}
			}
		}

	}

	/* Helps choose mopokens that are best suited in their cadre */
	private void chooseClosestLevel(Mopokens opponent, Mopokens player) {

		if (opponent.getLevel() < player.getLevel()) {
			if (player.getLevel() <= result.getLevel()) {
				result = player;
				isWin = true;
			} else if (opponent.getLevel() > player.getLevel()) {
				if (player.getLevel() > result.getLevel()) {
					result = player;
					isWin = true;
				}
			}
		}

	}

	/* Mopokens that holds advantage on type and levels compared to opponents */
	public void getTypeAdvantage(Mopokens opponent) {

		Map<String, Mopokens> mysquad = this.mySquad;
		for (Map.Entry<String, Mopokens> map : mysquad.entrySet()) {
			List<String> oppAdv = this.strength.getMopokenStrength().get(map.getKey());
			for (String s : oppAdv) {
				if (opponent.getName().equals(s)) {
					if (opponent.getLevel() < map.getValue().getLevel()
							|| opponent.getLevel() < (2 * map.getValue().getLevel())) {
						if (result != null) {
							chooseClosestLevel(opponent, map.getValue());
							break;
						} else {
							isWin = true;
							result = map.getValue();
							break;
						}
					}

				}
			}
		}

	}

	/* Mopokens that holds advantage only on levels compared to opponents */
	public void getLevelAdvantage(Mopokens opponent) {
		Map<String, Mopokens> mySquad = this.mySquad;
		for (Map.Entry<String, Mopokens> s : mySquad.entrySet()) {
			if (s.getValue().getLevel() > opponent.getLevel()) {
				if (result != null) {
					chooseClosestLevel(opponent, s.getValue());
					break;
				} else {
					isWin = true;
					result = s.getValue();
					break;
				}

			}
		}
	}

	/*
	 * mopokens that will result in draw as they do not hold advantage on any other
	 * mopokens
	 */
	public void makeDraw(Mopokens opponent) {
		Map<String, Mopokens> mySquad = this.mySquad;
		for (Map.Entry<String, Mopokens> s : mySquad.entrySet()) {

			if (s.getValue().getLevel() == opponent.getLevel()) {
				result = s.getValue();
				break;

			}
		}

	}

}

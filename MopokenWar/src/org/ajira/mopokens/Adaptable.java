package org.ajira.mopokens;

public interface Adaptable {
	public void getLevelAdvantage(Mopokens player);
	 public void makeDraw(Mopokens player);
	 public void getTypeAdvantage(Mopokens player);
	 public Mopokens match(Mopokens mopoken);
	 public void getWeakAdvantage(Mopokens opponent);
}

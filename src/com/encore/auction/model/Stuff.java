package com.encore.auction.model;

import java.util.HashMap;

public class Stuff {
	String name;
	int auctionno;
	
	public Stuff(String name, int auctionno) {
		this.name = name;
		this.auctionno = auctionno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAuctionno() {
		return auctionno;
	}
	public void setAuctionno(int auctionno) {
		this.auctionno = auctionno;
	}

	public HashMap<String, String> convertToHashMap() {
		HashMap<String, String> map = new HashMap<>();
//		map.put("name", name);
//		map.put("name", auctionno+"");
		return map;
	}
	public static Stuff converToStuff(HashMap<String, String> m) {
/*		return new Stuff(m.get("name"),
						 Integer.parseInt(m.get("age")));*/
		return null;
	}
}
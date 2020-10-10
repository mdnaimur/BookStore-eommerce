package com.mnr.bookstore.utiltiy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDConstants {

	public final static String BD = "BD";

	public final static Map<String, String> mapOfBDStates = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("DH", "Dhaka");
			put("RAJ", "Rajshahi");
			put("CTG", "Chittagon");
			put("SHY", "Sylhet");
			put("BRS", "Barishal");
			put("KHU", "Khulna");
			put("RBG", "Rangpur");

		}

	};
	public final static List<String> listOfBDStatesCode = new ArrayList<>(mapOfBDStates.keySet());
	public final static List<String> listOfBDStatesName = new ArrayList<>(mapOfBDStates.values());
}

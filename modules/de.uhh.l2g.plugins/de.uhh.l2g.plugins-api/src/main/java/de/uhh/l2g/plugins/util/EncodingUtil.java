package de.uhh.l2g.plugins.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodingUtil {

	public static String[] encodeStrings(String[] baseStrings) {
		String[] normalizedStrings = new String[baseStrings.length];
		for (int i = 0; i < baseStrings.length; i++) {
			normalizedStrings[i] = encodeString(baseStrings[i]);
		}
		return normalizedStrings;
	}

	public static String encodeString(String baseString) {
		try {
			return Base64.getEncoder().encodeToString(baseString.trim().getBytes(StandardCharsets.UTF_8.name()))
					.replace("=", "").replace("/", "").toLowerCase();
		} catch (UnsupportedEncodingException e) {
			// this will never happen
			return baseString;
		}
	}

}

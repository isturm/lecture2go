package de.uhh.l2g.plugins.util;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {

	public static long[] idListToArray(List<Long> ids) {
		long[] idsArray = new long[ids.size()];
		for (int i = 0; i < ids.size(); i++) {
			idsArray[i] = ids.get(i);
		}
		return idsArray;
	}

	public static ArrayList<Long> idArrayToList(long[] ids) {
		ArrayList<Long> idList = new ArrayList<>();
		for (long id : ids) {
			idList.add(id);
		}
		return idList;
	}

	public static long[] convertStringToIdArray(String inputString) {
		if (inputString.equals("") || inputString.equals("[]")) {
			return new long[0];
		}
		String idString = inputString.substring(1, inputString.length() - 1);
		String[] idStringArray = idString.split(",");
		long[] idArray = new long[idStringArray.length];
		for (int i = 0; i < idStringArray.length; i++) {
			idArray[i] = Long.parseLong(idStringArray[i].trim());
		}
		return idArray;
	}

	public static ArrayList<Long> convertStringToIdList(String inputString) {
		long[] idArray = convertStringToIdArray(inputString);
		return idArrayToList(idArray);
	}

}

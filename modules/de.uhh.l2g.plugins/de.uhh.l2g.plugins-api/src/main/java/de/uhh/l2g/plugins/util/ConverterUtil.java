package de.uhh.l2g.plugins.util;

import java.util.List;

public class ConverterUtil {

	public static long[] idListToArray(List<Long> ids) {
		long[] idsArray = new long[ids.size()];
		for (int i = 0; i < ids.size(); i++) {
			idsArray[i] = ids.get(i);
		}
		return idsArray;
	}

}

package de.uhh.l2g.plugins.admin.institutions.portlet.util;


import de.uhh.l2g.plugins.model.Institution;

public class InstitutionsComparatorBySortDesc implements java.util.Comparator<Institution> {

	@Override
	public int compare(Institution o1, Institution o2) {
		//
		int a = o1.getSort();
		int b = o2.getSort();
		//
		return a < b ? 1
		         : a > b ? -1
		         : 0;
	}

}

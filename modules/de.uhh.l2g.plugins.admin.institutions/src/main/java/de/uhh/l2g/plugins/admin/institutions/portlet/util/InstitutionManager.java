package de.uhh.l2g.plugins.admin.institutions.portlet.util;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

public class InstitutionManager {

	public static void reorderChildren(Institution inst) throws SystemException {
		List<Institution> subElements = InstitutionLocalServiceUtil.getByParentId(inst.getPrimaryKey());
		// There is nothing to reorder if number of children is smaller 1
		int startPos = 1;
		if (subElements.size() > 1) { // sort Elements newpos <= 1 => shift all
			List<Institution> subtree = InstitutionLocalServiceUtil.getByParentId(inst.getPrimaryKey());
			//
			int increment = 0;
			for (Institution subInstitution : subtree) {
				subInstitution.setSort(startPos + increment);
				InstitutionLocalServiceUtil.updateInstitution(subInstitution);
				increment++;
			}
		}
	}
	
	public static int updateSort(Institution institution, int newpos) throws SystemException {
		int validPosition = 0;
		int curPos = 1; 
		int oldPos = institution.getSort();
		if(newpos > oldPos)newpos++;
		
		List<Institution> subElements = InstitutionLocalServiceUtil.getByParentId(institution.getParentId());

		if (subElements.size() < 1){
			validPosition = 1; // There is nothing to reorder and only one valid
		} else { // sort Elements newpos <= 1 => shift all, newpos > max attach at back
			// delete (virtually append to end and shift all other down)
			int increment = 0;
			for (Institution subInstitution : subElements) {
				if (newpos <= curPos && increment == 0) { 
					// insert new Institution here
					if (newpos > 0) {
						validPosition = curPos;
						increment = 1; // shift all follwing up
					} else { // newpos = 0 <=> remove
						if (curPos > oldPos) increment = -1;
					}
				}
				subInstitution.setSort(curPos + increment);
				InstitutionLocalServiceUtil.updateInstitution(subInstitution);
				curPos++;
			}
			if (increment == 0) validPosition = curPos;
		}
		return validPosition;
	}

}

package de.uhh.l2g.plugins.admin.roles.util;

import java.util.List;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;

public class TextManager {

	public static String getRolesDescription(User user) {
		List<Role> roles = user.getRoles();
		String n = "";
		for (int i = 0; i < roles.size(); i++) {
			// check for l2g role
			String rn = roles.get(i).getName();
			if (rn.contains("L2Go Coordinator")) {
				long fId = new Long(0);
				try {
					fId = CoordinatorLocalServiceUtil.getCoordinator(user.getUserId()).getInstitutionId();
				} catch (Exception e) {
				}
				String fN = "";
				try {
					fN = InstitutionLocalServiceUtil.getInstitution(fId).getName();
					n += LanguageUtil.get(user.getLocale(), "coordinator-for ") + " " + fN + "<br/>";
				} catch (Exception e) {
				}
			}
			if (rn.contains("L2Go Producer")) {
				long fId = new Long(0);
				try {
					fId = ProducerLocalServiceUtil.getProducer(user.getUserId()).getInstitutionId();
				} catch (Exception e) {
				}
				String fN = "";
				try {
					fN = InstitutionLocalServiceUtil.getInstitution(fId).getName();
					n += LanguageUtil.get(user.getLocale(), "producer-for ") + fN + "<br/>";
				} catch (Exception e) {
				}
			}
			if (!rn.contains("L2Go Producer") && !rn.contains("L2Go Coordinator")) {
				n += rn + "<br/>";
			}
		}
		return n;
	}

}

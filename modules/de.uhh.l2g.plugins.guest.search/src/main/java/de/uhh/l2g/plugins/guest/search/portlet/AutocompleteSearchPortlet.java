package de.uhh.l2g.plugins.guest.search.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import de.uhh.l2g.plugins.guest.search.constants.AutocompleteSearchPortletKeys;
import de.uhh.l2g.plugins.util.SearchManager;

/**
 * @author isturm
 */

@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.display-category=lecture2go.plugins",
				"com.liferay.portlet.instanceable=true", 
				"javax.portlet.display-name=Autocomplete Search",
				"javax.portlet.init-param.template-path=/", 
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + AutocompleteSearchPortletKeys.AUTOCOMPLETE_SEARCH,
				"javax.portlet.security-role-ref=power-user,user" 
		}, 
		service = Portlet.class)
public class AutocompleteSearchPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AutocompleteSearchPortlet.class);

	@Reference
	protected SearchManager searchManager;

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// --- Autocomplete start
		// getting task name to do
		String task = ParamUtil.getString(resourceRequest, "task");
		if (Validator.isNull(task)) {
			return;
		}
		switch (task) {
		case "findVideos":
			// get writer for write data
			PrintWriter out = resourceResponse.getWriter();

			try {
				String searchText = ParamUtil.getString(resourceRequest, "searchText");
				int resultLimit = ParamUtil.getInteger(resourceRequest, "resultLimit");
				String elasticsearchResults = searchManager
						.getAutocompleteResultArrayBySearchWord(searchText, resultLimit).toString();
				out.println(elasticsearchResults);
			} catch (SearchException | ParseException e) {
				_log.error(e);
			}
			break;
		}
		// --- Autocomplete end
	}

}
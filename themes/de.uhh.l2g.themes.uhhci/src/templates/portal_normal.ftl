<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="pt-0" id="wrapper">
	<#if show_header>
		<header id="banner">
			<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search", "siteNavigationMenuType": "1", "displayDepth": "0"}) />
			<div class="navbar navbar-expand-lg">
				<#include "${full_templates_path}/header.ftl" />
			</div>
			<div class="align-items-baseline autofit-row container site-header">
				<a class="${logo_css_class} align-items-center d-md-inline-flex logo-md" href="${site_default_url}" title="<@liferay.language_format arguments="" key="go-to-x" />">
					<img alt="${logo_description}" class="mr-2" src="${site_logo}" />
				</a>

				<div class="autofit-col autofit-col-expand"></div>

				<#if show_site_name>
					<div class="autofit-col header-site-names">
						<a href="https://www.rrz.uni-hamburg.de">
							<b>${site_name}</b>
							<div class="site-description text-primary-color">${site_description}</div>
						</a>
					</div>
				</#if>
			</div>
			<div id="navigationDesktop" class="container">
				<@liferay.navigation_menu default_preferences="${preferences}" />
				<div id="desktopSearch" aria-controls="desktopSearchCollapse" aria-expanded="true" aria-label="Toggle search" data-target="#desktopSearchCollapse" data-toggle="collapse">
					<span></span>
				</div>
			</div>
			<div aria-expanded="false" class="autocompleteSearch collapse searchCollapse container" id="desktopSearchCollapse">
				<@liferay_portlet["runtime"]
			        portletProviderAction=portletProviderAction.VIEW
			        portletName="AutocompleteSearch"
			        instanceId="GlobalDesktopSearch"
				/>
			</div>
			<div class="sticky-margin"/>
		</header>
	</#if>

	<section class="${portal_content_css_class}" id="content">
		<h1 class="sr-only">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

	<#if show_footer>
		<footer id="footer" role="contentinfo">
			<div class="container">
				<ul>
		          <li><a class="feedback" href="/feedback.html?local_url=https%3A%2F%2Fwww.uni-hamburg.de%2Fde.html">Feedback</a></li>
		          <li><a class="impressum" href="/impressum.html">Impressum</a></li>
		          <li><a href="#">Datenschutzerklärung</a></li>
		        </ul>
			</div>
		</footer>
	</#if>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>
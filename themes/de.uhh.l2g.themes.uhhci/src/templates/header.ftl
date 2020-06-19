<#if has_navigation && is_setup_complete>
	<div id="navigation" class="bg-primary-color autofit-row">
		<div class="container">
			<div id="navigationTitle" class="autofit-col">
				<a href="/">Universität Hamburg</a>
			</div>
			<div class="autofit-col autofit-col-expand"></div>
			<div id="language" class="autofit-col text-right">
				<#assign languagePreferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone","displayStyle", "ddmTemplate_LANGUAGE-SHORT-TEXT-FTL"}) />
				<@liferay_portlet["runtime"]
			        defaultPreferences=languagePreferences
			        portletProviderAction=portletProviderAction.VIEW
			        portletProviderClassName="com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry"
				/>
			</div>
			<div id="search" aria-controls="mobileSearchCollapse" aria-expanded="true" aria-label="Toggle search" data-target="#mobileSearchCollapse" data-toggle="collapse">
				<span></span>
			</div>
			<div id="menu" aria-controls="navigationCollapse menuCover" aria-expanded="true" aria-label="Toggle navigation" data-target="#navigationCollapse, #menuCover" data-toggle="collapse">
				<span></span>
			</div>
		</div>
		<div aria-expanded="false" class="autocompleteSearch collapse searchCollapse" id="mobileSearchCollapse">
			<@liferay_portlet["runtime"]
		        portletProviderAction=portletProviderAction.VIEW
		        portletName="AutocompleteSearch"
		        instanceId="GlobalMobileSearch"
			/>
		</div>
		<div aria-expanded="false" class="navbar-collapse collapse" id="navigationCollapse">
			<div class="navbar-company">
				<a href="${site_default_url}">${site_name}</a>
			</div>
			<@liferay.navigation_menu default_preferences="${preferences}" />
		</div>
		<div id="menuCover" aria-expanded="false" class="collapse" id="menuCover"></div>
	</div>
</#if>
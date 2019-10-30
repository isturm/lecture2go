<#if has_navigation && is_setup_complete>
	<div id="navigation-mobile" class="bg-highlight-color autofit-row">
		<div class="autofit-col">
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
		<div id="search" class="autofit-col text-right">
			<span></span>
		</div>
		<div id="menu" aria-controls="navigationCollapse" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right" data-target="#navigationCollapse" data-toggle="collapse" type="button">
			<span></span>
		</div>
	
		<div aria-expanded="false" class="collapse navbar-collapse" id="navigationCollapse">
			<@liferay.navigation_menu default_preferences="${preferences}" />
		</div>
	</div>
</#if>
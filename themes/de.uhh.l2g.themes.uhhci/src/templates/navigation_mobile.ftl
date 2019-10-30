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
		<div id="search" aria-controls="searchCollapse" aria-expanded="true" aria-label="Toggle search" data-target="#searchCollapse" data-toggle="collapse">
			<span></span>
		</div>
		<div id="menu" aria-controls="navigationCollapse menuCover" aria-expanded="true" aria-label="Toggle navigation" data-target="#navigationCollapse, #menuCover" data-toggle="collapse">
			<span></span>
		</div>	
		<div aria-expanded="false" class="collapse" id="searchCollapse">
			<input name="q" type="text" placeholder="Universität Hamburg durchsuchen">
			<input type="submit" value="Suchen">
		</div>
		<div aria-expanded="false" class="navbar-collapse collapse" id="navigationCollapse">
			<@liferay.navigation_menu default_preferences="${preferences}" />
		</div>
		<div id="menuCover" aria-expanded="false" class="collapse" id="menuCover"/>
	</div>
</#if>
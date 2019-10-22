<#assign
	show_footer = true
	show_header = true
	show_header_search = true
	wrap_widget_page_content = true
/>

<#if wrap_widget_page_content && (layout.getType() == "portlet")>
	<#assign portal_content_css_class = "container mt-4" />
<#else>
	<#assign portal_content_css_class = "" />
</#if>
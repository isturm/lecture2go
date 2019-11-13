# UHH CI Theme
## Basic Structure

The theme has been created based on Liferay classic theme (see [Setting up Liferay 7.2 theme](https://portal.liferay.dev/docs/7-2/tutorials/-/knowledge_base/t/setting-up-the-theme) and [Extending Atlas with the Classic Theme](https://portal.liferay.dev/docs/7-1/tutorials/-/knowledge_base/t/importing-clay-css-into-a-theme#extending-atlas-with-the-classic-theme)). The structure has been kept for consistency and standardization reasons.

According to Liferay classic theme separate components (like navigation, breadcrumb or video catalog) are styled in their own SCSS files in [components CSS folder](themes/de.uhh.l2g.themes.uhhci/src/css/components). Responsive designs are placed inside the affected SCSS file of the component.

General stylings or stylings used in multiple components are placed in [custom.scss](themes/de.uhh.l2g.themes.uhhci/src/css/_custom.scss).

All imports are placed in [imports.scss](themes/de.uhh.l2g.themes.uhhci/src/css/_imports.scss).

All CI related variables are defined in [ci_variables.scss](themes/de.uhh.l2g.themes.uhhci/src/css/_ci_variables.scss). The stylings explained in the following sections may be controlled by these variables.

## Header
The header consists of a logo (the Liferay site logo), the site title and the site description. Site description is not shown in mobile design.

## Colors
All colors are centrally defined in [ci_variables.scss](themes/de.uhh.l2g.themes.uhhci/src/css/_ci_variables.scss). The most important ones are $primary-color (the primary color to be used according to your CI, e.g. used for button background or navigation bar), $secondary-color (the complementary color according to your CI, e.g. used for button text or backgrounds) and $font-color (used for every font).

The colors may be used directly as CSS classes on elements to colorize text or background, whereas text-{color} defines the text color and bg-{color} defines the background color (e.g. class="text-primary-color" or class="bg-secondary-color"). This is realized according to Liferay standards in [liferay_variables_custom.scss](themes/de.uhh.l2g.themes.uhhci/src/css/_liferay_variables_custom.scss).

You may color the bullets of an unordered list (ul) with the defined $signal-color by using CSS class "colored-bullets".

## Fonts
Fonts are placed in [fonts folder](themes/de.uhh.l2g.themes.uhhci/src/fonts) and defined in [fonts.scss](themes/de.uhh.l2g.themes.uhhci/src/css/components/_fonts.scss). Used fonts and sizes are defined in [ci_variables.scss](themes/de.uhh.l2g.themes.uhhci/src/css/_ci_variables.scss) like all CI related variables.
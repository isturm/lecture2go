package de.uhh.l2g.rest.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jonas Laacke
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/lecture2go",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=UHH.Lecture2Go"
	},
	service = Application.class
)
@Generated("")
public class Lecture2GoApplication extends Application {
}
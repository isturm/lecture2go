/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Producer service. Represents a row in the &quot;LG_Producer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see ProducerModel
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.ProducerImpl")
@ProviderType
public interface Producer extends PersistedModel, ProducerModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>de.uhh.l2g.plugins.model.impl.ProducerImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Producer, Long> PRODUCER_ID_ACCESSOR =
		new Accessor<Producer, Long>() {

			@Override
			public Long get(Producer producer) {
				return producer.getProducerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Producer> getTypeClass() {
				return Producer.class;
			}

		};

	public String getLastName();

	public void setLastName(String lastName);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getEmailAddress();

	public void setEmailAddress(String emailAddress);

	public java.util.Date getLastLoginDate();

	public void setLastLoginDate(java.util.Date lastLoginDate);

}
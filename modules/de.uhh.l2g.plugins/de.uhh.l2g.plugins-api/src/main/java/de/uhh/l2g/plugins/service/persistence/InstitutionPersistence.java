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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchInstitutionException;
import de.uhh.l2g.plugins.model.Institution;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see InstitutionUtil
 * @generated
 */
@ProviderType
public interface InstitutionPersistence extends BasePersistence<Institution> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstitutionUtil} to access the institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findByParent(long parentId);

	/**
	 * Returns a range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findByParent(
		long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByParent(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByParent(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByParent_First(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByParent_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByParent_Last(
			long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByParent_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where parentId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findByParent_PrevAndNext(
			long institutionId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	public void removeByParent(long parentId);

	/**
	 * Returns the number of institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching institutions
	 */
	public int countByParent(long parentId);

	/**
	 * Returns all the institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findByName(String name);

	/**
	 * Returns a range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findByName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where name = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findByName_PrevAndNext(
			long institutionId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByName(String name);

	/**
	 * Returns the number of institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching institutions
	 */
	public int countByName(String name);

	/**
	 * Returns all the institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findByTyp(String typ);

	/**
	 * Returns a range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findByTyp(
		String typ, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByTyp(
		String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByTyp(
		String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByTyp_First(
			String typ,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByTyp_First(
		String typ,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByTyp_Last(
			String typ,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByTyp_Last(
		String typ,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findByTyp_PrevAndNext(
			long institutionId, String typ,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 */
	public void removeByTyp(String typ);

	/**
	 * Returns the number of institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching institutions
	 */
	public int countByTyp(String typ);

	/**
	 * Returns all the institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findByWww(String www);

	/**
	 * Returns a range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findByWww(
		String www, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByWww(
		String www, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByWww(
		String www, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByWww_First(
			String www,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByWww_First(
		String www,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByWww_Last(
			String www,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByWww_Last(
		String www,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where www = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findByWww_PrevAndNext(
			long institutionId, String www,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where www = &#63; from the database.
	 *
	 * @param www the www
	 */
	public void removeByWww(String www);

	/**
	 * Returns the number of institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the number of matching institutions
	 */
	public int countByWww(String www);

	/**
	 * Returns all the institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findByLevel(int level);

	/**
	 * Returns a range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findByLevel(
		int level, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByLevel(
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByLevel(
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByLevel_First(
			int level,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByLevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByLevel_Last(
			int level,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByLevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findByLevel_PrevAndNext(
			long institutionId, int level,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where level = &#63; from the database.
	 *
	 * @param level the level
	 */
	public void removeByLevel(int level);

	/**
	 * Returns the number of institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the number of matching institutions
	 */
	public int countByLevel(int level);

	/**
	 * Returns all the institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findBySort(int sort);

	/**
	 * Returns a range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findBySort(int sort, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findBySort(
		int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findBySort(
		int sort, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findBySort_First(
			int sort,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchBySort_First(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findBySort_Last(
			int sort,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchBySort_Last(
		int sort,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where sort = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findBySort_PrevAndNext(
			long institutionId, int sort,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where sort = &#63; from the database.
	 *
	 * @param sort the sort
	 */
	public void removeBySort(int sort);

	/**
	 * Returns the number of institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the number of matching institutions
	 */
	public int countBySort(int sort);

	/**
	 * Returns all the institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the matching institutions
	 */
	public java.util.List<Institution> findByLevelAndType(
		int level, String typ);

	/**
	 * Returns a range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	public java.util.List<Institution> findByLevelAndType(
		int level, String typ, int start, int end);

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByLevelAndType(
		int level, String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	public java.util.List<Institution> findByLevelAndType(
		int level, String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByLevelAndType_First(
			int level, String typ,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByLevelAndType_First(
		int level, String typ,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	public Institution findByLevelAndType_Last(
			int level, String typ,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	public Institution fetchByLevelAndType_Last(
		int level, String typ,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution[] findByLevelAndType_PrevAndNext(
			long institutionId, int level, String typ,
			com.liferay.portal.kernel.util.OrderByComparator<Institution>
				orderByComparator)
		throws NoSuchInstitutionException;

	/**
	 * Removes all the institutions where level = &#63; and typ = &#63; from the database.
	 *
	 * @param level the level
	 * @param typ the typ
	 */
	public void removeByLevelAndType(int level, String typ);

	/**
	 * Returns the number of institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the number of matching institutions
	 */
	public int countByLevelAndType(int level, String typ);

	/**
	 * Caches the institution in the entity cache if it is enabled.
	 *
	 * @param institution the institution
	 */
	public void cacheResult(Institution institution);

	/**
	 * Caches the institutions in the entity cache if it is enabled.
	 *
	 * @param institutions the institutions
	 */
	public void cacheResult(java.util.List<Institution> institutions);

	/**
	 * Creates a new institution with the primary key. Does not add the institution to the database.
	 *
	 * @param institutionId the primary key for the new institution
	 * @return the new institution
	 */
	public Institution create(long institutionId);

	/**
	 * Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution that was removed
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution remove(long institutionId)
		throws NoSuchInstitutionException;

	public Institution updateImpl(Institution institution);

	/**
	 * Returns the institution with the primary key or throws a <code>NoSuchInstitutionException</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	public Institution findByPrimaryKey(long institutionId)
		throws NoSuchInstitutionException;

	/**
	 * Returns the institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution, or <code>null</code> if a institution with the primary key could not be found
	 */
	public Institution fetchByPrimaryKey(long institutionId);

	/**
	 * Returns all the institutions.
	 *
	 * @return the institutions
	 */
	public java.util.List<Institution> findAll();

	/**
	 * Returns a range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of institutions
	 */
	public java.util.List<Institution> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institutions
	 */
	public java.util.List<Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator);

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of institutions
	 */
	public java.util.List<Institution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Institution>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the institutions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of institutions.
	 *
	 * @return the number of institutions
	 */
	public int countAll();

}
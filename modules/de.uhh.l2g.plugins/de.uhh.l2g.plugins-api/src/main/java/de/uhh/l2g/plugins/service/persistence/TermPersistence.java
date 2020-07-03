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

import de.uhh.l2g.plugins.exception.NoSuchTermException;
import de.uhh.l2g.plugins.model.Term;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see TermUtil
 * @generated
 */
@ProviderType
public interface TermPersistence extends BasePersistence<Term> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TermUtil} to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the matching terms
	 */
	public java.util.List<Term> findByPrefix(String prefix);

	/**
	 * Returns a range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByPrefix(String prefix, int start, int end);

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByPrefix(
		String prefix, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByPrefix(
		String prefix, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByPrefix_First(
			String prefix,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByPrefix_First(
		String prefix,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByPrefix_Last(
			String prefix,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByPrefix_Last(
		String prefix,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByPrefix_PrevAndNext(
			long termId, String prefix,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where prefix = &#63; from the database.
	 *
	 * @param prefix the prefix
	 */
	public void removeByPrefix(String prefix);

	/**
	 * Returns the number of terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the number of matching terms
	 */
	public int countByPrefix(String prefix);

	/**
	 * Returns all the terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching terms
	 */
	public java.util.List<Term> findByYear(String year);

	/**
	 * Returns a range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByYear(String year, int start, int end);

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByYear(
		String year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByYear(
		String year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByYear_First(
			String year,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByYear_First(
		String year,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByYear_Last(
			String year,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByYear_Last(
		String year,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByYear_PrevAndNext(
			long termId, String year,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	public void removeByYear(String year);

	/**
	 * Returns the number of terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching terms
	 */
	public int countByYear(String year);

	/**
	 * Returns all the terms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByGroup(long groupId);

	/**
	 * Returns a range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByGroup(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByGroup_PrevAndNext(
			long termId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of terms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching terms
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the terms where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByCompany(long companyId);

	/**
	 * Returns a range of all the terms where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where companyId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByCompany_PrevAndNext(
			long termId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of terms where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching terms
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByGroupAndCompany_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByGroupAndCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByGroupAndCompany_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByGroupAndCompany_PrevAndNext(
			long termId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of terms where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching terms
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns all the terms where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @return the matching terms
	 */
	public java.util.List<Term> findByPrefixAndYear(String prefix, String year);

	/**
	 * Returns a range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByPrefixAndYear(
		String prefix, String year, int start, int end);

	/**
	 * Returns an ordered range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByPrefixAndYear(
		String prefix, String year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByPrefixAndYear(
		String prefix, String year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByPrefixAndYear_First(
			String prefix, String year,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByPrefixAndYear_First(
		String prefix, String year,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByPrefixAndYear_Last(
			String prefix, String year,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByPrefixAndYear_Last(
		String prefix, String year,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByPrefixAndYear_PrevAndNext(
			long termId, String prefix, String year,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where prefix = &#63; and year = &#63; from the database.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 */
	public void removeByPrefixAndYear(String prefix, String year);

	/**
	 * Returns the number of terms where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @return the number of matching terms
	 */
	public int countByPrefixAndYear(String prefix, String year);

	/**
	 * Caches the term in the entity cache if it is enabled.
	 *
	 * @param term the term
	 */
	public void cacheResult(Term term);

	/**
	 * Caches the terms in the entity cache if it is enabled.
	 *
	 * @param terms the terms
	 */
	public void cacheResult(java.util.List<Term> terms);

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	public Term create(long termId);

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term remove(long termId) throws NoSuchTermException;

	public Term updateImpl(Term term);

	/**
	 * Returns the term with the primary key or throws a <code>NoSuchTermException</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term findByPrimaryKey(long termId) throws NoSuchTermException;

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 */
	public Term fetchByPrimaryKey(long termId);

	/**
	 * Returns all the terms.
	 *
	 * @return the terms
	 */
	public java.util.List<Term> findAll();

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 */
	public java.util.List<Term> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terms
	 */
	public java.util.List<Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of terms
	 */
	public java.util.List<Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the terms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	public int countAll();

}
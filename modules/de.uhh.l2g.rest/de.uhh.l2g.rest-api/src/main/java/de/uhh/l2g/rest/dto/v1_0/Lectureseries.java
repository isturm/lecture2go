package de.uhh.l2g.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jonas Laacke
 * @generated
 */
@Generated("")
@GraphQLName("Lectureseries")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Lectureseries")
public class Lectureseries {

	@Schema
	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	@JsonIgnore
	public void setCategories(
		UnsafeSupplier<Category[], Exception> categoriesUnsafeSupplier) {

		try {
			categories = categoriesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Category[] categories;

	@Schema(description = "Closed access URI of the lectureseries.")
	public String getClosedAccessURI() {
		return closedAccessURI;
	}

	public void setClosedAccessURI(String closedAccessURI) {
		this.closedAccessURI = closedAccessURI;
	}

	@JsonIgnore
	public void setClosedAccessURI(
		UnsafeSupplier<String, Exception> closedAccessURIUnsafeSupplier) {

		try {
			closedAccessURI = closedAccessURIUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String closedAccessURI;

	@Schema
	public Creator[] getCreators() {
		return creators;
	}

	public void setCreators(Creator[] creators) {
		this.creators = creators;
	}

	@JsonIgnore
	public void setCreators(
		UnsafeSupplier<Creator[], Exception> creatorsUnsafeSupplier) {

		try {
			creators = creatorsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Creator[] creators;

	@Schema
	public Institution[] getInstitutions() {
		return institutions;
	}

	public void setInstitutions(Institution[] institutions) {
		this.institutions = institutions;
	}

	@JsonIgnore
	public void setInstitutions(
		UnsafeSupplier<Institution[], Exception> institutionsUnsafeSupplier) {

		try {
			institutions = institutionsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Institution[] institutions;

	@Schema(description = "Lectureseries ID of the lectureseries.")
	public Long getLectureseriesId() {
		return lectureseriesId;
	}

	public void setLectureseriesId(Long lectureseriesId) {
		this.lectureseriesId = lectureseriesId;
	}

	@JsonIgnore
	public void setLectureseriesId(
		UnsafeSupplier<Long, Exception> lectureseriesIdUnsafeSupplier) {

		try {
			lectureseriesId = lectureseriesIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long lectureseriesId;

	@Schema(description = "Long desc of the lectureseries.")
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	@JsonIgnore
	public void setLongDesc(
		UnsafeSupplier<String, Exception> longDescUnsafeSupplier) {

		try {
			longDesc = longDescUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String longDesc;

	@Schema(description = "Name of the lectureseries.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@Schema(description = "Number of the lectureseries.")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@JsonIgnore
	public void setNumber(
		UnsafeSupplier<String, Exception> numberUnsafeSupplier) {

		try {
			number = numberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String number;

	@Schema(description = "Open access URI of the lectureseries.")
	public String getOpenAccessURI() {
		return openAccessURI;
	}

	public void setOpenAccessURI(String openAccessURI) {
		this.openAccessURI = openAccessURI;
	}

	@JsonIgnore
	public void setOpenAccessURI(
		UnsafeSupplier<String, Exception> openAccessURIUnsafeSupplier) {

		try {
			openAccessURI = openAccessURIUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String openAccessURI;

	@Schema
	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	@JsonIgnore
	public void setTerm(UnsafeSupplier<Term, Exception> termUnsafeSupplier) {
		try {
			term = termUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Term term;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Lectureseries)) {
			return false;
		}

		Lectureseries lectureseries = (Lectureseries)object;

		return Objects.equals(toString(), lectureseries.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (categories != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0; i < categories.length; i++) {
				sb.append(String.valueOf(categories[i]));

				if ((i + 1) < categories.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (closedAccessURI != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"closedAccessURI\": ");

			sb.append("\"");

			sb.append(_escape(closedAccessURI));

			sb.append("\"");
		}

		if (creators != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creators\": ");

			sb.append("[");

			for (int i = 0; i < creators.length; i++) {
				sb.append(String.valueOf(creators[i]));

				if ((i + 1) < creators.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (institutions != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"institutions\": ");

			sb.append("[");

			for (int i = 0; i < institutions.length; i++) {
				sb.append(String.valueOf(institutions[i]));

				if ((i + 1) < institutions.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (lectureseriesId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lectureseriesId\": ");

			sb.append(lectureseriesId);
		}

		if (longDesc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longDesc\": ");

			sb.append("\"");

			sb.append(_escape(longDesc));

			sb.append("\"");
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (number != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"number\": ");

			sb.append("\"");

			sb.append(_escape(number));

			sb.append("\"");
		}

		if (openAccessURI != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"openAccessURI\": ");

			sb.append("\"");

			sb.append(_escape(openAccessURI));

			sb.append("\"");
		}

		if (term != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"term\": ");

			sb.append(String.valueOf(term));
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}
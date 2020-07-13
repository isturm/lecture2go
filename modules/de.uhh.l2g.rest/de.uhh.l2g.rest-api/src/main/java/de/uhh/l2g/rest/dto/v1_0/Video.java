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
@GraphQLName("Video")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Video")
public class Video {

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

	@Schema(description = "Container format of the video.")
	public String getContainerFormat() {
		return containerFormat;
	}

	public void setContainerFormat(String containerFormat) {
		this.containerFormat = containerFormat;
	}

	@JsonIgnore
	public void setContainerFormat(
		UnsafeSupplier<String, Exception> containerFormatUnsafeSupplier) {

		try {
			containerFormat = containerFormatUnsafeSupplier.get();
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
	protected String containerFormat;

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

	@Schema(description = "Download link of this video.")
	public Integer getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(Integer downloadLink) {
		this.downloadLink = downloadLink;
	}

	@JsonIgnore
	public void setDownloadLink(
		UnsafeSupplier<Integer, Exception> downloadLinkUnsafeSupplier) {

		try {
			downloadLink = downloadLinkUnsafeSupplier.get();
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
	protected Integer downloadLink;

	@Schema(description = "Duration of the video.")
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@JsonIgnore
	public void setDuration(
		UnsafeSupplier<String, Exception> durationUnsafeSupplier) {

		try {
			duration = durationUnsafeSupplier.get();
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
	protected String duration;

	@Schema(description = "Complete iframe embed code.")
	public String getEmbedIframe() {
		return embedIframe;
	}

	public void setEmbedIframe(String embedIframe) {
		this.embedIframe = embedIframe;
	}

	@JsonIgnore
	public void setEmbedIframe(
		UnsafeSupplier<String, Exception> embedIframeUnsafeSupplier) {

		try {
			embedIframe = embedIframeUnsafeSupplier.get();
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
	protected String embedIframe;

	@Schema(description = "Generation date of the video.")
	public String getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}

	@JsonIgnore
	public void setGenerationDate(
		UnsafeSupplier<String, Exception> generationDateUnsafeSupplier) {

		try {
			generationDate = generationDateUnsafeSupplier.get();
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
	protected String generationDate;

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

	@Schema
	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	@JsonIgnore
	public void setLicense(
		UnsafeSupplier<License, Exception> licenseUnsafeSupplier) {

		try {
			license = licenseUnsafeSupplier.get();
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
	protected License license;

	@Schema
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	@JsonIgnore
	public void setMetadata(
		UnsafeSupplier<Metadata, Exception> metadataUnsafeSupplier) {

		try {
			metadata = metadataUnsafeSupplier.get();
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
	protected Metadata metadata;

	@Schema(description = "Open access of this video.")
	public Integer getOpenAccess() {
		return openAccess;
	}

	public void setOpenAccess(Integer openAccess) {
		this.openAccess = openAccess;
	}

	@JsonIgnore
	public void setOpenAccess(
		UnsafeSupplier<Integer, Exception> openAccessUnsafeSupplier) {

		try {
			openAccess = openAccessUnsafeSupplier.get();
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
	protected Integer openAccess;

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

	@Schema(description = "Title of the video.")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
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
	protected String title;

	@Schema(description = "Complete URL to the open access video.")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonIgnore
	public void setUrl(UnsafeSupplier<String, Exception> urlUnsafeSupplier) {
		try {
			url = urlUnsafeSupplier.get();
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
	protected String url;

	@Schema(description = "Video ID of the video.")
	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	@JsonIgnore
	public void setVideoId(
		UnsafeSupplier<Long, Exception> videoIdUnsafeSupplier) {

		try {
			videoId = videoIdUnsafeSupplier.get();
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
	protected Long videoId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Video)) {
			return false;
		}

		Video video = (Video)object;

		return Objects.equals(toString(), video.toString());
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

		if (containerFormat != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"containerFormat\": ");

			sb.append("\"");

			sb.append(_escape(containerFormat));

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

		if (downloadLink != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"downloadLink\": ");

			sb.append(downloadLink);
		}

		if (duration != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"duration\": ");

			sb.append("\"");

			sb.append(_escape(duration));

			sb.append("\"");
		}

		if (embedIframe != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"embedIframe\": ");

			sb.append("\"");

			sb.append(_escape(embedIframe));

			sb.append("\"");
		}

		if (generationDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"generationDate\": ");

			sb.append("\"");

			sb.append(_escape(generationDate));

			sb.append("\"");
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

		if (license != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"license\": ");

			sb.append(String.valueOf(license));
		}

		if (metadata != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"metadata\": ");

			sb.append(String.valueOf(metadata));
		}

		if (openAccess != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"openAccess\": ");

			sb.append(openAccess);
		}

		if (term != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"term\": ");

			sb.append(String.valueOf(term));
		}

		if (title != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(title));

			sb.append("\"");
		}

		if (url != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"url\": ");

			sb.append("\"");

			sb.append(_escape(url));

			sb.append("\"");
		}

		if (videoId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"videoId\": ");

			sb.append(videoId);
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
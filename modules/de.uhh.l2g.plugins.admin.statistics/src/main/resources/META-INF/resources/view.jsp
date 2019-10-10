<%@include file="init.jsp"%>

<jsp:useBean id="totalVideos" type="java.lang.String" scope="request" />
<jsp:useBean id="totalPublic" type="java.lang.String" scope="request" />
<jsp:useBean id="totalPrivate" type="java.lang.String" scope="request" />

<jsp:useBean id="totalYesterday" type="java.lang.String" scope="request" />
<jsp:useBean id="totalYesterdayPublic" type="java.lang.String" scope="request" />
<jsp:useBean id="totalYesterdayPrivate" type="java.lang.String" scope="request" />

<jsp:useBean id="totalOneWeek" type="java.lang.String" scope="request" />
<jsp:useBean id="totalOneWeekPublic" type="java.lang.String" scope="request" />
<jsp:useBean id="totalOneWeekPrivate" type="java.lang.String" scope="request" />

<jsp:useBean id="totalOneMonth" type="java.lang.String" scope="request" />
<jsp:useBean id="totalOneMonthPublic" type="java.lang.String" scope="request" />
<jsp:useBean id="totalOneMonthPrivate" type="java.lang.String" scope="request" />

<jsp:useBean id="totalOneYear" type="java.lang.String" scope="request" />
<jsp:useBean id="totalOneYearPublic" type="java.lang.String" scope="request" />
<jsp:useBean id="totalOneYearPrivate" type="java.lang.String" scope="request" />


<label class="edit-video-lable"><liferay-ui:message key="video-statistic" /></label>

<style>
table, th, td {
  border: 1px solid black;
}
</style>

<aui:fieldset column="false">
	<div>
		<table>
			<tr>
				<th>
					<liferay-ui:message key="timespan" />
				</th>
				<th>
					<liferay-ui:message key="total" />
				</th>
				<th>
					<liferay-ui:message key="public" />
				</th>
				<th>
					<liferay-ui:message key="private" />
				</th>
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="total" />
				</td>
				<td>${totalVideos}</td>
				<td>${totalPublic}</td>
				<td>${totalPrivate}</td>
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="since-yesterday" />
				</td>
				<td>${totalYesterday}</td>
				<td>${totalYesterdayPublic}</td>
				<td>${totalYesterdayPrivate}</td>
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="since-week" />
				</td>
				<td>${totalOneWeek}</td>
				<td>${totalOneWeekPublic}</td>
				<td>${totalOneWeekPrivate}</td>
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="since-month" />
				</td>
				<td>${totalOneMonth}</td>
				<td>${totalOneMonthPublic}</td>
				<td>${totalOneMonthPrivate}</td>
			</tr>
			<tr>
				<td>
					<liferay-ui:message key="since-year" />
				</td>
				<td>${totalOneYear}</td>
				<td>${totalOneYearPublic}</td>
				<td>${totalOneYearPrivate}</td>
			</tr>
		</table>
	</div>
</aui:fieldset>
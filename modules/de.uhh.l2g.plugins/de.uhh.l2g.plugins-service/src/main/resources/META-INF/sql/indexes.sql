create index IX_CE65480 on LG_Category (companyId);
create index IX_D76873E6 on LG_Category (groupId, companyId);
create index IX_8FA32867 on LG_Category (name[$COLUMN_LENGTH:75$]);

create index IX_293C39D6 on LG_Coordinator (companyId);
create index IX_8D902F50 on LG_Coordinator (groupId, companyId);
create index IX_4EE19791 on LG_Coordinator (institutionId);
create index IX_8439EBD on LG_Coordinator (officeId);

create index IX_FC88C05A on LG_Creator (companyId);
create index IX_D3B1627D on LG_Creator (firstName[$COLUMN_LENGTH:75$]);
create index IX_E933BBBC on LG_Creator (fullName[$COLUMN_LENGTH:75$]);
create index IX_16D8BD4C on LG_Creator (groupId, companyId);
create index IX_8BEDCA83 on LG_Creator (lastName[$COLUMN_LENGTH:75$]);
create index IX_2CE50242 on LG_Creator (middleName[$COLUMN_LENGTH:75$]);

create index IX_24BB7F54 on LG_Host (companyId, groupId);
create index IX_5EDC310 on LG_Host (groupId, companyId);
create index IX_35EC15AF on LG_Host (groupId, hostId);

create unique index IX_7142401C on LG_Institution (companyId, groupId);
create index IX_527483D8 on LG_Institution (groupId, companyId);
create index IX_2F011093 on LG_Institution (groupId, institutionId);
create index IX_4CF38EBB on LG_Institution (groupId, parentId, sort);
create index IX_982D2D90 on LG_Institution (level, groupId);
create index IX_63B03BE9 on LG_Institution (level, typ[$COLUMN_LENGTH:75$], groupId);
create index IX_755E10F1 on LG_Institution (name[$COLUMN_LENGTH:75$], groupId);
create index IX_229A2635 on LG_Institution (parentId, companyId, groupId);
create index IX_ACBFFBFE on LG_Institution (sort, groupId);
create index IX_8BEF7329 on LG_Institution (typ[$COLUMN_LENGTH:75$], groupId);
create index IX_8A5E489D on LG_Institution (www[$COLUMN_LENGTH:75$], groupId);

create index IX_340684F2 on LG_Institution_Host (companyId, groupId, hostId);
create index IX_9BE16328 on LG_Institution_Host (companyId, groupId, institutionId);
create index IX_F9E381C6 on LG_Institution_Host (companyId, hostId);
create index IX_4EF42608 on LG_Institution_Host (groupId, hostId);

create index IX_F8346D23 on LG_Lastvideolist (companyId);
create index IX_313862A3 on LG_Lastvideolist (groupId, companyId);
create index IX_7503A061 on LG_Lastvideolist (videoId);

create index IX_B01349C4 on LG_Lectureseries (USID[$COLUMN_LENGTH:75$]);
create index IX_8CD13042 on LG_Lectureseries (approved);
create index IX_A3002D84 on LG_Lectureseries (categoryId);
create index IX_C5158EB1 on LG_Lectureseries (companyId);
create index IX_EBC55E2D on LG_Lectureseries (eventType[$COLUMN_LENGTH:75$]);
create index IX_F43BC8 on LG_Lectureseries (facultyName[$COLUMN_LENGTH:75$]);
create index IX_49C920D5 on LG_Lectureseries (groupId, companyId);
create index IX_4F65B8A3 on LG_Lectureseries (language[$COLUMN_LENGTH:75$]);
create index IX_714473BA on LG_Lectureseries (latestOpenAccessVideoId);
create index IX_7DCCF0F3 on LG_Lectureseries (latestVideoGenerationDate[$COLUMN_LENGTH:75$]);
create index IX_31FBA89C on LG_Lectureseries (latestVideoUploadDate);
create index IX_DB929396 on LG_Lectureseries (name[$COLUMN_LENGTH:75$]);
create index IX_225A0AF on LG_Lectureseries (number_[$COLUMN_LENGTH:75$]);
create index IX_3714125D on LG_Lectureseries (password_[$COLUMN_LENGTH:75$]);
create index IX_8D242272 on LG_Lectureseries (termId);

create index IX_8EBBBC1 on LG_Lectureseries_Category (categoryId, lectureseriesId);
create index IX_E459C00E on LG_Lectureseries_Category (lectureseriesId);

create index IX_60A5A33 on LG_Lectureseries_Creator (creatorId);
create index IX_3D4C3B5B on LG_Lectureseries_Creator (lectureseriesId, creatorId);

create index IX_719B09B3 on LG_Lectureseries_Institution (institutionId);
create index IX_A6D66CFD on LG_Lectureseries_Institution (institutionParentId);
create index IX_4B074373 on LG_Lectureseries_Institution (lectureseriesId, institutionId);

create index IX_A6E366AD on LG_License (selectable);

create index IX_5613EDEF on LG_Metadata (companyId);
create index IX_614F0757 on LG_Metadata (groupId, companyId);

create index IX_978F6E82 on LG_Office (companyId);
create index IX_98EF7C24 on LG_Office (groupId, companyId);
create index IX_41F2963D on LG_Office (institutionId);

create index IX_4FD6C927 on LG_Producer (approved);
create index IX_62C3126C on LG_Producer (companyId);
create index IX_C5449F7A on LG_Producer (groupId, companyId);
create index IX_7DAEE222 on LG_Producer (homeDir[$COLUMN_LENGTH:75$]);
create index IX_FE9C63D3 on LG_Producer (hostId);
create index IX_4115449F on LG_Producer (idNum[$COLUMN_LENGTH:75$]);
create index IX_417E3527 on LG_Producer (institutionId);

create index IX_2BD4E3CF on LG_Producer_Lectureseries (lectureseriesId, producerId);
create index IX_C19D6C13 on LG_Producer_Lectureseries (producerId);

create index IX_DA516D4F on LG_ScheduledThread (companyId);
create index IX_5C5AD3F7 on LG_ScheduledThread (groupId, companyId);
create index IX_8B8A96D5 on LG_ScheduledThread (schedulerClassName[$COLUMN_LENGTH:75$]);

create index IX_886D84B3 on LG_Segment (companyId);
create index IX_D398CD13 on LG_Segment (groupId, companyId);
create index IX_BC659B8F on LG_Segment (userId);
create index IX_CBD5BF1 on LG_Segment (videoId);

create index IX_EBBE8972 on LG_Statistic (companyId, groupId, createDate);
create index IX_98BD13C7 on LG_Statistic (companyId, groupId, statisticId);
create index IX_C65DEC70 on LG_Statistic (groupId, companyId);
create index IX_CD004109 on LG_Statistic (statisticId);

create index IX_1F5F1C3 on LG_Tagcloud (companyId);
create index IX_1CD21203 on LG_Tagcloud (groupId, companyId);
create index IX_6D2C99CC on LG_Tagcloud (objectClassType[$COLUMN_LENGTH:75$], objectId);
create index IX_385A2033 on LG_Tagcloud (objectId);

create index IX_4BAD3DD2 on LG_Term (companyId);
create index IX_EEDDE6D4 on LG_Term (groupId, companyId);
create index IX_A731640D on LG_Term (prefix[$COLUMN_LENGTH:75$], year[$COLUMN_LENGTH:75$]);
create index IX_16F89D07 on LG_Term (year[$COLUMN_LENGTH:75$]);

create index IX_D1B2A998 on LG_Video (filename[$COLUMN_LENGTH:75$]);
create index IX_AAE2F865 on LG_Video (lectureseriesId, openAccess);
create index IX_C9D1732F on LG_Video (licenseId);
create index IX_25DDBE5F on LG_Video (openAccess);
create index IX_43B83117 on LG_Video (password_[$COLUMN_LENGTH:75$]);
create index IX_2B61D434 on LG_Video (producerId, downloadLink);
create index IX_99A86BC2 on LG_Video (producerId, lectureseriesId);
create index IX_55AEC6E4 on LG_Video (rootInstitutionId);
create index IX_74110DF8 on LG_Video (termId);
create index IX_923BA320 on LG_Video (uploadDate);

create index IX_B85A8AC9 on LG_VideoStatistic (companyId);
create index IX_F5423FBD on LG_VideoStatistic (groupId, companyId);

create index IX_793FA2F9 on LG_Video_Category (categoryId);
create index IX_D3CF6407 on LG_Video_Category (videoId, categoryId);

create index IX_ED691EED on LG_Video_Creator (creatorId);
create index IX_F68D221B on LG_Video_Creator (videoId, creatorId);

create index IX_39AE746D on LG_Video_Institution (institutionId);
create index IX_98796437 on LG_Video_Institution (institutionParentId);
create index IX_B5AE333 on LG_Video_Institution (videoId, institutionId);

create index IX_544FF28F on LG_Video_Lectureseries (lectureseriesId, openAccess);
create index IX_2833C2F5 on LG_Video_Lectureseries (openAccess);
create index IX_F35885D3 on LG_Video_Lectureseries (videoId);

create index IX_B9B84A8 on LG_Videohitlist (companyId);
create index IX_8502F0BE on LG_Videohitlist (groupId, companyId);
create index IX_BBE4D526 on LG_Videohitlist (videoId);
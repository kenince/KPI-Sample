alter table KPISAMPLE_ACHIEVEMENT add constraint FK_KPISAMPLE_ACHIEVEMENT_ON_KPI foreign key (KPI_ID) references KPISAMPLE_KPI(ID);
create index IDX_KPISAMPLE_ACHIEVEMENT_ON_KPI on KPISAMPLE_ACHIEVEMENT (KPI_ID);
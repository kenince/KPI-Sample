alter table KPISAMPLE_TASK add constraint FK_KPISAMPLE_TASK_ON_KPI foreign key (KPI_ID) references KPISAMPLE_KPI(ID);
create index IDX_KPISAMPLE_TASK_ON_KPI on KPISAMPLE_TASK (KPI_ID);

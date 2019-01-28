create table KPISAMPLE_KPI (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    KPI varchar(255),
    BASELINE double precision,
    TARGET double precision,
    TOTAL_ACHIEVEMENT double precision,
    --
    primary key (ID)
);

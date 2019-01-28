-- begin KPISAMPLE_KPI
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
)^
-- end KPISAMPLE_KPI
-- begin KPISAMPLE_ACHIEVEMENT
create table KPISAMPLE_ACHIEVEMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ACHIEVEMENT double precision,
    ACHIEVEMENT_DATE date,
    KPI_ID varchar(36),
    TASK_ID varchar(36),
    --
    primary key (ID)
)^
-- end KPISAMPLE_ACHIEVEMENT
-- begin KPISAMPLE_TASK
create table KPISAMPLE_TASK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TASK_NAME varchar(255),
    TASK_TARGET double precision,
    TASK_ACHIEVEMENT double precision,
    KPI_ID varchar(36),
    KPI_TARGET double precision,
    KPI_ACHIEVEMENT double precision,
    --
    primary key (ID)
)^
-- end KPISAMPLE_TASK

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
    --
    primary key (ID)
);

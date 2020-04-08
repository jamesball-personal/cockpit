ALTER TABLE project
    CHANGE COLUMN id
        id BIGINT NOT NULL AUTO_INCREMENT,
    ADD CONSTRAINT project__pk__id
        PRIMARY KEY (id);
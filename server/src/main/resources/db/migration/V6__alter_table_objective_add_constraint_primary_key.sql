ALTER TABLE objective
    CHANGE COLUMN id
        id BIGINT NOT NULL AUTO_INCREMENT,
    ADD CONSTRAINT objective__pk__id
        PRIMARY KEY (id);
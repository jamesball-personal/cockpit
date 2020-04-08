ALTER TABLE plan_item
    CHANGE COLUMN id
        id BIGINT NOT NULL AUTO_INCREMENT,
    ADD CONSTRAINT plan_item__pk__id
        PRIMARY KEY (id);
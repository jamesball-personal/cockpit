ALTER TABLE metric
    CHANGE COLUMN id
        id BIGINT NOT NULL AUTO_INCREMENT,
    ADD CONSTRAINT metric__pk__id
        PRIMARY KEY (id);
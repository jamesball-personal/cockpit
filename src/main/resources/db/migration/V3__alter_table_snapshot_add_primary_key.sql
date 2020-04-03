ALTER TABLE data_warehouse.snapshot
    CHANGE COLUMN id id BIGINT NOT NULL AUTO_INCREMENT,
    ADD CONSTRAINT snapshot_pk_id PRIMARY KEY (id);
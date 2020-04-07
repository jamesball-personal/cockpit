CREATE TABLE project (
    snapshot_id BIGINT NOT NULL,
    id BIGINT NOT NULL,
    actual_percentage_complete DOUBLE DEFAULT NULL,
    target_percentage_complete DOUBLE DEFAULT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
ROW_FORMAT = DYNAMIC;
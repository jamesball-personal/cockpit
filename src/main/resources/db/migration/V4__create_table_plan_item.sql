CREATE TABLE plan_item (
    snapshot_id BIGINT NOT NULL,
    id BIGINT NOT NULL,
    owner_personnel_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT DEFAULT NULL,
    lifecycle_status BIGINT NOT NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
ROW_FORMAT = DYNAMIC;
CREATE TABLE data_warehouse.snapshot (
    id BIGINT NOT NULL,
    date DATE NOT NULL,
    execution_started_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    execution_ended_at TIMESTAMP DEFAULT NULL,
    execution_time_in_seconds INT GENERATED ALWAYS AS (TIMESTAMPDIFF(SECOND, execution_started_at, execution_ended_at)) NULL,
    is_latest_completed_snapshot BIT(1) NOT NULL DEFAULT 0b0,
    execution_status BIGINT NOT NULL DEFAULT 0x1784
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
ROW_FORMAT = DYNAMIC;
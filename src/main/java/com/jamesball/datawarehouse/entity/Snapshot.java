package com.jamesball.datawarehouse.entity;

import com.jamesball.datawarehouse.enumeration.ExecutionStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Snapshot")
@Table(name = "snapshot")
public class Snapshot {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "execution_started_at")
    private String executionStartedAt;

    @Column(name = "execution_ended_at")
    private String executionEndedAt;

    @Column(name = "is_latest_completed_snapshot", nullable = false)
    private Boolean isLatestCompletedSnapshot;

    @Column(name = "execution_status", nullable = false)
    private ExecutionStatus executionStatus;

    public Snapshot() {
    }

    public Snapshot(
            Long id,
            String date,
            String executionStartedAt,
            String executionEndedAt,
            Boolean isLatestCompletedSnapshot,
            ExecutionStatus executionStatus
    ) {
        this.id = id;
        this.date = date;
        this.executionStartedAt = executionStartedAt;
        this.executionEndedAt = executionEndedAt;
        this.isLatestCompletedSnapshot = isLatestCompletedSnapshot;
        this.executionStatus = executionStatus;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getExecutionStartedAt() {
        return executionStartedAt;
    }

    public String getExecutionEndedAt() {
        return executionEndedAt;
    }

    public Boolean getIsLatestCompletedStatus() {
        return isLatestCompletedSnapshot;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }
}

ALTER TABLE plan_item
    ADD CONSTRAINT plan_item__fk__life_cycle_status
        FOREIGN KEY (life_cycle_status) REFERENCES life_cycle_status (id);
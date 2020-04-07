ALTER TABLE metric
    ADD CONSTRAINT metric__fk__id
        FOREIGN KEY (id) REFERENCES plan_item (id);
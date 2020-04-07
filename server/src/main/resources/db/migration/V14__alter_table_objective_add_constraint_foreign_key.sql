ALTER TABLE objective
    ADD CONSTRAINT objective__fk__id
        FOREIGN KEY (id) REFERENCES plan_item (id);
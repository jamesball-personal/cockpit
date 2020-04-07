ALTER TABLE project
    ADD CONSTRAINT project__fk__id
        FOREIGN KEY (id) REFERENCES plan_item (id);
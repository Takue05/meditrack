CREATE TABLE user
(
    user_id       VARCHAR(255) NOT NULL,
    username      VARCHAR(255) NULL,
    password_hash VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    `role`        VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE report
(
    report_id   VARCHAR(255) NOT NULL,
    report_type VARCHAR(255) NULL,
    generate_at datetime     NULL,
    CONSTRAINT pk_report PRIMARY KEY (report_id)
);

CREATE TABLE manager
(
    user_id     VARCHAR(255) NOT NULL,
    auth_number VARCHAR(255) NULL,
    CONSTRAINT pk_manager PRIMARY KEY (user_id)
);

CREATE TABLE manager_reports
(
    manager_id VARCHAR(255) NOT NULL,
    report_id  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_manager_reports PRIMARY KEY (manager_id, report_id)
);

ALTER TABLE manager
    ADD CONSTRAINT FK_MANAGER_ON_USERID FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE manager_reports
    ADD CONSTRAINT fk_manrep_on_manager FOREIGN KEY (manager_id) REFERENCES manager (user_id);

ALTER TABLE manager_reports
    ADD CONSTRAINT fk_manrep_on_report FOREIGN KEY (report_id) REFERENCES report (report_id);

CREATE TABLE medicine
(
    medicine_id  VARCHAR(255) NOT NULL,
    product_code VARCHAR(255) NULL,
    product_name VARCHAR(255) NULL,
    mrp          DOUBLE       NOT NULL,
    expiry_date  date         NULL,
    quantity     INT          NOT NULL,
    CONSTRAINT pk_medicine PRIMARY KEY (medicine_id)
);

CREATE TABLE customer
(
    customer_id VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NULL,
    age         INT          NOT NULL,
    sex         VARCHAR(255) NULL,
    problem     VARCHAR(255) NULL,
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE sale
(
    sale_id       VARCHAR(255) NOT NULL,
    user_id       VARCHAR(255) NULL,
    customer_id   VARCHAR(255) NULL,
    quantity_sold INT          NOT NULL,
    total_price   DOUBLE       NOT NULL,
    sale_date     datetime     NULL,
    CONSTRAINT pk_sale PRIMARY KEY (sale_id)
);

CREATE TABLE sale_medicines
(
    medicine_id VARCHAR(255) NOT NULL,
    sale_id     VARCHAR(255) NOT NULL
);

ALTER TABLE sale
    ADD CONSTRAINT FK_SALE_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id);

ALTER TABLE sale
    ADD CONSTRAINT FK_SALE_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE sale_medicines
    ADD CONSTRAINT fk_salmed_on_medicine FOREIGN KEY (medicine_id) REFERENCES medicine (medicine_id);

ALTER TABLE sale_medicines
    ADD CONSTRAINT fk_salmed_on_sale FOREIGN KEY (sale_id) REFERENCES sale (sale_id);
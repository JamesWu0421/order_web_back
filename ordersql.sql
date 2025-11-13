-- CREATE DATABASE order_web; --
USE order_web;
CREATE TABLE orders (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL,
    show_id INT NOT NULL,
    order_status VARCHAR(20),
    order_time DATETIME,
    total_amount INT,
    modified_at DATETIME,
--    FOREIGN KEY (user_id) REFERENCES users(id),
--    FOREIGN KEY (show_id) REFERENCES shows(id)
);

-- 建立 order_details 資料表
CREATE TABLE order_details (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    seat_id INT NOT NULL,
    ticket_price INT,
    ticket_type VARCHAR(20),
    status VARCHAR(20),
    FOREIGN KEY (order_id) REFERENCES orders(id),
--    FOREIGN KEY (seat_id) REFERENCES seats(id)
);

-- 建立 refunds 資料表
CREATE TABLE refunds (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    refund_reason TEXT,
    refund_status VARCHAR(20),
    requested_at DATETIME,
    processed_at DATETIME,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

-- 建立 refund_details 資料表
CREATE TABLE refund_details (
    id INT IDENTITY(1,1) PRIMARY KEY,
    refund_id INT NOT NULL,
    order_detail_id INT NOT NULL,
    refund_amount INT,
    status VARCHAR(20),
    processed_at DATETIME,
    FOREIGN KEY (refund_id) REFERENCES refunds(id),
    FOREIGN KEY (order_detail_id) REFERENCES order_details(id)
);

-- 建立 customer_service_tickets 資料表
CREATE TABLE customer_service_tickets (
    id INT IDENTITY(1,1) PRIMARY KEY,
    order_id INT NOT NULL,
    issue_type VARCHAR(20),
    description TEXT,
    status VARCHAR(20),
    created_at DATETIME,
    updated_at DATETIME,
    handled_by INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
--    FOREIGN KEY (handled_by) REFERENCES employees(id)
);


SELECT * FROM orders;

SELECT * FROM order_details;
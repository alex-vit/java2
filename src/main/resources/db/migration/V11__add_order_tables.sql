CREATE TABLE orders (
  id            BIGINT(11)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  person        VARCHAR(255) NOT NULL,
  document      VARCHAR(255) NOT NULL,
  address       VARCHAR(255) NOT NULL,
  phone         VARCHAR(50)  NOT NULL,
  order_date    DATE         NOT NULL,
  delivery_date DATE         NOT NULL,
  total         BIGINT       NOT NULL,
  user_id       BIGINT(11)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

CREATE TABLE order_lines (
  id          BIGINT(11)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  order_id    BIGINT(11),
  product_id  BIGINT(11),
  name        VARCHAR(255) NOT NULL,
  description VARCHAR(1024),
  price       BIGINT       NOT NULL DEFAULT 0,
  quantity    BIGINT       NOT NULL DEFAULT 0,
  expire_date DATE         NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE order_lines
  ADD CONSTRAINT order_of_order_line FOREIGN KEY (order_id) REFERENCES orders (id)
  ON DELETE CASCADE;

ALTER TABLE order_lines
  ADD CONSTRAINT product_of_order_line FOREIGN KEY (product_id) REFERENCES products (id)
  ON DELETE CASCADE;







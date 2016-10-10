CREATE TABLE stock (
  id          BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  quantity    INT(11)    NOT NULL,
  expire_date DATE       NOT NULL,
  product_id  BIGINT(11) NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE stock
  ADD CONSTRAINT product_of_stock FOREIGN KEY (product_id) REFERENCES products (id)
  ON DELETE CASCADE;
CREATE TABLE rate (
  id         BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id    BIGINT(11) NOT NULL,
  product_id BIGINT(11) NOT NULL,
  rate       INT
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE rate
  ADD CONSTRAINT product_of_rate FOREIGN KEY (product_id) REFERENCES products (id)
  ON DELETE CASCADE;

ALTER TABLE rate
  ADD CONSTRAINT user_of_rate FOREIGN KEY (user_id) REFERENCES users (id);
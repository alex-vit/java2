CREATE TABLE reviews (
  id         BIGINT(11)    NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id    BIGINT(11)    NOT NULL,
  product_id BIGINT(11)    NOT NULL,
  review     VARCHAR(1024) NOT NULL,
  user_name  VARCHAR(45)   NOT NULL,
  date       DATE          NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE reviews
  ADD CONSTRAINT product_of_review FOREIGN KEY (product_id) REFERENCES products (id)
  ON DELETE CASCADE;

ALTER TABLE reviews
  ADD CONSTRAINT user_of_review FOREIGN KEY (user_id) REFERENCES users (id);


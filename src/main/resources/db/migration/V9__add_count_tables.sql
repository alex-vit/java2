CREATE TABLE visitors_counter (
  id         BIGINT(11)  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ip         VARCHAR(30) NOT NULL,
  product_id BIGINT(11),
  counter    INT         NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE visitors_counter
  ADD CONSTRAINT product_of_visitors_visitor FOREIGN KEY (product_id) REFERENCES products (id)
  ON DELETE SET NULL;

CREATE TABLE users_counter (
  id         BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id    BIGINT(11),
  product_id BIGINT(11),
  counter    INT        NOT NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1;

ALTER TABLE users_counter
  ADD CONSTRAINT user_of_user_visit FOREIGN KEY (user_id) REFERENCES users (id)
  ON DELETE CASCADE;

ALTER TABLE users_counter
  ADD CONSTRAINT product_of_user_visit FOREIGN KEY (product_id) REFERENCES products (id)
  ON DELETE SET NULL;
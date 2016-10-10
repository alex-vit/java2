ALTER TABLE users_counter
  DROP FOREIGN KEY product_of_user_visit;
ALTER TABLE users_counter
  ADD CONSTRAINT product_of_user_visit
FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;

ALTER TABLE visitors_counter
  DROP FOREIGN KEY product_of_visitors_visitor;
ALTER TABLE visitors_counter
  ADD CONSTRAINT product_of_visitors_visitor
FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;
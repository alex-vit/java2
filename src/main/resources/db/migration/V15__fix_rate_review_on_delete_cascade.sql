ALTER TABLE rate
  DROP FOREIGN KEY product_of_rate;
ALTER TABLE rate
  ADD CONSTRAINT product_of_rate
FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;

ALTER TABLE reviews
  DROP FOREIGN KEY product_of_review;
ALTER TABLE reviews
  ADD CONSTRAINT product_of_review
FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;

ALTER TABLE order_lines
  DROP FOREIGN KEY product_of_order_line;
ALTER TABLE order_lines
  ADD CONSTRAINT product_of_order_line
FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;

ALTER TABLE stock
  DROP FOREIGN KEY product_of_stock;
ALTER TABLE stock
  ADD CONSTRAINT product_of_stock
FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;
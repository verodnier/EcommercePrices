CREATE SEQUENCE price_sequence START WITH 1 INCREMENT BY 1;

-- DATA INSERT
INSERT INTO price 
	(id, brand_id, product_id, price_list, priority, start_date, end_date, price, curr) 
VALUES
	(NEXTVAL('price_sequence'), 1, 35455, 1, 0, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.50, 'EUR'),
	(NEXTVAL('price_sequence'), 1, 35455, 2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 'EUR'),
	(NEXTVAL('price_sequence'), 1, 35455, 3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.50, 'EUR'),
	(NEXTVAL('price_sequence'), 1, 35455, 4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 38.95, 'EUR');
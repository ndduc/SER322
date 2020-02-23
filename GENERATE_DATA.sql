USE product_test;

insert into products 
(product_id, description, cost, price, color, dimension, size, last_update, create_date)
values
(1, 'sport t-shirt 1', 1.00, 16.00, 'white', null, 'XS', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(2, 'sport t-shirt 2', 2.00, 20.00, 'black', null, 'S', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(3, 'sport t-shirt 3', 3.00, 35.00, 'yellow', null, 'M', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(4, 'sport t-shirt 4', 4.00, 22.00, 'red', null, 'L', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(5, 'sport t-shirt 5', 5.00, 20.00, 'white', null, 'XL', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(6, 'sport t-shirt 6', 6.00, 11.00, 'red', null, 'XXL', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(7, 'sport t-shirt 7', 7.00, 10.00, 'orange', null, 'S', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(8, 'sport t-shirt 8', 8.00, 5.00, 'white', null, 'M', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(9, 'sport t-shirt 9', 8.00, 9.00, 'white', null, 'M', '2020-01-01 00:00:00', '2020-01-01 00:00:00'),
(10, 'sport t-shirt 10', 8.00, 2.00, 'green', null, 'XXXS', '2020-01-01 00:00:00', '2020-01-01 00:00:00');




insert into brand
(brand_id, brand_name, last_update, create_date)
values
(1, "B1",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(2, "B2",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(3, "B3",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(4, "B4",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(5, "B5",'2020-01-01 00:00:00','2020-01-01 00:00:00' );

insert into products_brand
(product_id, brand_id)
values
(1,1),
(2,3),
(3,1),
(4,2),
(5,5),
(6,2),
(7,1),
(8,3),
(9,2),
(10,5);



insert into category
(category_id, category_name, last_update, create_date)
values
(1, "Cate1",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(2, "Cate2",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(3, "Cate3",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(4, "Cate4",'2020-01-01 00:00:00','2020-01-01 00:00:00' ),
(5, "Cate5",'2020-01-01 00:00:00','2020-01-01 00:00:00' );


insert into products_category
(product_id, category_id)
values
(1,1),
(2,3),
(3,1),
(4,2),
(5,5),
(6,2),
(7,1),
(8,3),
(9,2),
(10,5);

insert into customer
(customer_id, last_name, first_name, last_update, create_date)
values
(1, 'last1','cust1','2020-01-01 00:00:00','2020-01-01 00:00:00'),
(2, 'last2','cust2','2020-01-01 00:00:00','2020-01-01 00:00:00'),
(3, 'last3','cust3','2020-01-01 00:00:00','2020-01-01 00:00:00'),
(4, 'last4','cust4','2020-01-01 00:00:00','2020-01-01 00:00:00'),
(5, 'last5','cust5','2020-01-01 00:00:00','2020-01-01 00:00:00');


insert into search_history 
(customer_id, product_id, search_date, search_description, search_status)
values
(1, 6, '2020-02-11 11:00:00', 'sport t-shirt 6', 'FOUND'),
(2, 6, '2020-02-12 13:00:00', 'sport t-shirt 6', 'FOUND'),
(3, null, '2020-01-27 15:00:00', 'sport', 'NOT FOUND' );


insert into cart
(cart_id, purchase_date, customer_id, status, number_of_items )
values
(1,  	'2020-02-11 11:00:00'	, 1,'PAID', 1),
(1, 	'2020-02-12 12:00:00'	, 2,'PAID', 6),
(1,  	'2020-02-13 13:00:00'	, 3,'HOLD', 7),
(1,  	'2020-02-14 14:00:00'	, 1,'DROP', 6),
(1,  	'2020-02-15 15:00:00'	, 4, 'PAID', 10);

insert into product_cust
(customer_id, product_id, purchase_data) 
values
(1, 2 ,'2020-02-11 11:00:00'),
(2, 1 ,'2020-02-12 12:00:00'),
(2, 2 ,'2020-02-12 12:00:00'),
(2, 3 ,'2020-02-12 12:00:00'),
(2, 4 ,'2020-02-12 12:00:00'),
(2, 5 ,'2020-02-12 12:00:00'),
(2, 6 ,'2020-02-12 12:00:00'),
(4, 1 ,'2020-02-15 15:00:00'),
(4, 2 ,'2020-02-15 15:00:00'),
(4, 3 ,'2020-02-15 15:00:00'),
(4, 4 ,'2020-02-15 15:00:00'),
(4, 5 ,'2020-02-15 15:00:00'),
(4, 6 ,'2020-02-15 15:00:00'),
(4, 7 ,'2020-02-15 15:00:00'),
(4, 8 ,'2020-02-15 15:00:00'),
(4, 9 ,'2020-02-15 15:00:00'),
(4, 10 ,'2020-02-15 15:00:00');

insert into customer_cart
(cart_id, customer_id, purchase_date)
values
(1, 1, '2020-02-11 11:00:00'),
(1, 2, '2020-02-12 12:00:00'),
(1, 3, '2020-02-13 13:00:00'),
(1, 1, '2020-02-14 14:00:00'),
(1, 4, '2020-02-15 15:00:00');

insert into trans
(customer_id,  trans_id, purchase_date, paid_method, paid_status, card_number)
values
(1, 1, '2020-02-11 11:00:00', 'CREDIT', 'SUCCESS', 123456789),
(2, 1, '2020-02-12 12:00:00', 'CREDIT', 'SUCCESS', 464679135),
(4, 1, '2020-02-15 15:00:00', 'CREDIT', 'SUCCESS', 461319877);




insert into trans_cart
(customer_id, purchase_date, trans_id, cart_id)
values
(1, '2020-02-11 11:00:00', 1, 1),
(2, '2020-02-12 12:00:00', 1, 1),
(4,'2020-02-15 15:00:00', 1, 1);



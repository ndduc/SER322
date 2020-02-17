USE product_test;

insert into products 
(product_id, description, cost, price, color, dimension, size, last_update, create_date)
values
(1, 'sport t-shirt 1', 1.00, 16.00, 'white', null, 'XS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'sport t-shirt 2', 2.00, 20.00, 'black', null, 'S', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'sport t-shirt 3', 3.00, 35.00, 'yellow', null, 'M', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'sport t-shirt 4', 4.00, 22.00, 'red', null, 'L', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'sport t-shirt 5', 5.00, 20.00, 'white', null, 'XL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'sport t-shirt 6', 6.00, 11.00, 'red', null, 'XXL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'sport t-shirt 7', 7.00, 10.00, 'orange', null, 'S', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'sport t-shirt 8', 8.00, 5.00, 'white', null, 'M', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'sport t-shirt 9', 8.00, 9.00, 'white', null, 'M', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'sport t-shirt 10', 8.00, 2.00, 'green', null, 'XXXS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




insert into brand
(brand_id, brand_name, last_update, create_date)
values
(1, "B1",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(2, "B2",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(3, "B3",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(4, "B4",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(5, "B5",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );

insert into product_brand
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
(1, "Cate1",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(2, "Cate2",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(3, "Cate3",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(4, "Cate4",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP ),
(5, "Cate5",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP );


insert into product_category
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
(1, 'last1','cust1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(2, 'last2','cust2',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(3, 'last3','cust3',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(4, 'last4','cust4',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
(5, 'last5','cust5',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


insert into search_history 
(customer_id, product_id, search_date, search_descritpion, search_status)
values
(1, 6, CURRENT_TIMESTAMP, 'sport t-shirt 6', 'FOUND'),
(2, 6, CURRENT_TIMESTAMP, 'sport t-shirt 6', 'FOUND'),
(3, null, CURRENT_TIMESTAMP, 'sport', 'NOT FOUND' );


insert into cart
(cart_id, purchase_date, customer_id, status, count, cart_id_concat)
values
();

insert into customer_cart
(cart_id_concat, customer_id, create_date)
values
();


insert into trans
(trans_id, paid_date, paid_method, paid_status, card_number, trans_id_concat, cart_id_concat)
values
();

insert into trans_cart
(cart_id_concat, trans_id_concat)
values
();

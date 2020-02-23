use product_test;

/**
Simulate 
	scenario customer add something to cart
    then purchase
	
    customer make a second transaction on the same date
    date = 2020-02-14
**/
/*User Defined Variable Section*/
SELECT @DATE_ADD;
SELECT @CUST_ID;
SELECT @PAYMETHOD;
SELECT @CARDNUMBER;

SET @DATE_ADD = '2020-02-14 16:30:00';
SET @CUST_ID = 1;
SET @PAYMETHOD = 'CREDIT';
SET@CARDNUMBER = '77777777';

/*-------------------**/

SELECT @CARTID;
SET @CARTID = 
(SELECT IFNULL(max(c.cart_id),0) FROM product_test.cart as c
where convert(purchase_date,date) = convert(@DATE_ADD, date));

insert into cart
(cart_id, purchase_date, customer_id, status, number_of_items)
values
(@CARTID+1,  	@DATE_ADD	, @CUST_ID,'HOLD', 0);

insert into customer_cart
(cart_id, customer_id, purchase_date)
values
(@CARTID+1, @CUST_ID, @DATE_ADD);

insert into product_cust
(customer_id, product_id, purchase_data) 
values
(@CUST_ID, 2 ,@DATE_ADD),
(@CUST_ID, 1 ,@DATE_ADD),
(@CUST_ID, 2 ,@DATE_ADD),
(@CUST_ID, 3 ,@DATE_ADD),
(@CUST_ID, 4 ,@DATE_ADD),
(@CUST_ID, 5 ,@DATE_ADD);

SELECT @number_of_items_ITEM;
SET @number_of_items_ITEM = 
(select count(customer_id) from
product_cust as pc
where customer_id = @CUST_ID
and purchase_data = @DATE_ADD);

update cart
set number_of_items = @number_of_items_ITEM
where customer_id = @CUST_ID
and purchase_date = @DATE_ADD;


SELECT @TRAN_ID_MAX;

SET @TRAN_ID_MAX = (
SELECT IFNULL(max(trans_id),0) FROM trans
where customer_id = @CUST_ID
and convert(purchase_date,date) = convert(@DATE_ADD, date));

insert into trans
(customer_id,  trans_id, purchase_date, paid_method, paid_status, card_number)
values
(@CUST_ID, @TRAN_ID_MAX+1, @DATE_ADD, @PAYMETHOD, 'SUCCESS', @CARDNUMBER);

insert into trans_cart
(customer_id, purchase_date, trans_id, cart_id)
values
(@CUST_ID, @DATE_ADD, @TRAN_ID_MAX+1, @CARTID+1);

update cart
set status = 'PAID'
where customer_id = @CUST_ID
and purchase_date = @DATE_ADD;


/*********DEBUG - SELECT QUERY*****************/

Select * from cart
where customer_id = @CUST_ID
and purchase_date = @DATE_ADD;

Select * from product_cust
where customer_id = @CUST_ID
and purchase_data = @DATE_ADD;

Select * from trans
where customer_id = @CUST_ID
and purchase_date = @DATE_ADD; 



use product_test;

/**
Descritpion:
	Query show Brand Name, Product_id, Product Description
	Number of Item Sold.
    Amount of Item Sold in Money
    Condition is From [specified date] To [specified date]
*/
SELECT @DATE_FROM;
SELECT @DATE_TO;			
SET @DATE_FROM='2020-02-12';
SET @DATE_TO = '2020-02-15';

select b.brand_name as BRAND, p.product_id as UPC, 
p.description as PRODUCT, count(p.product_id) as SOLD_UNIT, 
(count(p.product_id) * p.price) as NET_AMOUNT 
from 
products as p
inner join products_brand as pb
on p.product_id = pb.product_id
inner join brand as b
on pb.brand_id = b.brand_id
inner join product_cust as pc
on pc.product_id = p.product_id
where convert(pc.purchase_data, date) >= @DATE_FROM
and convert(pc.purchase_data, date) <= @DATE_TO
group by p.product_id, p.description, b.brand_name;

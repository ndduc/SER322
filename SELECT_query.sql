use product_test;

/**
Select product from the specific brand 
or category
*/
SELECT @BRAND;			
SET @BRAND='B1';

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
where convert(pc.purchase_data, date) = '2020-02-12'
group by p.product_id, p.description, b.brand_name;

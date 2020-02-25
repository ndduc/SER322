use product_test;

SELECT @SEARCH;
SET @SEARCH = 'shirt';

select p.description as PRODUCT, p.price as PRICE, p.color as Color, ifnull(p.dimension, "NOT FOUND") as Dimension, p.size as SIZE,
 b.brand_name as BRAND
from products as p
inner join products_brand as pb
on p.product_id = pb.product_id
inner join brand as b
on pb.brand_id = b.brand_id
where p.description like concat('%', @SEARCH, '%')

use product_test;



DELIMITER //


CREATE PROCEDURE getSale_byDate(
	IN datefrom varchar(255),
	IN dateto varchar(255),
    OUT err varchar(255)
)
BEGIN
	SET err = null;
    if dateto is null or datefrom is null then 
    set err ="invalid parameter";
    else
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
	where convert(pc.purchase_data, date) >= datefrom
	and convert(pc.purchase_data, date) <= dateto
	group by p.product_id, p.description, b.brand_name;
    end if;
END //
 

DELIMITER ;
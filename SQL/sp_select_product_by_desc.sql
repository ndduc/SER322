USE product_test;
DELIMITER //


CREATE PROCEDURE getProductBy_desc(
	IN productdesc varchar(255),
    OUT err varchar(255)
)
BEGIN
	SET err = null;
    if productdesc is null then
    set err ="invalid parameter";
    else
    SELECT p.*, b.brand_name, c.category_name
    FROM products as p
    inner join products_brand as pb
    on p.product_id = pb.product_id
    inner join brand as b
    on pb.brand_id = b.brand_id
    inner join products_category as pc
    on p.product_id = pc.product_id
    inner join category as c 
    on pc.category_id = c.category_id
    where p.description like concat('%', productdesc, '%');
    end if;
END //
 

DELIMITER ;
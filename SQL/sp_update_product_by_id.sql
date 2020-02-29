use product_test;



DELIMITER //


CREATE PROCEDURE update_product(
	IN proc_Id varchar(255),
	IN proc_Desc varchar(255),
    IN proc_cost varchar(10),
    IN proc_price varchar(10),
    IN proc_color varchar(255),
    IN proc_dim varchar(255),
    IN proc_size varchar(10),
    IN proc_brand int,
    IN proc_cate int,
    
    OUT err varchar(255)
)
BEGIN
	SET err = null;
    if proc_Id is null or proc_Desc is null  or proc_cost is null 
     or proc_price is null or proc_brand is null
	 or proc_cate is null
    then 
    set err ="invalid parameter";
    else
		update products
        set description = proc_desc,
			cost = proc_cost,
            price = proc_price,
            color = proc_color,
            dimension = proc_dim,
            size = proc_size,
            last_update = sysdate()
            where product_id = proc_Id;
        update products_brand
			set brand_id = proc_brand
            where product_id = proc_id;
            
		update products_category
			set category_id = proc_cate
            where product_id = proc_id;
    end if;
END //
 

DELIMITER ;
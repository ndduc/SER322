use product_test;



DELIMITER //


CREATE PROCEDURE insert_product(
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
     or proc_price is null 
    then 
    set err ="invalid parameter";
    else
		insert into products
        (product_id, description, cost, price, color, dimension, size, last_update, create_date)
        values
        (proc_id, proc_desc, proc_cost, proc_price, proc_color, proc_dim, proc_size, sysdate(), sysdate());
        
        insert into products_brand
        (product_id, brand_id)
        values
        (proc_id, proc_brand);
        
		insert into products_category
        (product_id, category_id)
        values
        (proc_id, proc_cate);
    end if;
END //
 

DELIMITER ;
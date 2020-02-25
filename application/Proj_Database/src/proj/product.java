package proj;

public class product {
    String name, price, brand, size, dimension, color;
    
    public product(Integer productId) {
        connector con = new connector(connection_info.url, connection_info.driver, connection_info.user,
                connection_info.pass);
        query qry = new query(con.getConn());
        qry.searchProduct_by_id(productId);
        this.name = qry.getName();
        this.price = qry.getPrice();
        this.brand = qry.getBrand();
        this.size = qry.getSize();
        this.dimension = qry.getDimension();
        this.color = qry.getColor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
}

package proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

public class connector {
    Connection conn;
    String url;
    String driver;
    String user;
    String pass;
    
    
    
    public connector(String url, String driver, String user, String pass) {
        this.url = url;
        this.driver = driver;
        this.user = user;
        this.pass = pass;
        setConnection();
    }
    
    
    private void setConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    

    public Connection getConn() {
        return conn;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
    
    
    
    
}

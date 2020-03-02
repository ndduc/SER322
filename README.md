# SER322

Note:
notice: product_test on the top of the script indicate the database, it can be anything depend on where you store your table.

Query 1 - show number of item sold in the given date

Query 2 - This query simulates the scenario where the customer initiates a cart on the application, and cart status will be set as HOLD, and COUNT will set to 0. As a customer add more item to the cart, the COUNT attribute will increase by 1 per item. When customer initiate pay sequence, cart STATUS will update to PAID

Query 3 - Query allow looking for a specific item in the product table; conditonal statement use LIKE wild card.
<br>
JAVA Note
<br>
compiled jdk: jdk11 \n
<br>
execute all file in sql before compile java application
<br>
Compiling instruction:
Assume you are in project directory
<br>
  javac -d ./ -cp ".:./lib/mysql-connector-java-8.0.19.jar" src/proj/connection_info.java src/proj/connector.java src/proj/Main.java src/proj/product.java src/proj/query.java src/proj/ui.java
<br>
  java -cp ".:./lib/mysql-connector-java-8.0.19.jar" proj.Main      //Linux
  <br>
  java -cp ".;./lib/mysql-connector-java-8.0.19.jar" proj.Main      //WINdow

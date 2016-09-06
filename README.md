
This is the sample app for a basic E-commerce Website.
You can do :


-list products.
-add/edit  product
-see shopping cart
-add incredients to product
-list orders


You can easily understand Jersey - > Spring -> Hibernate relationship

Structure :
Jersey as a Controller part of the project,
Spring in the business layer
Hibernate located under data access part.


These are the list of used technologies :

Maven, Spring, Hibernate ,Jersey , Jquery , Twitter Bootstrap, Tomcat


First you need to prepare your database (MySQL) according to requirement written in  application.properties.



jdbc.driverClassName =com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/coffeeshop
jdbc.username=coffee
jdbc.password=shop
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.show_sql=false
hibernate.format_sql=false



CREATE DATABASE $1;
CREATE USER '$1'@'localhost' IDENTIFIED BY '$PASS';
GRANT ALL PRIVILEGES ON $1.* TO '$1'@'localhost';
FLUSH PRIVILEGES;


 Build with maven :
 mvn clean install



# pass this as a environment variable to initialize your DB.
-Dstart-mode=dev

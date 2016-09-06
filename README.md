
##CoffeeShop

This is the sample app for a basic #E-commerce Website.

##What you can do

-list products.
-add/edit  product
-see shopping cart
-add incredients to product
-list orders

##What you can understand

You can easily understand Jersey - > Spring -> Hibernate relationship

##What is the structure

Jersey as a Controller part of the project,
Spring in the business layer
Hibernate located under data access part.


##What are  the list of used technologies

Maven, Spring, Hibernate ,Jersey , Jquery , Twitter Bootstrap, Tomcat

##Step1
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

##Step2
 Build with maven :
 mvn clean install

##Step3
I used # Tomcat 7.0.62 to deploy, and pass this as a environment variable to initialize your DB.
-Dstart-mode=dev





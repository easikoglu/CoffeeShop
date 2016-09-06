Kullanılan teknolojiler

Maven, Spring, Hibernate ,Jersey , Jquery , Twitter Bootstrap, Tomcat


#Uygulamayı ayaga kaldırmadan önce
application.properties dosyasında yazanlara göre database'i hazırlayınız.
Database olarak Mysql tercih ettim.
Ancak yazılan tüm entity'ler interface'ten türetilerek yazıldığı için
istenildiği taktirde mongo gibi noSql bir db için de modeller implement edilerek kullanılabilir.


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


# war paketlemesi için build tool olarak kullandığımız maven'la derlememiz gerekiyor.
mvn clean install



# environment variable'e eklememiz gereken :
-Dstart-mode=dev

buradaki dev parametresi sayesinde tüm datalar otomatik populate ediliyor.

Hazır olanlar
-ürün listeleme,
-eklenti seçme,
-shoppping cart yapısı,
- yeni ürün ekleme
-yeni eklenti ekleme
-order'ların listelenmeis
-order içimndeki ürünlerin listelenmesi

-test yazamadım, hibernate ile uğraşmaktan  vaktim kalmadı açıkçası.





### 開発環境
#### BackEnd
* Java 8
* Spring Boot
* Spring Web
* JPA
* Lombok
* Swagger
#### FrontEnd
* Angular CLI 9
### IDE
* intelliJ
### DataBase
* MySql

### 画面構成
* TOP画面
<img width="901" alt="TOP" src="https://user-images.githubusercontent.com/68147250/87224051-19f5dd00-c3bd-11ea-8ae6-fa570e5ef824.png">
* 従業員登録画面
<img width="875" alt="add" src="https://user-images.githubusercontent.com/68147250/87224069-372aab80-c3bd-11ea-928d-374e48772ea1.png">
* 従業員詳細画面
<img width="867" alt="detail" src="https://user-images.githubusercontent.com/68147250/87224074-43166d80-c3bd-11ea-84d2-a262b9d6caa9.png">
* 従業員更新画面
<img width="870" alt="update" src="https://user-images.githubusercontent.com/68147250/87224084-4c9fd580-c3bd-11ea-9720-94a915505d54.png">

### API Swagger画面
![image](https://user-images.githubusercontent.com/68147250/87224104-8375eb80-c3bd-11ea-812a-352cf6cacd42.png)

### DDL query
<pre>
<code>
CREATE TABLE `employee` (
  `no` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(110) DEFAULT NULL,
  `mobile_no` varchar(50) DEFAULT NULL,
  `member_type` char(8) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`no`)
) ;

CREATE TABLE `review` (
  `no` int NOT NULL AUTO_INCREMENT,
  `employee_no` int DEFAULT NULL,
  `contents` varchar(1000) DEFAULT NULL,
  `register_ymdt` datetime DEFAULT NULL,
  PRIMARY KEY (`no`)
) ;
</code>
</pre>

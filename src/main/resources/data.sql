/*従業員テーブルのデータ(第3章で作成)*/

INSERT INTO employee(employee_id,employee_firstname,employee_lastname,age,number)
VALUES(1,'茶谷','ひでじ',30,88);


/* ユーザーマスターのデータ(アドミン権限)*/
INSERT INTO m_user(user_id,password,user_name,birthday,age,marriage,role)
VALUES('yamada@xxx.co.jp','password','山田太郎','1990-01-01',28,false,'ROLE_ADMIN');


/* ユーザーマスターのデータ(一般権限)*/
INSERT INTO m_user(user_id,password,user_name,birthday,age,marriage,role)
VALUES('tamura@co.jp','password','田村達也','1986-11-05',31,false,'ROLE_ENERAL');

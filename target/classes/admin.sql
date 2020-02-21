insert into info(id_info, name, age, city) values (1, 'admin', 20, 'admin');
insert into users(id, login, password, id_info) values (1, 'admin', 'admin', 1);
insert into user_role(id) values (1);
insert into roles(id_roles, roles) values
       (1, 'admin'),
       (2, 'user'),
       (3, 'del_user'),
       (4, 'black_list');
update user_role set id_roles = 1 where id = 1;





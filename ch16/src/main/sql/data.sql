insert into t_account (id, sort_code, number_, balance)
               values (1, '011001', '12345678', 1000.0)
/
insert into t_account (id, sort_code, number_, balance)
               values (2, '011001', '87654321', 100.0)
/
insert into t_account (id, sort_code, number_, balance)
               values (3, '011001', '10203040', 0.0)
/
insert into t_account (id, sort_code, number_, balance)
               values (4, '011001', '50607080', 30.0)
/
insert into t_account (id, sort_code, number_, balance)
               values (5, '011001', '10000000', 1000000.0)
/

update t_account set balance = 1000.0 where id = 1
/
update t_account set balance = 100.0 where id = 2
/
update t_account set balance = 0.0 where id = 3
/
update t_account set balance = 30.0 where id = 4
/
update t_account set balance = 1000000.0 where id = 5
/


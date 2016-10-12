create table t_customer (
    id number(19, 0) not null,
    first_name varchar2(50) not null,
    last_name varchar2(50) not null,
    last_login timestamp null,
    comments clob null,
    constraint pk_customer primary key(id)
)
/
create sequence s_customer_id start with 1000
/

create or replace procedure p_actstartled(n number)
is
begin
    dbms_output.put_line(n || '?! Really?');
end;
/

create or replace function f_calculate
return number
as
begin
    return 42;
end;
/

create or replace function f_find_customers(name varchar2)
return sys_refcursor
is
begin
    return 
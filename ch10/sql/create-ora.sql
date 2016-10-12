create table T_Customer_Detail (
    Id number(19, 0) not null,
    Data varchar2(512) not null,
    constraint PK_CustomerDetailId primary key (Id)
);
create table T_Customer (
    Id number(19, 0) not null,
    First_Name varchar(50) not null,
    Last_Name varchar(50) not null,
    Last_Login timestamp not null,
    Customer_Detail int not null,
    Customer_Gossip int null,
    constraint PK_CustomerId primary key (Id),
           constraint FK_CustomerDetail foreign key (Customer_Detail)
        references T_Customer_Detail(Id) on delete cascade,
    constraint FK_CustomerGossip foreign key (Customer_Gossip)
        references T_Customer_Detail(Id) on delete cascade
);
create sequence s_customer_id start with 1000;
insert into T_Customer_Detail (Id, Data) values (100, 'Detail 1');
insert into T_Customer_Detail (Id, Data) values (101, 'Foo');
insert into T_Customer_Detail (Id, Data) values (102, 'Bar');
insert into T_Customer (Id, First_Name, Last_Name, Last_Login, Customer_Detail, Customer_Gossip) values (1, 'John', 'Smith', TO_DATE('08-08-2007', 'dd-MM-YYYY'), 100, null);
insert into T_Customer (Id, First_Name, Last_Name, Last_Login, Customer_Detail, Customer_Gossip)
    values (2, 'Jane', 'Doe', TO_DATE('08-08-2007', 'dd-MM-YYYY'), 101, 102);





create table T_Order (
    Id number(19, 0) not null,
    Customer int not null,

    constraint PK_OrderId primary key (Id),
    constraint FK_Customer foreign key (Customer) references T_Customer(Id)
);
create sequence s_order_id start with 1000;

create table T_Order_Line (
    Id number(19, 0) not null,
    "Order" number(19, 0) not null,
    Product varchar(200) not null,
    Price decimal(10, 2) not null,

    constraint PK_OrderLineId primary key (Id),
    constraint FK_Order foreign key ("Order") references T_Order(Id)
);
create sequence s_order_line_id start with 1000;


insert into T_Order (Id, Customer) values (100, 1);
insert into T_Order_Line (Id, "Order", Product, Price)
    values (200, 100, 'Punch people over the internet client application', 19.95);
insert into T_Order_Line (Id, "Order", Product, Price)
    values (201, 100, 'The Mangelfreuzer Switch', 12.95);




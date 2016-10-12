create table CustomerDetails (
    Id serial not null,
    Data varchar(255) not null,

    constraint PK_CustomerDetailId primary key (Id)
);
create table Customers (
    Id serial not null,
    FirstName varchar(50) not null,
    LastName varchar(50) not null,
    LastLogin timestamp not null,
    CustomerDetail int not null,
    CustomerGossip int null,
    constraint PK_CustomerId primary key (Id),
           constraint FK_CustomerDetail foreign key (CustomerDetail)
        references CustomerDetails(Id) on delete cascade,
    constraint FK_CustomerGossip foreign key (CustomerGossip)
        references CustomerDetails(Id) on delete cascade
);

insert into CustomerDetails (Id, Data) values (100, 'Detail 1');
insert into CustomerDetails (Id, Data) values (101, 'Foo');
insert into CustomerDetails (Id, Data) values (102, 'Bar');
insert into Customers (Id, FirstName, LastName, LastLogin, CustomerDetail, CustomerGossip) values (1, 'John', 'Smith', '2007-08-08', 100, null);
insert into Customers (Id, FirstName, LastName, LastLogin, CustomerDetail, CustomerGossip)
    values (2, 'Jane', 'Doe', '2007-08-08', 101, 102);

create index IX_Customers_CustomerDetail on Customers
    using btree (CustomerDetail);
create index IX_Customers_CustomerGossip on Customers
    using btree (CustomerGossip);




create table Orders (
    OrderId serial not null,
    Customer int not null,

    constraint PK_OrderId primary key (OrderId),
    constraint FK_Customer foreign key (Customer) references Customers(Id)
);

create index IX_Orders_Customer on Orders using btree (Customer);

create table OrderLines (
    OrderLineId serial not null,
    "Order" int not null,
    Product varchar(200) not null,
    Price decimal(10, 2) not null,

    constraint PK_OrderLineId primary key (OrderLineId),
    constraint FK_Order foreign key ("Order") references Orders(OrderId)
);

create index IX_OrderLines_Order on OrderLines using btree ("Order");

insert into Orders (Customer) values (1);
insert into OrderLines ("Order", Product, Price)
    values (1, 'Punch people over the internet client application', 19.95);
insert into OrderLines ("Order", Product, Price)
    values (1, 'The Mangelfreuzer Switch', 12.95);    




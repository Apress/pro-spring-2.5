create table t_log_entry (
    id number(19, 0) not null,
    version number(19, 0) null,
    name varchar2(100) not null,
    date_ date not null,
    constraint pk_log_entry primary key (id)
)
/
create sequence s_log_entry_id start with 10000
/

create table t_supplier (
    id number(19, 0) not null,
    version number(19, 0) null,
    name varchar2(200) not null,
    constraint pk_supplier primary key (id)
)
/
create sequence s_supplier_id start with 10000
/

create table t_invoice (
    id number(19, 0) not null,
    version number(19, 0) null,
    invoice_date date not null,
    delivery_date date not null,
    supplier number(19, 0) not null,
    constraint pk_invoice primary key (id),
    constraint fk_i_supplier foreign key (supplier) references t_supplier(id)
)
/
create sequence s_invoice_id start with 10000
/

create table t_invoice_line (
    id number(19, 0) not null,
    version number(19, 0) null,
    invoice number(19, 0) not null,
    price number(20, 4) not null,
    vat number(20, 4) not null,
    product_code varchar2(50) not null,
    constraint pk_invoice_line primary key (id),
    constraint fk_il_invoice foreign key (invoice) references t_invoice(id)
)
/
create sequence s_invoice_line_id start with 10000
/

create table t_discount (
    id number(19, 0) not null,
    version number(19, 0) null,
    invoice_line number(19, 0) not null,
    type_ varchar2(50) not null,
    amount number(20, 4) not null,
    constraint pk_discount primary key (id),
    constraint fk_d_invoice_line foreign key (invoice_line) references t_invoice_line(id)
)
/
create sequence s_discount_id start with 10000
/

create table t_lob_test (
    id number(19, 0) not null,
    version number(19, 0) null,
    text_content clob not null,
    binary_content blob not null,
    mime_type varchar2(200) not null,
    constraint pk_lob_test primary key (id)
)
/
create sequence s_lob_test_id start with 10000
/


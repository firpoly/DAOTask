CREATE TABLE CUSTOMERS (
    id SERIAL PRIMARY KEY,
    name varchar(100) NOT NULL,
    surname varchar(100) NOT NULL,
    age int,
    phone_number varchar(20)
);
CREATE TABLE ORDERS (
    id SERIAL PRIMARY KEY,
    date DATE NOT NULL,
    customer_id int NOT NULL references CUSTOMERS(id),
    product_name varchar(100) NOT NULL,
    amount numeric NOT NULL
);
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS orders;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) not null,
    price INT not null,
    category VARCHAR(50) not null,
    reg_date DATETIME
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT not null,
    pay_method VARCHAR(10) not null,
    reg_date DATETIME
);

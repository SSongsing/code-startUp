DROP TABLE IF EXISTS books;
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) not null,
    price INT not null,
    category VARCHAR(50) not null
);

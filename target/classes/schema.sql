DROP TABLE bookarchive.book;
DROP SCHEMA IF EXISTS bookarchive;

CREATE SCHEMA bookarchive AUTHORIZATION sa;

CREATE TABLE bookarchive.book ( 
   book_id INT NOT NULL, 
   book_title VARCHAR(50) NOT NULL,
   book_series VARCHAR(20),
   book_author VARCHAR(20) NOT NULL,
   book_illustrator VARCHAR(20),
   book_genre VARCHAR(20)
);
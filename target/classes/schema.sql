DROP SCHEMA IF EXISTS library;
CREATE SCHEMA bookarchive AUTHORIZATION sa;

DROP TABLE IF EXISTS bookarchive.book;
CREATE TABLE bookarchive.book ( 
   book_id VARCHAR(10) NOT NULL, 
   book_title VARCHAR(50) NOT NULL,
   book_series VARCHAR(20),
   book_author VARCHAR(20) NOT NULL,
   book_illustrator VARCHAR(20),
   book_genre VARCHAR(20)
);
insert into CATEGORY (name) values ('Design Patters');
insert into CATEGORY (name) values ('Java');
insert into CATEGORY (name) values ('Scala');
insert into CATEGORY (name) values ('Spring Framework');

insert into BOOK (category_id, isbn, title, price) values (1, '0201633612', 'Design Patterns: Elements of Reusable Object-Oriented Software', '48.31');
insert into BOOK (category_id, isbn, title, price) values (1, '1449331491', 'Head First Design Patterns: A Brain-Friendly Guide', '40.79');
insert into BOOK (category_id, isbn, title, price) values (2, '0596552440', 'Hardcore Java', '17.27');
insert into BOOK (category_id, isbn, title, price) values (2, '0071808566', 'Java: The Complete Reference, Ninth Edition', '36.14');
insert into BOOK (category_id, isbn, title, price) values (3, '1498759688', 'Introduction to the Art of Programming Using Scala', '70.36');
insert into BOOK (category_id, isbn, title, price) values (4, '1430265337', 'Introducing Spring Framework: A Primer', '31.72');
insert into BOOK (category_id, isbn, title, price) values (4, '1847195431', 'Spring Web Flow 2 Web Development', '14.59');

insert into AUTHOR(first_name, last_name, description) values ('Erich', 'Gamma', 'Eric Gamma Description');
insert into AUTHOR(first_name, last_name, description) values ('John', 'Vlissides', 'John Vlissides Description');
insert into AUTHOR(first_name, last_name, description) values ('Brett', 'McLaughlin', 'Brett McLaughlin Description');
insert into AUTHOR(first_name, last_name, description) values ('Robert', 'Simmons Jr', 'Robert Simmons Jr Description');
insert into AUTHOR(first_name, last_name, description) values ('Herbert', 'Schildt', 'Herbert Schildt Description');
insert into AUTHOR(first_name, last_name, description) values ('Mark', 'Lewis', 'Mark C. Lewis Description');
insert into AUTHOR(first_name, last_name, description) values ('Felipe', 'Gutierrez', 'Felipe Gutierrez Description');
insert into AUTHOR(first_name, last_name, description) values ('Sven', 'LÃppken', 'Sven LÃppken Description');

insert into AUTHOR_BOOK(book_id, author_id) values (1,1);
insert into AUTHOR_BOOK(book_id, author_id) values (1,2);
insert into AUTHOR_BOOK(book_id, author_id) values (2,3);
insert into AUTHOR_BOOK(book_id, author_id) values (3,4);
insert into AUTHOR_BOOK(book_id, author_id) values (4,5);
insert into AUTHOR_BOOK(book_id, author_id) values (5,6);
insert into AUTHOR_BOOK(book_id, author_id) values (6,7);
insert into AUTHOR_BOOK(book_id, author_id) values (7,8);
insert into AUTHOR_BOOK(book_id, author_id) values (5,3);
insert into AUTHOR_BOOK(book_id, author_id) values (4,4);

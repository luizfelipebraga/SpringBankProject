create table Bank(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   description VARCHAR(200) NULL,
   PRIMARY KEY (id)
);


create table Account(
   id INT NOT NULL AUTO_INCREMENT,
   id_bank INT NOT NULL,
   account INT NOT NULL,
   agency INT NOT NULL,
   account_digit INT NOT NULL,
   PRIMARY KEY ( id ),
   FOREIGN KEY (id_bank) REFERENCES Bank(id)
);


create table Client(
   id INT NOT NULL AUTO_INCREMENT,
   id_account INT NOT NULL,
   name VARCHAR(240) NOT NULL,
   email VARCHAR(300) NOT NULL,
   document VARCHAR(14) NOT NULL,
   birth_date DATE,
   PRIMARY KEY ( id ),
   FOREIGN KEY (id_account) REFERENCES Account(id)
);

INSERT INTO orange.Bank
(name, description)
VALUES('Itau', 'banco top');

INSERT INTO orange.Account
(id_bank, account, agency, account_digit)
VALUES(1, 123123, 1010, 2);

INSERT INTO orange.Client
(id_account, name, email, document, birth_date)
VALUES(1, 'Felipe', 'ruivolfb@gmail.com', '333.222.222-22', '2003-04-10');
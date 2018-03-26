CREATE TABLE IF NOT EXISTS role (
	id int PRIMARY KEY,
	name varchar(255),
	user_id int
);

CREATE TABLE IF NOT EXISTS user (
	id int PRIMARY KEY,
	username varchar(255)
);

 ALTER TABLE role
    ADD FOREIGN KEY (user_id) 
    REFERENCES user(id);
/*
 DROP TABLE IF EXISTS user_cat
 */


CREATE TABLE IF NOT EXISTS user_cat
(
    id    BIGINT PRIMARY KEY,
    name  varchar(50),
    mail  varchar(50),
    phone varchar(10)
);

CREATE TABLE IF NOT EXISTS user_dog
(
    id    BIGINT PRIMARY KEY,
    name  varchar(50),
    mail  varchar(50),
    phone varchar(10)
);

CREATE TABLE IF NOT EXISTS volunteer_dog
(
    id    BIGINT PRIMARY KEY,
    name  varchar(50),
    mail  varchar(50),
    phone varchar(10)
);

CREATE TABLE IF NOT EXISTS volunteer_cat
(
    id    BIGINT PRIMARY KEY,
    name  varchar(50),
    mail  varchar(50),
    phone varchar(10)
);

CREATE TABLE IF NOT EXISTS user_volunteer_dog
(
    id           BIGINT PRIMARY KEY,
    user_id      BIGINT NOT NULL,
    volunteer_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_dog (id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer_dog (id)
);

CREATE TABLE IF NOT EXISTS user_volunteer_dog
(
    id           BIGINT PRIMARY KEY,
    user_id      BIGINT NOT NULL,
    volunteer_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_dog (id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer_dog (id)
);

CREATE TABLE IF NOT EXISTS dogs
(
    id   BIGINT PRIMARY KEY,
    name varchar(50),
    age  INT,
    info varchar(300)
);


CREATE TABLE IF NOT EXISTS adopter_dog
(
  id  BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  dog_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user_dog(id),
  FOREIGN KEY (dog_id) REFERENCES dogs
);

CREATE TABLE IF NOT EXISTS probation_dog
(
    id           BIGINT PRIMARY KEY,
    adopter_id   BIGINT NOT NULL,
    volunteer_id BIGINT NOT NULL,
    day_left    INT NOT NULL,
    FOREIGN KEY (adopter_id) REFERENCES adopter_dog (id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer_dog (id)
);
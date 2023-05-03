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



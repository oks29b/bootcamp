CREATE TABLE user(
    id bigint NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL,
    surname varchar(40) NOT NULL,
    patronymic varchar(20) NOT NULL,
    email varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_role (
    user_id bigint DEFAULT NULL,
    role varchar(40) DEFAULT NULL,
    KEY user_id (user_id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

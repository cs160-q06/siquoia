CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(128),
    password VARCHAR(40),
    admin BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE topics(
    id INT NOT NULL AUTO_INCREMENT,
    topic VARCHAR(128) NOT NULL,
    subtopic_id INT,
    subsubtopic_id INT,
    CONSTRAINT FOREIGN KEY (subtopic_id) REFERENCES topics (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (subsubtopic_id) REFERENCES topics (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (id, subtopic_id, subsubtopic_id)
);

CREATE TABLE questions(
    question_id INT NOT NULL AUTO_INCREMENT,
    topic_id INT,
    question VARCHAR(1024),
    CONSTRAINT FOREIGN KEY (topic_id) REFERENCES topics (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (question_id)
);

CREATE TABLE answers(
    id INT NOT NULL AUTO_INCREMENT,
    answer VARCHAR(1024),
    question_id INT,
    CONSTRAINT FOREIGN KEY (question_id) REFERENCES questions (question_id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE scores(
    date_taken TIMESTAMP(6),
    user_id INT,
    topic_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (topic_id) REFERENCES topics (id)
);

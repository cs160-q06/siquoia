CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(128),
    password VARCHAR(40),
    admin BOOLEAN,
    PRIMARY KEY (email)
);

CREATE TABLE topics(
    id INT NOT NULL AUTO_INCREMENT,
    topic VARCHAR(128) NOT NULL,
    FOREIGN KEY (subtopic) REFERENCES topics (topic),
    FOREIGN KEY (subsubtopic) REFERENCES topics (topic),
    PRIMARY KEY (name)
);

CREATE TABLE questions(
    question_id INT NOT NULL AUTO_INCREMENT,
    question VARCHAR(1024),
    FOREIGN KEY (topic) REFERENCES topics (topic)
);

CREATE TABLE answers(
    answer VARCHAR(1024),
    FOREIGN KEY (question_id) REFERENCES (question_id)
);

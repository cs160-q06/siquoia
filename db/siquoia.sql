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
    FOREIGN KEY (subtopic_id) REFERENCES topics (id),
    FOREIGN KEY (subsubtopic_id) REFERENCES topics (id),
    PRIMARY KEY (id, subtopic_id, subsubtopic_id)
);

CREATE TABLE questions(
    question_id INT NOT NULL AUTO_INCREMENT,
    question VARCHAR(1024),
    FOREIGN KEY (topic) REFERENCES topics (topic)
);

CREATE TABLE answers(
    answer VARCHAR(1024),
    FOREIGN KEY (question_id) REFERENCES questions (question_id)
);

CREATE TABLE scores(
    date_taken
    FOREIGN KEY (user_id) REFERENCES users (id)
    FOREIGN KEY (topic_id) REFERENCES topics (id)
);

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
    PRIMARY KEY (id)
);

CREATE TABLE subtopics(
    id INT NOT NULL AUTO_INCREMENT,
    subtopic VARCHAR(128) NOT NULL,
    topic_id INT,
    CONSTRAINT FOREIGN KEY (topic_id) REFERENCES topics (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (id, topic_id)
);

CREATE TABLE subsubtopics(
    id INT NOT NULL AUTO_INCREMENT,
    subsubtopic VARCHAR(128) NOT NULL,
    subtopic_id INT,
    CONSTRAINT FOREIGN KEY (subtopic_id) REFERENCES subtopics (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (id, subtopic_id)
);

CREATE TABLE questions(
    question_id INT NOT NULL AUTO_INCREMENT,
    topic_id INT,
    question VARCHAR(1024),
    correct_answer VARCHAR(1024),
    answer1 VARCHAR(1024),
    answer2 VARCHAR(1024),
    answer3 VARCHAR(1024),
    num_times_answered_correctly INT,
    num_attempts INT,
    CONSTRAINT FOREIGN KEY (topic_id) REFERENCES topics (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (question_id)
);

CREATE TABLE scores(
    date_taken TIMESTAMP(6),
    user_id INT,
    topic_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (topic_id) REFERENCES topics (id)
);

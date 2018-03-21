CREATE TABLE IF NOT EXISTS users (id BIGINT NOT NULL auto_increment PRIMARY KEY, name  VARCHAR(100) NOT NULL, pass VARCHAR(100) NOT NULL , isTutor BOOLEAN);
CREATE TABLE IF NOT EXISTS tests (id BIGINT NOT NULL auto_increment PRIMARY KEY, name VARCHAR(255) NOT NULL , type VARCHAR(255) NOT NULL);
CREATE TABLE IF NOT EXISTS questions (id BIGINT NOT NULL auto_increment PRIMARY KEY, text VARCHAR(1000) NOT NULL, testId BIGINT NOT NULL, FOREIGN KEY (testId) REFERENCES tests (Id) ON DELETE CASCADE ON UPDATE CASCADE);
CREATE TABLE IF NOT EXISTS answers (id BIGINT NOT NULL auto_increment PRIMARY KEY, text VARCHAR(100) NOT NULL , isRight BOOLEAN, questionId BIGINT NOT NULL, FOREIGN KEY (questionId) REFERENCES questions(id) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO users(name, pass, isTutor) VALUES('dima@dima', 'dima', FALSE);
INSERT INTO users(name, pass, isTutor) VALUES('andrey@andrey', 'andrey', FALSE);
INSERT INTO users(name, pass, isTutor) VALUES('max@max', 'max', FALSE);
INSERT INTO users(name, pass, isTutor) VALUES('tutor@tutor', 'tutor', TRUE);


INSERT INTO tests(id, name, type) VALUES(1, 'mathTest', 'Math');
INSERT INTO tests(id, name, type) VALUES(2, 'physicsTest', 'Physics');
INSERT INTO tests(id, name, type) VALUES(3, 'englishTest', 'English');
INSERT INTO tests(id, name, type) VALUES(4, 'englishTestULTRA3000', 'English');

INSERT INTO questions(text, testId) VALUES('testQuestMath1', 1);
INSERT INTO questions(text, testId) VALUES('testQuestMath2', 1);
INSERT INTO questions(text, testId) VALUES('testQuestPhysics1', 2);
INSERT INTO questions(text, testId) VALUES('testQuestPhysics2', 2);
INSERT INTO questions(text, testId) VALUES('testQuestEnglish1', 3);
INSERT INTO questions(text, testId) VALUES('testQuestEnglish2', 3);
INSERT INTO questions(text, testId) VALUES('testQuestEnglishU1', 4);
INSERT INTO questions(text, testId) VALUES('testQuestEnglishU2', 4);

INSERT INTO answers(text, isRight, questionId) VALUES('testAnswMath1_1', TRUE, 1);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswMath1_2', FALSE, 1);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswMath1_3', TRUE, 1);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswMath2_1', TRUE, 2);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswMath2_2', FALSE, 2);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswMath2_3', TRUE, 2);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswPhysics1_1', TRUE, 3);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswPhysics1_2', FALSE, 3);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswPhysics1_3', TRUE, 3);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswPhysics2_1', TRUE, 4);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswPhysics2_2', FALSE, 4);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswPhysics2_3', TRUE, 4);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglish1_1', TRUE, 5);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglish1_2', FALSE, 5);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglish1_3', TRUE, 5);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglish2_1', TRUE, 6);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglish2_2', FALSE, 6);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglish2_3', TRUE, 6);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglishU1_1', TRUE, 7);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglishU1_2', FALSE, 7);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglishU1_3', TRUE, 7);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglishU2_1', TRUE, 8);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglishU2_2', FALSE, 8);
INSERT INTO answers(text, isRight, questionId) VALUES('testAnswEnglishU2_3', TRUE, 8);

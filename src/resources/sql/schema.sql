create TABLE groups (
  id int NOT NULL PRIMARY KEY,
  nameGroup VARCHAR(10) NOT NULL
);

CREATE table professors (
  id int NOT NULL PRIMARY KEY,
  familyProfessors VARCHAR(20),
  nameProfessors VARCHAR(10),
  nameFatherProfessors VARCHAR(20)
);

CREATE TABLE discipline (
  id int NOT NULL PRIMARY KEY,
  nameDiscipline VARCHAR(20) NOT NULL,
  idProfessor int,
  FOREIGN KEY (idProfessor) REFERENCES professors(id)
);

CREATE table student (
  id int NOT NULL PRIMARY KEY,
  familyStudents VARCHAR(20),
  nameStudents VARCHAR(10),
  nameFatherStudents VARCHAR(20),
  Birthdate DATE,
  idGroup int NOT NULL,
  FOREIGN KEY (idGroup) REFERENCES groups(id)
);

CREATE table balls (
  id int NOT NULL PRIMARY KEY,
  idStudent int NOT NULL,
  idDiscipline int NOT NULL,
  idProfessor int NOT NULL,
  balls int NOT NULL,
  FOREIGN KEY (idStudent) REFERENCES Student(id),
  FOREIGN KEY (idDiscipline) REFERENCES discipline(id),
  FOREIGN KEY (idProfessor) REFERENCES professors(id)
);
package balls.services;

import balls.model.Professors;

public interface ProfessorsService {
    public void addProfessor(Professors professors);
    public void updateProfessor(Professors professors);
    public void removeProfessor(int id);
    public Professors getProfessorId(int id);
    public void listProfessors();
}

package balls.repositories;

import balls.model.Professors;

import java.util.List;

public interface ProfessorsRepository {
    void addProfessor(Professors professors);
    void updateProfessor(Professors professors);
    public void removeProfessor(int id);
    Professors getProfessor(int id);
    List<Professors> getAllProfessors();
}

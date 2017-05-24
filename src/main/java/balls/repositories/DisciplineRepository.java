package balls.repositories;

import balls.model.Discipline;

import java.util.List;

public interface DisciplineRepository {
   List<Discipline> getAllDisciplines(int id);
}

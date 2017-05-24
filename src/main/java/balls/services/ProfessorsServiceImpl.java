package balls.services;


import balls.model.Discipline;
import balls.model.Professors;
import balls.repositories.DisciplineRepository;
import balls.repositories.DisciplineRepositoryImpl;
import balls.repositories.ProfessorsRepository;
import balls.repositories.ProfessorsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("professorsService")
public class ProfessorsServiceImpl implements ProfessorsService {
    private ProfessorsRepository professorsRepository;
    private DisciplineRepository disciplineRepository;

    @Autowired
    public void setProfessorsRepository(ProfessorsRepositoryImpl professorsRepository) {
        this.professorsRepository = professorsRepository;
    }
    @Autowired
    public void setDisciplineRepository(DisciplineRepositoryImpl disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    @Transactional
    public void addProfessor(Professors professors) {
        this.professorsRepository.addProfessor(professors);
    }

    @Override
    @Transactional
    public void updateProfessor(Professors professors) {
        this.professorsRepository.updateProfessor(professors);
    }

    @Override
    @Transactional
    public void removeProfessor(int id) {
        this.professorsRepository.removeProfessor(id);
    }

    @Override
    @Transactional
    public Professors getProfessorId(int id) {
        return this.professorsRepository.getProfessor(id);
    }

    @Override
    @Transactional
    public void listProfessors() {
        List<Professors> professorsList = professorsRepository.getAllProfessors();
        for (int i = 0; i < professorsList.size(); i++) {
            List <Discipline> disciplineList = disciplineRepository.getAllDisciplines(i+1);
            System.out.println(professorsList.get(i));
            System.out.println(disciplineList);
        }
    }
}

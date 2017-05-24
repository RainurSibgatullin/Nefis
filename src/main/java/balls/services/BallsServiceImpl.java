package balls.services;

import balls.model.Balls;
import balls.repositories.BallsRepository;
import balls.repositories.BallsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ballsService")
public class BallsServiceImpl implements BallsService {
    private BallsRepository ballsRepository;

    @Autowired
    public BallsServiceImpl(BallsRepositoryImpl ballsRepository) {
        this.ballsRepository = ballsRepository;
    }

    @Override
    @Transactional
    public void addBall(Balls balls) {this.ballsRepository.addBall(balls);
    }

    @Override
    @Transactional
    public void updateBall(Balls balls) {
        this.ballsRepository.updateBall(balls);
    }

    @Override
    @Transactional
    public void removeBalls(int id) {
        this.ballsRepository.removeBalls(id);
    }

    @Override
    @Transactional
    public Balls getBallsId(int id) {
        return this.ballsRepository.getBallsId(id);
    }

    @Override
    @Transactional
    public List<Balls> listBalls() {
        return this.ballsRepository.listBalls();
    }

}

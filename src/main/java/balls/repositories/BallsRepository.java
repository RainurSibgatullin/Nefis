package balls.repositories;

import balls.model.Balls;

import java.util.List;

public interface BallsRepository {
    void addBall(Balls balls);
    void updateBall(Balls balls);
    public void removeBalls(int id);
    public Balls getBallsId(int id);
    public List<Balls> listBalls();
}

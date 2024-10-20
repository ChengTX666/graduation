package nefu.springboot.repository;

import nefu.springboot.dox.Score;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends CrudRepository<Score,String> {

    @Query("SELECT * from score where student_id=:sid")
    public List<Score> findByStudentId(String sid);


    @Query("SELECT * from score where `group`=:group")
    public List<Score> findByGroup(int group);

    @Modifying
    @Query("UPDATE score s set s.detail=:detail where s.id=:sid")
    public Score updateDetailById(String sid,String detail);

    @Query("SELECT * from score where `group`=:group")
    public List<Score> findScoresByGroup(int group);

    @Query("SELECT * from score where teacher->>'$.teacherId'=:tid")
    public List<Score> findScoresByTid(String tid);
}
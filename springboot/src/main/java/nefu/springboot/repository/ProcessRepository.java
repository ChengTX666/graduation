package nefu.springboot.repository;

import jakarta.annotation.PostConstruct;
import nefu.springboot.dox.Process;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends CrudRepository<Process,String> {

    @Query("select * from `process` p where p.depId=:depId")
    List<Process> findByDepId(String depId);



    @Query("delete from process where id=:pid and depId=:did")
    void deleteByIdAndDepId(String pid,String did);
}

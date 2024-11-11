package nefu.springboot.repository;

import nefu.springboot.dox.Department;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface DepartmentRepository extends CrudRepository<Department,String> {

    @Query("SELECT * from department")
    List<Department> showAll();

    @Modifying
    @Query("delete from department where id=:did")
    void deleteById(String did);

}

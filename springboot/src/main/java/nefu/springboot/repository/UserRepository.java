package nefu.springboot.repository;

import nefu.springboot.dox.User;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    @Query("SELECT * from `user` where account=:account")
    User findByAccount(String account);

    @Modifying
    @Query("UPDATE user u set u.password=:encodePassword where u.account=:account")
    void updatePasswordByAccount(String account,String encodePassword);


    @Query("select count(*) from user  where cast(department->>'$.depId' as char(19))=:did")
    Integer countByDepartment(String did);


    @Query("select * from user where cast(department->>'$.depId' as char(19))=:depId and role=:role")
    List<User> findByDepIdAndRole(String depId,String role);

    @Query("select * from user where cast(department->>'$.depId' as char(19))=:depId and role=:role and `group`=:group")
    List<User> findByDepIdAndRoleAndGroup(String depId,String role,int group);


    @Query("select * from user u where department->>'$.depId'=:depId and student->>'$.teacherId'=:tid")
    List<User> mentorStudents(String depId,String tid);

    @Modifying
    @Query("update user u set student=json_set(student,'$.teacherId',:tid) where id=:sid")
    void updateStudentById(String sid,String tid);
}

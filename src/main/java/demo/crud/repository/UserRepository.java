package demo.crud.repository;


import demo.crud.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    List<User> findAll();


}
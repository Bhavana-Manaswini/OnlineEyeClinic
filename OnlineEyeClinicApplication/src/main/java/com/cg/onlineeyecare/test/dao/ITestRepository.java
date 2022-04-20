package com.cg.onlineeyecare.test.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineeyecare.test.dto.Test;
import org.springframework.stereotype.Repository;
/* 
 * @Repository is a Spring annotation that indicates that the decorated class is a repository. 
   A repository is a mechanism for encapsulating storage, retrieval, and search behavior which 
   emulates a collection of objects.
  
 * JpaRepository is a JPA (Java Persistence API) specific extension of Repository. It contains the
   full API of CrudRepository and PagingAndSortingRepository
*/
@Repository
public interface ITestRepository extends JpaRepository<Test,Integer> {

}

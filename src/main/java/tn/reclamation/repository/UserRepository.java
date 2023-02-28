package tn.reclamation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.reclamation.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}

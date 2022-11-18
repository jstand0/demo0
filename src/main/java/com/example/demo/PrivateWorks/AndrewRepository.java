package com.example.demo.PrivateWorks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AndrewRepository
    extends JpaRepository<Andrew, Long> {
    @Query("SELECT s FROM Andrew s WHERE s.email =?1")
    Optional<Andrew> findFriendsByEmail (String email);
}

package com.example.demo.PrivateWorks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndrewRepository
    extends JpaRepository<Andrew, Long> {
}

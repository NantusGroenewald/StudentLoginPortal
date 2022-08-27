package com.nantus.loginportal;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    
}

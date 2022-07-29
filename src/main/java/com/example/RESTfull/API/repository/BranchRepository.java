package com.example.RESTfull.API.repository;

import com.example.RESTfull.API.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository  extends JpaRepository<Branch, Integer> {
}

package com.example.RESTfull.API.repository;

import com.example.RESTfull.API.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}

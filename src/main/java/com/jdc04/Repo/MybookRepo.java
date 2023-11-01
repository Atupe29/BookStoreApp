package com.jdc04.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc04.Entity.MyBookList;

@Repository
public interface MybookRepo extends JpaRepository<MyBookList, Integer> {

}

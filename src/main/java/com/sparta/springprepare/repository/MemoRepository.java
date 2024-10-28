package com.sparta.springprepare.repository;


import com.sparta.springprepare.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
    List<Memo> findByContentsContainingOrderByModifiedAtDesc(String keyword);
}

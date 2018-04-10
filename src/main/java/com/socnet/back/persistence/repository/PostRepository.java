package com.socnet.back.persistence.repository;

import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
    List<PostModel> findAllByOwner(String owner);
}

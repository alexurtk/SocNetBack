package com.socnet.back.persistence.service.Impl;

import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.repository.PostRepository;
import com.socnet.back.persistence.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void savePost(PostModel post) {
        postRepository.save(post);
    }

    @Override
    public List<PostModel> getWallByOwner(String owner) {
        List<PostModel> result = postRepository.findAllByOwner(owner);
        Collections.reverse(result);
        return result;
    }

}

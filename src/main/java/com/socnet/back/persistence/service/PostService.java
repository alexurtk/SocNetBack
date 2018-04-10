package com.socnet.back.persistence.service;

import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.model.UserModel;

import java.util.List;


public interface PostService {
    void savePost(PostModel post);
    List<PostModel> getWallByOwner(String owner);
}

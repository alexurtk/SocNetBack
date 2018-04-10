package com.socnet.back.controller;

import com.socnet.back.persistence.model.MessageModel;
import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.service.PostService;
import com.socnet.back.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/getWallByOwner/{owner:.+}", method = RequestMethod.GET)
    public List<PostModel> getWallByOwner(@PathVariable("owner") String owner) {
        List<PostModel> wall = postService.getWallByOwner(owner);

        //fixme может быть ошибка на фронте из-за пустого списка с постами
//        if (wall != null)
//            wall.add(wall);

        return wall;
    }

    @RequestMapping(value = "/sendPost", method = RequestMethod.POST)
    public String createPost(@RequestBody PostModel post){
        try {
            postService.savePost(post);
        } catch (Exception e){
            return e.toString();
        }
        return "ok";  //при exception будет 0
    }
}

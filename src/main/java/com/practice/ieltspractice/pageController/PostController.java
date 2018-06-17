package com.practice.ieltspractice.pageController;
import com.practice.ieltspractice.model.Post;
import com.practice.ieltspractice.model.Reply;
import com.practice.ieltspractice.repository.PostRepository;
import com.practice.ieltspractice.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ReplyRepository replyRepository;


    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") long id)
    {
        List<Post> postList = postRepository.findById(id);
        model.addAttribute("post", postList.get(0));

        long postId = postList.get(0).getId();
        List<Reply> replyList = replyRepository.findAllByPostId(postId);
        model.addAttribute("replyList", replyList);
        return "post-detail";
    }

    @GetMapping("/list")
    public String list(Model model)
    {
        List<Post> postList = (List<Post>) postRepository.findAll();
        model.addAttribute("postList", postList);
        return "post-list";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name="title", required=true) String title, Model model)
    {
        postRepository.save(new Post(title));
        List<Post> postList = (List<Post>) postRepository.findAll();
        model.addAttribute("postList", postList);
        return "redirect:/";
    }

}











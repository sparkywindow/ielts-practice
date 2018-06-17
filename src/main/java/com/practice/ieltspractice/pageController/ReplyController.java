package com.practice.ieltspractice.pageController;
import com.practice.ieltspractice.model.Reply;
import com.practice.ieltspractice.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyRepository replyRepository;

//    @GetMapping("/{id}")
//    public String getByPost_id(Model model, @PathVariable("id") long post_id)
//    {
//        List<Reply> replyList = replyRepository.findByPost_id(post_id);
//        model.addAttribute("post", replyList.get(0));
//        return "post-detail";
//    }
//
//    @GetMapping("/list")
//    public String list(Model model)
//    {
//        List<Reply> postList = (List<Reply>) replyRepository.findAll();
//        model.addAttribute("postList", postList);
//        return "post-list";
//    }

    @PostMapping("/create")
    public String create(@RequestParam(name="postId", required=true) long postId,
                         @RequestParam(name="youtubeUrl", required=true) String youtubeUrl,
                         Model model)
    {
        replyRepository.save(new Reply(postId, youtubeUrl));
        return "redirect:/";
    }

}











package com.practice.ieltspractice.pageController;

import com.practice.ieltspractice.model.Post;
import com.practice.ieltspractice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class IndexController {

    @Autowired
    PostRepository postRepository;

    private static String UPLOADED_FOLDER = "/home/sparky/";

    @RequestMapping("/")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    {
        return "redirect:/post/list";
    }

    @GetMapping("/test")
    public String test(Model model)
    {
        postRepository.save(new Post("this is a test from index controller"));
        String title = postRepository.findByTitle("lil").get(0).toString();
        model.addAttribute("name", title);
        return "post-list";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("fileToUpload") MultipartFile file, RedirectAttributes redirectAttributes)
    {
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "post-list";
    }
}

package com.dandytiger.course.web.controller;

import com.dandytiger.course.domain.lecture.Lecture;
import com.dandytiger.course.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final LectureService lectureService;
    @GetMapping("/registration")
    public String courseRegistration(Model model){
        List<Lecture> lectures = lectureService.findLectures();
        model.addAttribute("lectures",lectures);
        return "courseRegistration/mainForm";
    }
    @GetMapping("/registration/test")
    public String test() {
        return "test";
    }

    // 지금은 회원가입이 없어서 일단 세션은 제외
    @PostMapping("/registration/{id}")
    public String requestCourseRegistration(@PathVariable("id") Long id){

        //

        return "redirect:/";
    }
}
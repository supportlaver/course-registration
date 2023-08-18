package com.dandytiger.course.web.controller;

import com.dandytiger.course.domain.lecture.Lecture;
import com.dandytiger.course.domain.lecturestudent.LectureStudent;
import com.dandytiger.course.domain.student.Student;
import com.dandytiger.course.service.LectureService;
import com.dandytiger.course.service.LectureStudentService;
import com.dandytiger.course.service.StudentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class LectureController {

    private final LectureService lectureService;
    private final StudentServiceImpl studentService;
    private final LectureStudentService lectureStudentService;


    //전공과목
    @GetMapping("/major")
    public String majorLecture(Model model, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(false);
        Student student = (Student) session.getAttribute("student");

        model.addAttribute("student", student);

        List<Lecture> lectures = lectureService.findMLecture(student.getMajor());

        model.addAttribute("lectures", lectures);

        List<LectureStudent> lectureStudents = lectureStudentService.findLectureStudents();
        model.addAttribute("lectureStudents",lectureStudents);

        return "courseRegistration/mainForm";
    }

    //교양과목
    @GetMapping("/generalElective")
    public String GELecture(Model model, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(false);
        Student student = (Student) session.getAttribute("student");

        model.addAttribute("student", student);

        List<Lecture> lectures = lectureService.findGELecture();

        model.addAttribute("lectures", lectures);

        List<LectureStudent> lectureStudents = lectureStudentService.findLectureStudents();
        model.addAttribute("lectureStudents",lectureStudents);

        return "courseRegistration/mainForm";
    }

//    @GetMapping("/searchLectureName")
    public String searchByLectureName(Model model, HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(false);
        Student student = (Student) session.getAttribute("student");

        model.addAttribute("student", student);

        String LectureName = httpServletRequest.getParameter("LectureName");
        List<Lecture> lectures = lectureService.findByLectureName(LectureName);

        model.addAttribute("lectures", lectures);

        List<LectureStudent> lectureStudents = lectureStudentService.findLectureStudents();
        model.addAttribute("lectureStudents",lectureStudents);

        return "courseRegistration/mainForm";
    }

    @GetMapping("/lectureName")
    public String searchByLectureName2(Model model, String LectureName,HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(false);
        Student student = (Student) session.getAttribute("student");

        model.addAttribute("student", student);

        List<Lecture> lectures = lectureService.findByLectureName(LectureName);

        model.addAttribute("lectures", lectures);

        List<LectureStudent> lectureStudents = lectureStudentService.findLectureStudents();
        model.addAttribute("lectureStudents",lectureStudents);

        return "courseRegistration/mainForm";
    }
    @GetMapping("/code")
    public String searchCode(Model model, HttpServletRequest httpServletRequest, String code) {

        HttpSession session = httpServletRequest.getSession(false);
        Student student = (Student) session.getAttribute("student");

        model.addAttribute("student", student);

        List<Lecture> lectures = lectureService.findByCode(code);

        model.addAttribute("lectures", lectures);

        List<LectureStudent> lectureStudents = lectureStudentService.findLectureStudents();
        model.addAttribute("lectureStudents",lectureStudents);

        return "courseRegistration/mainForm";
    }

    /**
     * 페이지 매핑해야함
     */

}

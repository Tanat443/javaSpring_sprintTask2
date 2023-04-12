package kz.springboot.bitltabdemo.controllers;

import kz.springboot.bitltabdemo.db.DBUtil;
import kz.springboot.bitltabdemo.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String homePage(Model model) {
        ArrayList<Student> students = DBUtil.getItems();
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping(value = "/addStudent")
    public String AddStudentPage() {
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "studentName", defaultValue = "No name") String name,
                             @RequestParam(name = "studentSurname", defaultValue = "No surname") String surname,
                             @RequestParam(name = "studentExam", defaultValue = "0") int exam) {
        String mark = "";
        if (exam > 0) {
            if (exam >= 50 && exam <= 59) {
                mark = "D";
            } else if (exam >= 60 && exam <= 74) {
                mark = "C";
            } else if (exam >= 75 && exam <= 89) {
                mark = "B";
            } else if (exam >= 90) {
                mark = "A";
            }
            mark = "F";
        }
        DBUtil.addItem(new Student(null, name, surname, exam, mark));
        return "redirect:/";
    }
}

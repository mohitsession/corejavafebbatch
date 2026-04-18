package com.learn.controller;

import com.learn.model.Student;
import com.learn.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    // ── LIST: GET /students ───────────────────────────────────
    @GetMapping
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "list";
    }

    // ── ADD FORM: GET /add ───────────────────────────
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    // ── ADD SUBMIT: POST /add ────────────────────────
    @PostMapping("/add")
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("student") Student student,
                      BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add";
        }

        if (service.emailExists(student.getEmail())) {
            result.rejectValue("email", "duplicate",
                               "Email is already registered.");
            return "add";
        }

        service.saveStudent(student);
        return "redirect:/students";
    }

    // ── EDIT FORM: GET /{id}/edit ────────────────────
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit";
    }

    // ── EDIT SUBMIT: POST /{id}/edit ─────────────────
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id,
                       @Valid @ModelAttribute("student") Student student,
                       BindingResult result) {

        if (result.hasErrors()) {
            return "edit";
        }

        if (service.emailTakenByOther(student.getEmail(), id)) {
            result.rejectValue("email", "duplicate",
                               "Email belongs to another student.");
            return "edit";
        }

        service.updateStudent(id, student);
        return "redirect:/students";
    }

    // ── DELETE: POST /{id}/delete ────────────────────
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}



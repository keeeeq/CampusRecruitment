package org.library.campusrecruitment.controller;

import org.library.campusrecruitment.pojo.Student;
import org.library.campusrecruitment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/student")
@Tag(name = "学生管理")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    @Operation(summary = "新增学生")
    public boolean addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除学生")
    public boolean deleteStudent(@PathVariable Integer id) {
        return studentService.removeById(id);
    }

    @PutMapping
    @Operation(summary = "更新学生")
    public boolean updateStudent(@RequestBody Student student) {
        return studentService.updateById(student);
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询学生")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @GetMapping
    @Operation(summary = "查询所有学生")
    public List<Student> getAllStudents() {
        return studentService.list();
    }

    @PostMapping("/login")
    @Operation(summary = "学生登录")
    public Map<String, Object> login(@RequestBody Student student) {
        Map<String, Object> result = new HashMap<>();
        Student found = studentService.lambdaQuery().eq(Student::getStudentNo, student.getStudentNo()).one();
        if (found != null && found.getPassword().equals(student.getPassword())) {
            result.put("success", true);
            result.put("data", found);
        } else {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
        }
        return result;
    }
}

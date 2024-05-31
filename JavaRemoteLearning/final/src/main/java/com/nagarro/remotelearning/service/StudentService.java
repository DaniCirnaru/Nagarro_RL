package com.nagarro.remotelearning.service;





import com.nagarro.remotelearning.model.Student;
import com.nagarro.remotelearning.repository.GenericRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private final GenericRepository<Student> studentRepository;

    public StudentService() throws SQLException {
        this.studentRepository = new GenericRepository<>(Student.class);
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    public void deleteStudent(int id) {
        studentRepository.delete(id);
    }

    public void saveStudents(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public List<Student> filterStudentsByField(String fieldName, Object value) {
        return studentRepository.filterByField(fieldName, value);
    }

    public List<Student> getStudentsPaginated(int pageNumber, int pageSize) {
        return studentRepository.findPaginated(pageNumber, pageSize);
    }
}

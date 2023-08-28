package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentConverterTest {

  @Test
  public void highAchieverTest() {
    List<Student> students = listStudentCase1();
    StudentConverter converter = new StudentConverter();
    List<Student> res = converter.convertStudents(students);
    assertFalse(res.isEmpty());
    assertEquals(1, res.size());
    assertTrue(res.get(0)
                  .isHonorRoll());
  }

  @Test
  public void exceptionalYoungHighAchieverTest() {
    List<Student> students = listStudentCase2();
    StudentConverter converter = new StudentConverter();
    List<Student> res = converter.convertStudents(students);
    assertFalse(res.isEmpty());
    assertEquals(3, res.size());
    assertTrue(res.get(0)
                  .isExceptional());
    assertTrue(res.get(1)
                  .isExceptional());
    assertFalse(res.get(2)
                   .isExceptional());
  }

  @Test
  public void passedStudentTest() {
    List<Student> studentList = new ArrayList<>();
    // Create and add student objects with grades between 71 and 90 (inclusive)
    studentList.add(createStudent("John", 18, 85, false, true));
    studentList.add(createStudent("Emily", 17, 75, true, false));
    studentList.add(createStudent("Michael", 19, 90, true, true));
    StudentConverter converter = new StudentConverter();
    List<Student> res = converter.convertStudents(studentList);
    assertFalse(res.isEmpty());
    assertEquals(3, res.size());
    assertTrue(res.get(0)
                  .isPassed());
    assertTrue(res.get(1)
                  .isPassed());
    assertTrue(res.get(2)
                  .isPassed());
  }

  @Test
  public void failedStudentTest() {
    List<Student> students = listStudentCase4();
    StudentConverter converter = new StudentConverter();
    List<Student> res = converter.convertStudents(students);
    assertFalse(res.isEmpty());
    assertEquals(1, res.size());
    assertFalse(res.get(0)
                   .isPassed());
  }

  @Test
  public void emptyList() {
    List<Student> students = new ArrayList<>();
    StudentConverter converter = new StudentConverter();
    List<Student> res = converter.convertStudents(students);
    assertTrue(res.isEmpty());
  }

  @Test
  public void inputIsNull() {
    StudentConverter converter = new StudentConverter();
    assertThrows(NullPointerException.class, () -> {
      converter.convertStudents(null);
    });

  }

  private ArrayList<Student> listStudentCase1() {
    List<Student> studentList = new ArrayList<>();
    // Creating Student objects and adding them to the list
    Student student1 = new Student();
    student1.setName("Alice");
    student1.setAge(20);
    student1.setGrade(95);
    student1.setHonorRoll(true);
    studentList.add(student1);
    Student student2 = new Student();
    student2.setName("Bob");
    student2.setAge(22);
    student2.setGrade(85);
    student2.setHonorRoll(false);
    studentList.add(student2);
    Student student3 = new Student();
    student3.setName("Charlie");
    student3.setAge(23);
    student3.setGrade(92);
    student3.setHonorRoll(false);
    studentList.add(student3);
    // Filtering students who are aged 21 or above and have a grade above 90
    ArrayList<Student> selectedStudents = new ArrayList<>();
    for (Student student : studentList) {
      if (student.getAge() >= 21 && student.getGrade() > 90) {
        selectedStudents.add(student);
      }
    }
    return selectedStudents;
  }

  private ArrayList<Student> listStudentCase2() {
    ArrayList<Student> studentList = new ArrayList<>();
    // Create student objects and add them to the list
    Student student1 = new Student();
    student1.setName("John");
    student1.setAge(19);
    student1.setGrade(95);
    student1.setHonorRoll(true);
    student1.setPassed(true);
    Student student2 = new Student();
    student2.setName("Jane");
    student2.setAge(20);
    student2.setGrade(92);
    student2.setHonorRoll(true);
    student2.setPassed(true);
    Student student3 = new Student();
    student3.setName("Alice");
    student3.setAge(18);
    student3.setGrade(88);
    student3.setHonorRoll(false);
    student3.setPassed(true);
    studentList.add(student1);
    studentList.add(student2);
    studentList.add(student3);
    // Add the 'Exceptional' field selectively
    for (Student student : studentList) {
      if (student.getAge() < 21 && student.getGrade() > 90) {
        student.setExceptional(true);
      }
    }
    return studentList;
  }

  private static Student createStudent(String name, int age, int grade, boolean exceptional, boolean honorRoll) {
    Student student = new Student();
    student.setName(name);
    student.setAge(age);
    student.setGrade(grade);
    student.setExceptional(exceptional);
    student.setHonorRoll(honorRoll);
    return student;
  }

  private ArrayList<Student> listStudentCase4() {
    List<Student> students = new ArrayList<>();
    // Creating and adding student objects
    Student student1 = new Student();
    student1.setName("Alice");
    student1.setAge(18);
    student1.setGrade(65);
    student1.setExceptional(false);
    student1.setHonorRoll(false);
    student1.setPassed(true);
    students.add(student1);
    Student student2 = new Student();
    student2.setName("Bob");
    student2.setAge(17);
    student2.setGrade(85);
    student2.setExceptional(false);
    student2.setHonorRoll(true);
    student2.setPassed(true);
    students.add(student2);
    // Add more student objects here...
    // Filter students with grade 70 or less
    ArrayList<Student> lowGradeStudents = new ArrayList<>();
    for (Student student : students) {
      if (student.getGrade() <= 70) {
        lowGradeStudents.add(student);
      }
    }
    return lowGradeStudents;
  }
}
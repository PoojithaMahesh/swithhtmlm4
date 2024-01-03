package studentm2withhtml.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import studentm2withhtml.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}
	
public void saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}

public List<Student> getAllStudents() {
	EntityManager entityManager=getEntityManager();
    Query query=entityManager.createQuery("Select s from Student s");
    List<Student> students= query.getResultList();
	return students;
}

public Student findStudentById(int id) {
	EntityManager entityManager=getEntityManager();
	Student student=entityManager.find(Student.class, id);
	return student;
	
}

public Student deleteStudentById(int id) {
	EntityManager entityManager=getEntityManager();
	Student student=entityManager.find(Student.class, id);
	if(student!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}else {
//		id is not present
		return null;
	}
}

public Student updateStudent(int id, Student student) {
	EntityManager entityManager=getEntityManager();
	Student dbStudent=entityManager.find(Student.class, id);
	if(dbStudent!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		student.setId(id);
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}else {
//		id is not present
		return null;
	}
}




}

package com.knoldus.hibernate;

import com.knoldus.hibernate.model.ClassRoom;
import com.knoldus.hibernate.model.Student;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Calendar cal = GregorianCalendar.getInstance();

		Student student1 = new Student("David Camron", cal.getTime(), "UK", "1234566");
		Student student2 = new Student("Bill Murray", cal.getTime(), "USA", "1234567");

		ClassRoom classRoom1 = new ClassRoom("Economics");
		ClassRoom classRoom2 = new ClassRoom("Politics");
		ClassRoom classRoom3 = new ClassRoom("Maths");

		student1.getClassRooms().add(classRoom1);
		student1.getClassRooms().add(classRoom2);
		student1.getClassRooms().add(classRoom3);

		student2.getClassRooms().add(classRoom1);
		student2.getClassRooms().add(classRoom2);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.persist(student1);
		session.persist(student2);
		
		List<Student> students = (List<Student>) session.createQuery("from Student ").list();
		for (Student s : students) {
			System.out.println("Student : " + s);
		}

		List<ClassRoom> classRoomList = (List<ClassRoom>) session.createQuery("from ClassRoom ").list();
		for (ClassRoom classRoom : classRoomList) {
			System.out.println("ClassRoom : " + classRoom);
		}
		

		session.getTransaction().commit();
		session.close();
	}

}

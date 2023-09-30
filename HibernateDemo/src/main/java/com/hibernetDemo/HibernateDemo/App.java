package com.hibernetDemo.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {	
//        Student st = new Student();
//        st.setId(2);
//        st.setName("Ram");
//        st.setRollNo(05);
//        st.setMarks(100);
    	
    	Student stud = null;
    	Student stud1 = null;
            
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sessionfactory = config.buildSessionFactory();
        Session session = sessionfactory.openSession();
//        Transaction transaction =session.beginTransaction();
        
        // Fatch data
        stud = session.get(Student.class, 1);
        
        // Save data
//        session.save(st);
//        transaction.commit();
        
        stud1 = session.get(Student.class, 1);
        
        
//        System.out.println(st);
        System.out.println(stud);
        System.out.println(stud1);
        
    } 
}
package com.hibernateFatch.hibernateFatchValue;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Customer customerOne=null;
    	
        Configuration con=new Configuration().configure().addAnnotatedClass(Customer.class);
        ServiceRegistry sr=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(sr);
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
        customerOne=(Customer)session.get(Customer.class, 1234);
        tr.commit();
        System.out.println(customerOne);
        
    }
}

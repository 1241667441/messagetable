package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory SF;
	
	static{
		Configuration conf = new Configuration().configure();
		
		SF = conf.buildSessionFactory();
	}
	
	public static Session openSession(){
		
		Session session = SF.openSession();
		return session;
	}
	
	public static Session getCurrentSession(){
		
		Session session = SF.getCurrentSession();
		return session;
	}

}

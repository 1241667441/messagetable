package getsendopterate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Utils.HibernateUtils;
import sqlbean.denglutable;

@Path("/user")
public class dengluoperator {
	@Path("/denglu")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public denglutable denglu(
			@QueryParam("name") String name,
			@QueryParam("password") String password)
	{
		denglutable user=new denglutable();
		user.setName(name);
		user.setPassword(password);
		System.out.println(user.toString());
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria c = session.createCriteria(denglutable.class);
		c.add(Restrictions.eq("name", user.getName()));
		denglutable user1 = (denglutable) c.uniqueResult();
		if(user1 != null){
			if(user1.getPassword().equals(user.getPassword())){
				return user1;
			}
		}
		return null;
	}

	//管理员登录
	@Path("/guanlidenglu")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public denglutable guanlidenglu(
			@QueryParam("name") String name,
			@QueryParam("password") String password)

	{
		denglutable user=new denglutable();
		user.setName(name);
		user.setPassword(password);
		System.out.println(user.toString());
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria c = session.createCriteria(denglutable.class);
		c.add(Restrictions.eq("name", user.getName()));
		c.add(Restrictions.eq("status", 1));
		denglutable user1 = (denglutable) c.uniqueResult();
		System.out.println(user1.toString());
		if(user1 != null){
			if(user1.getPassword().equals(user.getPassword())){
				return user1;
			}
		}
		return null;

	}

	//注册
	@Path("/zhuche")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public denglutable zhuche(
			@QueryParam("name") String name,
			@QueryParam("password") String password)
{
	denglutable user=new denglutable();
	user.setName(name);
	user.setPassword(password);
	user.setStatus(0);
	Session session = HibernateUtils.getCurrentSession();//操作数据库
	Transaction ts = session.beginTransaction();
	Criteria c = session.createCriteria(denglutable.class);
	c.add(Restrictions.eq("name", user.getName()));
	denglutable user1= (denglutable) c.uniqueResult();
	if(user1 != null){	
		return null;
	}
	else{
		session.save(user);
		ts.commit();
		return user;
	}

}

}

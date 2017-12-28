package getsendopterate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Utils.HibernateUtils;
import sqlbean.denglutable;
import sqlbean.messagetable;
@Path("/message")
public class message {
	
	
	//留言
	@Path("/sendmessage")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public List<messagetable> send(
			@QueryParam("message") String mess,
			@QueryParam("sendMessageUserName") String name)
	{
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		messagetable message=new messagetable();
		if(name.equals(""))
		{
         message.setName("匿名");			
		}
		else	
		{
			message.setName(name);
		}
		message.setMessage(mess);
		message.setTime(df.format(day));
		//System.out.println(message.toString());
		Session session = HibernateUtils.getCurrentSession();    //@连接数据库
		Transaction ts = session.beginTransaction(); //开启事务
		session.save(message);
		Criteria c = session.createCriteria(messagetable.class); //创建查询
		c.add(Restrictions.eq("respond", 1));   
		c.addOrder(Order.desc("time"));  //时间倒序
		List<messagetable> list = c.list();
		ts.commit();// 提交事务
		return list;
		
	} 
	
	//获取审核留言通过接口
	@Path("/getmessage")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public List<messagetable> get()
	{
		Session session = HibernateUtils.getCurrentSession(); 
		Transaction ts = session.beginTransaction();
		Criteria c = session.createCriteria(messagetable.class);
		c.add(Restrictions.eq("respond", 1));
		c.addOrder(Order.desc("time"));
		List<messagetable> list = c.list();
		ts.commit();
		return list;
		
	} 
	//获取未审核的留言
	@Path("/getnorespondmessage")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public List<messagetable> getnorespond()
	{
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria c = session.createCriteria(messagetable.class);
		c.add(Restrictions.eq("respond", 0));
		c.addOrder(Order.desc("time"));
		List<messagetable> list = c.list();
		ts.commit();
		return list;
		
	} 
	
	//审核
	@Path("/respond")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public List<messagetable> respond (@QueryParam(value="a") int id)
	{
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		
		messagetable message = session.load(messagetable.class, id);
		message.setRespond(1);
		session.update(message);
		Criteria c = session.createCriteria(messagetable.class);
		c.add(Restrictions.eq("respond", 0));
		c.addOrder(Order.desc("time"));
		List<messagetable> list = c.list();
		ts.commit();
		return list; 
		
	} 
	
	//删除留言
	@Path("/delete")
	@GET
	@Produces(MediaType.APPLICATION_JSON)  //返回数据的格式
	public List<messagetable> delete (@QueryParam(value="b") int id)
	{
		Session session = HibernateUtils.getCurrentSession();
		Transaction ts = session.beginTransaction();
		messagetable message = session.load(messagetable.class, id);
		session.delete(message);
		Criteria c = session.createCriteria(messagetable.class);
		c.add(Restrictions.eq("respond", 0));
		c.addOrder(Order.desc("time"));
		List<messagetable> list = c.list();
		ts.commit();
		return list;
		
	} 
	
}

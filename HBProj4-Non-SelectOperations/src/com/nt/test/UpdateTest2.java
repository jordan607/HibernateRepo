package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class UpdateTest2 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null; 
		Transaction tx=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		//load Cfg file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build Sesssion Factory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//Updating object with out ses.update(-)
		//Shows synchronization between obj and db table row
		//load object
		/*prod=ses.get(Product.class,1002);
		if(prod!=null){
			
		 try{
		  tx=ses.beginTransaction();
		    prod.setPrice(9465);
		  tx.commit();
		  System.out.println("Object updated");
		 }
		 catch(Exception e){
			tx.rollback();
			System.out.println("Object not updated");
		 }
		}
		else{
			System.out.println("record not found");
		}*/
		//Shows synchronization between obj and db table row
	/*prod=ses.get(Product.class,1002);
		if(prod!=null){
		  prod.setPrice(8767);
		  ses.flush();
		}
*/
		//showing sysnchronization between Db table row to Object
		prod=ses.get(Product.class,1002);
		System.out.println(prod.getPid()+prod.getPname()+" "+prod.getQty()+" "+prod.getPrice());
		try{
		Thread.sleep(30000); //modify 1002 record
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ses.refresh(prod);
		System.out.println(prod.getPid()+prod.getPname()+" "+prod.getQty()+" "+prod.getPrice());
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class

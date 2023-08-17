package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Task;
import dto.myuser;

public class userdao  {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	public void save(myuser user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	
	}
	public myuser findmyemail(String email) {
		
	List<myuser> list=entityManager.createQuery("select x from myuser x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty()){
			return null; 
		}
		else{
			return list.get(0);
		}
	}
		public void save(Task task1)
		{
			entityTransaction.begin();
			entityManager.persist(task1);
			entityTransaction.commit();
		
		}
	public List<Task> fetchAllTasks(){
		
	return entityManager.createQuery("select x from Task x").getResultList();
	}
	public void update(myuser user1) {
		
		entityTransaction.begin();
		entityManager.merge(user1);
		entityTransaction.commit();
	
	}
public void update(Task t) {
		
		entityTransaction.begin();
		entityManager.merge(t);
		entityTransaction.commit();
	
	}
	
	public Task fetchtask(int id) {
		
		return entityManager.find(Task.class, id);
	}
	public void remove(Task task) {
		entityTransaction.begin();
		entityManager.merge(task);
		entityTransaction.commit();
		
	}
	}

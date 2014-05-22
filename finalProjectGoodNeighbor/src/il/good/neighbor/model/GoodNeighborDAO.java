package il.good.neighbor.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class GoodNeighborDAO {
	private static SessionFactory factory;
	private static GoodNeighborDAO instance = null;

	private GoodNeighborDAO() {
		factory = new AnnotationConfiguration().configure()
				.addPackage("il.good.neighbor.model")
				.addAnnotatedClass(Volunteer.class)
				.addAnnotatedClass(Map.class)
				.addAnnotatedClass(Family.class)
				.buildSessionFactory();

	}

	public static GoodNeighborDAO getInstance() {
		if (instance == null) {
			instance = new GoodNeighborDAO();
		}
		return instance;
	}

	public void addNewMap(String areaName, String [] familiesID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Map mapToAdd = new Map(false, false, areaName, null, null);
			session.save(mapToAdd);	
			for (String string : familiesID) {
				int familyid = Integer.parseInt(string);
				Family family = (Family) session.get(Family.class, familyid);
				mapToAdd.getFamilies().add(family);
				family.setMap(mapToAdd);
				session.save(family);	
			}
					
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Family getFamilyById(String familyID) {
		Session session = factory.openSession();
		Transaction tx = null;
		Family family = null;
		Integer familyId = Integer.parseInt(familyID);
		try {
			tx = session.beginTransaction();
			family = (Family) session.get(Family.class, familyId);	
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return family;
	}
	
	public void addNewFamily(String firstName, String lastName, 
			String phoneNumber, String city, 
			String street, Integer houseNumber, 
			Integer appartmentNumber, String comments) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Family familyToAdd = new Family(firstName, lastName, phoneNumber, city, street, houseNumber, appartmentNumber, comments);
			session.save(familyToAdd);		
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	

	public boolean addNewVolunteer(String id, String fname, String lname,
			String email, String phoneNumber, String userName, String password) {
		boolean answer = false;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Volunteer volunteer = new Volunteer();
			volunteer.setId(id);
			volunteer.setFirstName(fname);
			volunteer.setLastName(lname);
			volunteer.setEmail(email);
			volunteer.setPhoneNumber(phoneNumber);
			volunteer.setUserName(userName);
			volunteer.setPassword(password);
			volunteer.setComing(false);
			volunteer.setApproved(false);
			volunteer.setMaps(null);
			session.save(volunteer);
			tx.commit();
			answer = true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return answer;
	}

	public String signIn(String userName, String password)
	{
		List<?> volunteers = null;
		boolean answer = false;
		String answerStr = "false";
		volunteers = getAllVolunteers();
		for (Iterator<?> iterator = volunteers.iterator(); iterator.hasNext();) 
		{
			Volunteer volunteer = (Volunteer) iterator.next();
			if (volunteer.getUserName().equals(userName)
					&& volunteer.getPassword().equals(password)) 
			{
				if(volunteer.isApproved() == false)
				{
					answerStr = "unApproved";
				}
				else
				{
					answerStr = "volunteerMenu";
				}
				answer = true;
				break;
			}
		}
		
		if(userName.equals("admin"))
		{
			if(answer == true)
			{
				answerStr = "manager";
			}
			else
			{
				answerStr = "falseManager";
			}
		}
		return answerStr;
	}

	public List<?> getAllVolunteers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<?> volunteers = null;
		try {
			tx = session.beginTransaction();
			volunteers = session.createQuery("FROM Volunteer").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return volunteers;
	}
	
	public List<?> getAllMaps() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<?> maps = null;
		try {
			tx = session.beginTransaction();
			maps = session.createQuery("FROM Map").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return maps;
	}
	
	public List<Family> getAllFamiliesWithoutMap() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<?> families = null;
		List<Family> familiesToRet = new ArrayList<Family>();
		try {
			tx = session.beginTransaction();
			families = session.createQuery("FROM Family").list();
			for (Object object : families) {
				Family f = (Family) object;
				if(f.getMap() == null)
				{
					familiesToRet.add(f);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return familiesToRet;
	}
	
	public List<Volunteer> getAllUnapprovedVolunteers() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<?> volunteers = null;
		List<Volunteer> volunteersToRet = new ArrayList<Volunteer>();
		try {
			tx = session.beginTransaction();
			volunteers = session.createQuery("FROM Volunteer").list();
			for (Object object : volunteers) {
				Volunteer v = (Volunteer) object;
				if(v.isApproved() == false)
				{
					volunteersToRet.add(v);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return volunteersToRet;
	}
	
	public List<?> getAllFamilies() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<?> families = null;
		try {
			tx = session.beginTransaction();
			families = session.createQuery("FROM Family").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return families;
	}
	
	public void approveVolunteers(String [] ids)
	{
		for (String id : ids) {
			approveNewVolunteer(id);
		}
	}
	
	public void approveNewVolunteer(String volunteerIdToApprove)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Volunteer volunteerToApprove = (Volunteer) session.get(Volunteer.class, volunteerIdToApprove);
			volunteerToApprove.setApproved(true);
			session.update(volunteerToApprove);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*public void updateMapFamilies(Integer MapID, Set<Family> families) {
		Session sssion = factory.openSession();
		Transaction tx = null;
		try {
			tx = sssion.beginTransaction();
			Map map = (Map) sssion.get(Map.class, MapID);
			for (Family family : map.getFamilies()) {
				family.setMap(null);
			}
			map.setFamilies(families);
			/*
			 * if(families != null) { for (Family family : families) {
			 * family.setMap(map); } }
			 
			sssion.update(map);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sssion.close();
		}
	}*/


	/*public void updateVolunteerMaps(String EmployeeID, Integer mapID) {
		Session sssion = factory.openSession();
		Transaction tx = null;
		try {
			tx = sssion.beginTransaction();
			Volunteer volunteer = (Volunteer) sssion.get(Volunteer.class,
					EmployeeID);
			Map map = (Map) sssion.get(Map.class, mapID);

			Set<Map> maps = new HashSet<>();
			maps.add(map);
			volunteer.setMaps(maps);
			if (maps != null) {
				for (Map mapp : maps) {
					mapp.setVolunteer(volunteer);
				}
			}
			sssion.update(volunteer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sssion.close();
		}
	}*/
	
	public void updateFamilyDetails(Integer familyID, String firstname,
	String lastname, String phoneNumber, String city, String street,
	Integer houseNumber, Integer appartmentNumber, String comments) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Family familyToUpdate = (Family) session.get(Family.class, familyID);
			familyToUpdate.setFirstName(firstname);
			familyToUpdate.setLastName(lastname);
			familyToUpdate.setPhoneNumber(phoneNumber);
			familyToUpdate.setCity(city);
			familyToUpdate.setStreet(street);
			familyToUpdate.setHouseNumber(appartmentNumber);
			familyToUpdate.setStreetNumber(houseNumber);
			familyToUpdate.setComments(comments);
			session.update(familyToUpdate);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
				e.printStackTrace();
		} finally {
			session.close();
		}
	}
	/*public void updateVolunteerDetails(String EmployeeID, String fname,
			String lname, String email, String phoneNumber, String userName,
			String password, Boolean isComing) {
		Session sssion = factory.openSession();
		Transaction tx = null;
		try {
			tx = sssion.beginTransaction();
			Volunteer volunteer = (Volunteer) sssion.get(Volunteer.class,
					EmployeeID);
			volunteer.setFirstName(fname);
			volunteer.setLastName(lname);
			volunteer.setEmail(email);
			volunteer.setPhoneNumber(phoneNumber);
			volunteer.setUserName(userName);
			volunteer.setPassword(password);
			volunteer.setIsComing(isComing);
			sssion.update(volunteer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			sssion.close();
		}
	}*/

	public void deleteVolunteer(String EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Volunteer volunteer = (Volunteer) session.get(Volunteer.class,
					EmployeeID);
			session.delete(volunteer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}

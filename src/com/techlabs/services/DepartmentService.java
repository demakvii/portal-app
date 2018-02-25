package com.techlabs.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techlabs.entity.Department;
import com.techlabs.hibernate.util.HibernateUtil;

public class DepartmentService {

	public boolean addDepartment(Department department) {
		Session session = HibernateUtil.openSession();
		if (isDepartmentExists(department.getDeptId()))
			return false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.save(department);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return true;
	}

	public boolean isDepartmentExists(int deptId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Department deptResult = (Department) session.get(Department.class,
					deptId);
			if (deptResult != null)
				result = true;
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public List<Department> getDeptList() {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		List<Department> deptList = new ArrayList<Department>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createSQLQuery("select * from Departments")
					.addEntity(Department.class);
			deptList = query.list();
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return deptList;
	}

	public boolean deleteDepartmentById(int deptId) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			Department deptResult = (Department) session.get(Department.class,
					deptId);

			if (deptResult != null) {

				session.delete(deptResult);
				result = true;
			} else
				result = false;
			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Department getDepartmentById(int deptId) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		Department deptResult = null;
		try {
			tx = session.getTransaction();
			tx.begin();

			deptResult = (Department) session.get(Department.class, deptId);

			tx.commit();

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return deptResult;
	}

	public boolean editDepartment(Department editDept) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(editDept);
			tx.commit();
			result = true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

}

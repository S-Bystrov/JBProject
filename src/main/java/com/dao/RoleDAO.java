package com.dao;

import com.entity.Role;
import com.entity.User;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoleDAO {

    public Role getRole(int roleId) {
        Transaction transaction = null;
        Role role = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            role = session.createQuery("from Role where id_roles = :id_roles", Role.class)
                    .setParameter("id_roles", roleId)
                    .getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return role;
    }
}



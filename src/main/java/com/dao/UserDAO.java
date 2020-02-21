package com.dao;

import com.entity.User;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO implements DAO<User> {

    @Override
    public void save(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public User findById(int id) {
        Transaction transaction = null;
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }


    public User getUserByLogin (String login){
        Transaction transaction = null;
        User user = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            user = session.createQuery("from User where login = :login", User.class)
                    .setParameter("login", login)
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers(){
        Transaction transaction = null;
        List<User> listOfUsers = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            listOfUsers = session.createQuery("From User").getResultList();
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUsers;
    }
}

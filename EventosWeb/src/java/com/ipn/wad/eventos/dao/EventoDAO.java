/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.wad.eventos.dao;

import com.ipn.wad.eventos.entidades.Evento;
import com.ipn.wad.eventos.utilerias.HibernateUtil;
import java.util.Collection;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author darkmac
 */
public class EventoDAO {

    public void crear(Evento e) throws HibernateException {
        Session session = HibernateUtil.
                getSessionFactory().getCurrentSession();

        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.save(e);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void actualizar(Evento e) throws HibernateException {
        Session session = HibernateUtil.
                getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(e);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Evento mostrarEvento(Evento evento) throws HibernateException {
        Session session = HibernateUtil.
                getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            evento = (Evento) session.get(evento.getClass(), evento.getId());
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return evento;
    }

    public void borrar(Evento evento) throws HibernateException {
        Session session = HibernateUtil.
                getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(evento);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection listar() throws HibernateException {
        Session session = HibernateUtil.
                getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List l = null;
        try {
            transaction.begin();
            Query q = session.createQuery("from Evento");
            l = q.list();
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return l;
    }

}

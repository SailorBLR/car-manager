package com.emerline.hubarevich.dao;

import com.emerline.hubarevich.dao.exception.DaoException;
import com.emerline.hubarevich.domain.Domain;

import java.util.List;

/**
 * Interface for common CRUD operations
 * @param <T> Class-entity extends Domain
 */
public interface AbstractDAO <T extends Domain> {
    /**
     * @return List of all Objects Domain from database
     * @throws DaoException if SQLException thrown
     */
    List<T> findAll() throws DaoException;

    /**
     * finds the Domain by it's id
     * @param id unique Domain identification number
     * @return Domain object
     * @throws DaoException if SQLException thrown
     */
    T findDomainById(Long id) throws DaoException;

    /**
     * deletes Domain by it's ID
     * @param id unique Domain identification number
     * @throws DaoException if SQLException thrown
     */
    void delete(Long id) throws DaoException;

    /**
     * deletes the field in DB by Object class Domain
     * @param domain Object class T extends Domain
     * @return true if the deleting is successfully
     * @throws DaoException if SQLException thrown
     */

    Long create(T domain) throws DaoException;

    /**
     * updates a field in DB by Object class extends Domain
     * @param domain Object class T extends Domain
     * @throws DaoException if SQLException thrown
     */
    void update(T domain) throws DaoException;

    /**
     * finds a field in DB by Object class extends Domain
     * @param domain Object class T extends Domain
     * @return Domain object
     * @throws DaoException if SQLException thrown
     */
}

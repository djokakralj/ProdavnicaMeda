/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface Repository<T> {

    void add(T param) throws Exception;

    void delete(T param) throws Exception;

    List<T> getAll(T param, String uslov) throws Exception;

    void edit(T param) throws Exception;

    int addReturnKey(T param) throws Exception;

    T login(T param) throws Exception;

}

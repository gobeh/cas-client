/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uinjkt.cas.casclient.dao;

import id.ac.uinjkt.cas.casclient.entity.UsersApp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersDao extends PagingAndSortingRepository<UsersApp, String> {

    @Query("SELECT u FROM userclient u WHERE u.email = :email AND u.active = 1")
    public UsersApp findByEmailUsers(String email);
}

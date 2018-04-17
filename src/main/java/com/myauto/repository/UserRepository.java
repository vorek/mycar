package com.myauto.repository;

import com.myauto.entity.AppUser;
import com.myauto.ids.AppUserId;

/**
 * 
 * ”правление хранилищем пользователей
 * @author ozaytsev
 *
 */
public interface UserRepository {

    void add(AppUser user);

    AppUser get(AppUserId id);

    AppUser findUserByEmail(String email);
}

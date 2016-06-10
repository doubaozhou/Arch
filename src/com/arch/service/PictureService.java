package com.arch.service;

import com.arch.dao.Dao;
import com.arch.dao.impl.DaoImpl;
import com.arch.entity.Picture;
import com.sun.corba.se.pept.transport.Connection;

/**
 * Created by I331314 on 2016/6/10.
 *
 * @author zhou
 */
public class PictureService {
    private Dao userDao = new DaoImpl();

    public Picture QueryPicture(String id) {
        Connection conn;

        return null;
    }
}

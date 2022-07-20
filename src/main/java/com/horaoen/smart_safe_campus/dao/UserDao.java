package com.horaoen.smart_safe_campus.dao;

import com.horaoen.smart_safe_campus.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author horaoen
 */
@Mapper
public interface UserDao {

    List<User> getAll();

}

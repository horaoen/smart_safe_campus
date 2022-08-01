package com.horaoen.smart_safe_campus.core.security;

import com.horaoen.smart_safe_campus.dao.RoleDao;
import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVoWithPermissionsVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String token= principals.toString();
        String username = JwtUtil.getUsername(token);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        User user = userDao.findUserByUsername(username);
        RoleDetailVoWithPermissionsVo roleDetailWithPermissions = roleDao.getRoleDetailWithPermissionsByRoleId(user.getRoleId());
        List<String> permissions = roleDetailWithPermissions.getPermissions();
        Set<String> perm = new HashSet<String>(permissions);
        Set<String> roles = new HashSet<String>(Collections.singleton(roleDetailWithPermissions.getRoleName()));
        info.setRoles(roles);
        info.setStringPermissions(perm);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtil.getUsername(token);

        User user = userDao.findUserByUsername(username);
        try {
            JwtUtil.verify(token, username, user.getPassword());
            return new SimpleAuthenticationInfo(token, token, getName());
        } catch (Exception e) {
            throw new AuthenticationException("token错误");
        }
    }
}

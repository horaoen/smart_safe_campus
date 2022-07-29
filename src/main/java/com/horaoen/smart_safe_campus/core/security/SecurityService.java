package com.horaoen.smart_safe_campus.core.security;

import com.horaoen.smart_safe_campus.dao.RoleDao;
import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.mbg.model.Role;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.vo.RoleDetailVoWithPermissionsVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public AuthenticationInfo getCommonAuthenticationInfo(AuthenticationToken authenticationToken, String realmName) {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        String username = userToken.getUsername();
        return getAuthenticationInfo(realmName, username);
    }

    private AuthenticationInfo getAuthenticationInfo(String realmName, String username) {
        User user = userDao.findUserByUsername(username);
        if(user == null){
            throw new UnknownAccountException("用户不存在");
        } else {
            SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();

            Role role = userDao.getRoleByUserId(user.getId());
            principalCollection.add(role.getRoleName(), realmName);

            RoleDetailVoWithPermissionsVo roleDetail = roleDao.getRoleDetailWithPermissionsByRoleId(role.getId());
            principalCollection.addAll(roleDetail.getPermissions(), realmName);

            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principalCollection, user.getPassword(), realmName);
            return authenticationInfo;
        }
    }

    public AuthenticationInfo getJWTAuthenticationInfo(AuthenticationToken authenticationToken, String realmName) {
        JWTToken userToken = (JWTToken) authenticationToken;
        String username = userToken.getPrincipal().toString();
        return getAuthenticationInfo(realmName, username);
    }
}

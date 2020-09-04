package pl.mr.weekop.service;

import pl.mr.weekop.dao.DAOFactory;
import pl.mr.weekop.dao.UserDAO;
import pl.mr.weekop.model.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserService {
    public void addUser(String username,String email,String password){
        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        String md5Pass=encryptPassword(password);
        user.setPassword(md5Pass);
        user.setActive(true);
        DAOFactory factory=DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.create(user);
    }

    private String encryptPassword(String password) {
        MessageDigest digest=null;
        try {
            digest=MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        digest.update(password.getBytes());
        String md5Password=new BigInteger(1,digest.digest()).toString(16);
        return md5Password;
    }

    public User getUserById(long userId){
        DAOFactory factory=DAOFactory.getDAOFactory();
        UserDAO userDAO=factory.getUserDAO();
        User user=userDAO.read(userId);
        return user;
    }

    public User getUserByUsername(String username){
        DAOFactory factory=DAOFactory.getDAOFactory();
        UserDAO userDAO=factory.getUserDAO();
        User user=userDAO.getUserByUsername(username);
        return user;
    }
}

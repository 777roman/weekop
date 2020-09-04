package pl.mr.weekop.dao;

import pl.mr.weekop.dao.VoteDAOImpl;

public class MysqlDAOFactory extends DAOFactory{
    @Override
    public DiscoveryDAO getDiscoveryDAO() {
        return new DiscoveryDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public VoteDAO getVoteDAO() {
        return new VoteDAOImpl();
    }
}

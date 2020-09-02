package pl.mr.weekop.service;

import pl.mr.weekop.dao.DAOFactory;
import pl.mr.weekop.dao.VoteDAO;
import pl.mr.weekop.model.Vote;
import pl.mr.weekop.model.VoteType;

import java.sql.Timestamp;
import java.util.Date;

public class VoteService {
    public Vote addVote(long discoveryId, long userId, VoteType voteType){
        Vote vote=new Vote();
        vote.setDiscoveryId(discoveryId);
        vote.setUserId(userId);
        vote.setDate(new Timestamp(new Date().getTime()));
        vote.setVoteType(voteType);
        DAOFactory factory=DAOFactory.getDAOFactory();
        VoteDAO voteDAO=factory.getVoteDAO();
        vote=voteDAO.create(vote);
        return vote;
    }
}

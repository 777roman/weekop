package pl.mr.weekop.dao;

import pl.mr.weekop.model.Vote;

public interface VoteDAO extends GenericDAO<Vote,Long> {
    public Vote getVoteByUserIdDiscoveryId(long userId,long discoveryId);
}

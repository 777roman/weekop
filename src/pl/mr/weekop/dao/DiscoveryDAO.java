package pl.mr.weekop.dao;

import pl.mr.weekop.model.Discovery;

import java.util.List;

public interface DiscoveryDAO extends GenericDAO<Discovery,Long> {
    List<Discovery> getAll();
}

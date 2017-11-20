package vhcsoft.blog.oa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vhcsoft.blog.oa.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

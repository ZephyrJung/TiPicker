package org.b3log.zephyr.solr;

/**
 * Created by yaya on 17-3-1.
 */
import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

    List<Product> findByNameStartingWith(String name);

}
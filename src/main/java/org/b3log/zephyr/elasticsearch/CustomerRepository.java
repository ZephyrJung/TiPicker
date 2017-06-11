package org.b3log.zephyr.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.get.GetField;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by yu.zhang on 2017/6/1.
 */
@Repository
public class CustomerRepository{

    public Customer findByFirstName(String firstName) {
        Client client = null;
        try {
            client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
            GetResponse response = client.prepareGet("customer", "customer", "test").execute().actionGet();
            GetField field = response.getField("firstName");
            SearchResponse searchReponse = client.prepareSearch("customer")
                    .setTypes("customer")
                    .setSearchType(SearchType.DEFAULT)
                    .setQuery(QueryBuilders.termQuery("multi","zephyr"))
//                    .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))
//                    .setFrom(0).setSize(60).setExplain(true)
                    .execute()
                    .actionGet();
            System.out.println(field.getValue().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }finally {
            client.close();
        }
        return null;
    }

    public List<Customer> findByLastName(String lastName) {
        return null;
    }
}

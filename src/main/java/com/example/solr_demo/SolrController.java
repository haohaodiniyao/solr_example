package com.example.solr_demo;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by yaokai on 2017/6/19.
 */
@RestController
public class SolrController {
    @Autowired
    private SolrClient solrClient;
    @RequestMapping("/show")
    public SolrDocumentList show(){
        try{
//           SolrDocument solrDocument = solrClient.getById("jobs","SOLR1000");
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery("*:*");
            solrQuery.setRows(20);
            SolrDocumentList solrDocumentList = solrClient.query(solrQuery).getResults();
            return solrDocumentList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

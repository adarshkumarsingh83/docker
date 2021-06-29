package com.espark.adarsh.client;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolrJClientApplication {

    public static void main(String[] args) throws Exception {
		/* run
		   ```
		   $ docker-compose up
		   $ curl -X POST \
		          -H "Content-Type: application/json" \
		          'http://localhost:8983/solr/admin/configs?action=CREATE&name=myconfig&baseConfigSet=_default'
		   $ curl -X POST \
		         -H "Content-Type: application/json" \
		         'http://localhost:8983/solr/admin/collections?action=CREATE&name=collection1&numShards=2&replicationFactor=2&maxShardsPerNode=2&collection.configName=myconfig'
		   ...
		   $ docker-compose down && docker volume rm hellosolr_solrdata1 hellosolr_solrdata2
		   ```
		*/

        final String serverUrl = (args != null && args.length > 0) ? args[0] : "http://localhost:8983/solr/collection1";
        // Connect to the Solr server at the specified
        // URL, such as http://localhost:8983/solr/collection1
        SolrClient solr = new HttpSolrServer(serverUrl);

        // Use a SolrInputDocument object to build a document to be indexed
        SolrInputDocument doc1 = new SolrInputDocument();
        doc1.setField("id", "1");
        doc1.setField("screen_name_s", "@thelabdude");
        doc1.setField("type_s", "post");
        doc1.setField("lang_s", "en");
        doc1.setField("timestamp_tdt", "2012-05-22T09:30:22Z/HOUR");
        doc1.setField("favorites_count_ti", "10");
        doc1.setField("text_t", "#Yummm :) Drinking a latte at Caffe Greccoin SF's historic North Beach... Learning text analysis with#SolrInAction by @ManningBooks on my i-Pad");

        // Send the SolrInputDocument to the Solr update request handler over HTTP
        solr.add(doc1);

        SolrInputDocument doc2 = new SolrInputDocument();
        doc2.setField("id", "2");
        doc2.setField("screen_name_s", "@thelabdude");
        doc2.setField("type_s", "post");
        doc2.setField("lang_s", "en");
        doc2.setField("timestamp_tdt", "2012-05-22T09:30:22Z/HOUR");
        doc2.setField("favorites_count_ti", "10");
        doc2.setField("text_t", "Just downloaded the ebook of #SolrInAction from @ManningBooks http://bit.ly/T3eGYG to learn more about #Solr http://bit.ly/3ynriE");

        // Use the addField method to add  multivalues for multivalued fields.
        doc2.addField("link_ss", "http://manning.com/grainger/");
        doc2.addField("link_ss", "http://lucene.apache.org/solr/");

        solr.add(doc2);

        // Do a normal or “hard” commit to make these new docs searchable.
        solr.commit(true, true);

        for (SolrDocument next : simpleSolrQuery(solr, "*:*", 10)) {
            prettyPrint(System.out, next);
        }
    }

    // Use a SolrQuery object to construct the match all docs query.
    static SolrDocumentList simpleSolrQuery(SolrClient solr, String query, int rows) throws SolrServerException, IOException {
        SolrQuery solrQuery = new SolrQuery(query);
        solrQuery.setRows(rows);
        QueryResponse resp = solr.query(solrQuery);
        return resp.getResults();
    }

    // prettyPrint each SolrDocument in the results to stdout.
    static void prettyPrint(PrintStream out, SolrDocument doc) {
        List<String> sortedFieldNames = new ArrayList<>(doc.getFieldNames());
        Collections.sort(sortedFieldNames);
        out.println();
        for (String field : sortedFieldNames) {
            out.println(String.format("\t%s: %s", field, doc.getFieldValue(field)));
        }
        out.println();
    }

}

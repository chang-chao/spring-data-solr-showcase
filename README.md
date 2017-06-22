Spring Data Solr Showcase
=========================

This example shows basic usage concepts of [Spring Data Solr](http://projects.spring.io/spring-data-solr).

In order to run this example a 4+ [Solr Server](http://lucene.apache.org/solr/downloads.html) and [Maven](http://maven.apache.org/download.cgi) are required.

The application is meant to work with the example data provided by the Solr distribution.

### Running Solr
```emacs
:solr> ./bin/solr start -e techproducts
```

Access via [localhost:8983/solr/](http://localhost:8983/solr/#/techproducts)

### Running Showcase
```emacs
:spring-data-solr-showcase> mvn spring-boot:run
```

Access via [localhost:8080/search](http://localhost:8080/search)

### Notice:
For the issue of [Inconsistencies with SolrTemplate with Multiple Cores](https://jira.spring.io/browse/DATASOLR-403),the product detail page can not be shown currently.
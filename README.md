**Spring JPA Data Access**
==========================

I created this repository to test data access to a SQL database using Spring JPA. 

**File Organization**
-----------------

src->main->java

 - com.puente.app: Includes methods for accessing the database
 - com.puente.dao: Include interface and interface implementation file
 - com.puente.domain: POJOs

src->main->resources

 - app-context-annotation.xml: Configuration file, which includes some beans

src->main->resources-sql

 - schema.sql: SQL schema
 - test-data.sql: Sample data used to populate the database

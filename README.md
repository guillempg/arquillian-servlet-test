# arquillian-servlet-test

In order to make it work, you must first install tomcat7 somewhere into your system.
Then, edit src/test/resources/arquillian.xml so that "catalinaHome" property points to
the installation folder of Apache Tomcat 7:

<property name="catalinaHome">/usr/software/apache-tomcat-7.0.92</property>

Remember to configure Tomcat7 context.xml file, if the Servlet needs access to databases...
Also, in order for Arquillian to manage deploying and undeploying, edit Tomcat7 file:

conf/tomcat-users.xml

so that the user (with password) defined in arquillian.xml has "manager-script" role:

For instance:


<tomcat_users>
    <role rolename="manager-gui"/>
    <role rolename="manager-jmx"/>
    <role rolename="manager-script"/>
    <user username="tomcat" password="tomcat" roles="manager-script, manager-jmx, manager-gui"/>
</tomcat-users>



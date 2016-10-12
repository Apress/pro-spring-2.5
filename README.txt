Pro Spring 2.5 chapter source code

These directories contain complete source code for the relevant chapters
of Pro Spring 2.5.

If you are using IntelliJ IDEA 7.0, you can open the bookcode.ipr project
file, which will open the entire book's source code. If you are using
some other IDE, you can import bookcode.ipr, or you can set up the
project manually.

To open, compile & run the source code, you will need JDK 1.5 or 1.6, 
Apache Ant, AspectJ and Apache Tomcat 5.5 or 6.0. We have used Oracle 10g 
as our RDBMS, you can use the freely available Oracle 10g Express Edition
from http://otn.oracle.com. Whenever possible, we followed the ANSI SQL
standard in our SQL statements, therefore using a different relation
database management server should not cause any major problems.

The directory structure follows the standard Maven 2 structure. In each 
chapter code directory, you will find:

src/main/java         The packages and classes
src/main/resources    Non-Java files (e.g. Spring Application Context files)

In some chapters, you will also find unit and integration tests in

src/test/java         The test packages and classes
src/test/resources    The test non-Java files

Additionally, in web applications, you will find

WEB-INF/              Web application-specific files (servlet configuration,
                      JSP files, etc.)

You can build & run the source code for all chapters except for chapter 6.
To try compile-time weaving discussed in chapter 6, you will need to use
Apache Ant and the AspectJ compiler. We explain the details of this process
in chapter 6.
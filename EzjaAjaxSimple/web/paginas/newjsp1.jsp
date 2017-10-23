<%-- 
    Document   : newjsp1
    Created on : 02-mar-2012, 18:26:04
    Author     : asuncionez

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<sql:query var="rs" dataSource="jdbc/Ezja">
select cv_entidad, nombre from cat_entidad
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    Foo ${row.cv_entidad}<br/>
    Bar ${row.nombre}<br/>
</c:forEach>

  </body>
</html>
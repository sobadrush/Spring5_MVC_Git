﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
		  <%--insert css here--%>
		  <%--@import url('');--%>
	</style>
	<script>
		  <%--insert JScript here--%>
		  <%--<script src=""></script>--%>
	</script>
  </head>
  <body>
      <h1 style="color:pink">Index.jsp</h1>
      <a href="<%=request.getContextPath()%>/spring_mvc/empCRUD/testTest">測試</a> <br/>
      <a href="<%=request.getContextPath()%>/spring_mvc/empCRUD/getAllEmps?isEager=true">getAllEmps</a> <br/>
      
      <hr/>
      <h2>瀏覽器直接Key : </h2><b style="color:blue;">http://localhost:8080/Spring5_MVC_test/spring_mvc/empCRUD/getAllEmps_By_PathVarizble/<span style="color:red">false</span></b><br>
      <h2>瀏覽器直接Key : </h2><b style="color:blue;">http://localhost:8080/Spring5_MVC_test/spring_mvc/empCRUD/getAllEmps_By_PathVarizble/<span style="color:green">true</span></b><br>
  </body>
</html>

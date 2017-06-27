<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="atj.*" %>
<HTML>
<HEAD>
<TITLE>Session</TITLE>
</HEAD>

<BODY>

<P>

<jsp:useBean class="atj.MySessionCounter"
          id="servContextName" scope="application" />


<br>Number of sessions:
  <jsp:getProperty name="servContextName"
              property="numberOfSession" />



</BODY>
</HTML>
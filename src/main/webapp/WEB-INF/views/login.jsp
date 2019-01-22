<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:spring="http://www.springframework.org/tags"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:form="http://www.springframework.org/tags/form" version="2.0">
    <jsp:directive.page language="java" contentType="text/html" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>Reporting Service - Login</title>

<style type="text/css">

body {
	margin: 1%; 	padding: 1%;
	text-align: center;
	font: normal 73%/1.5em roboto,Helvetica,Arial,sans-serif;
	font-family: helveticathin;
	color: #65944A;
	/*background-color:#f9f9f9;*/
	position:relative;
	text-align:center;
	vertical-align:middle;
	horizontal-align:middle;
	/*display:inline-block;*/
	
	
}

 form {
	
	/*padding-left:5px;
	padding-top:5px;
	margin:10%;*/
	/*height:20%;*/
margin-top:20px;
margin-left:23%;
	width:50%;
	/*float: middle;*/
	line-height: 1.2em;
	/*border: 1px solid black; */
	background-color: #f2f2f2; 
	border.radius: 15px 15px 15px 15px;	
	-moz-border-radius:15px 15px 15px 15px;
	-webkit-border-radius:15px 15px 15px 15px;
}
/* links */
a { background: inherit; color: #6c8d31; text-decoration: none; }
a:hover { background: inherit; color: #babebf; text-decoration: underline; }

label {
	display:block;
	margin:5px 0;
	color:#707070;
	font: bold 1.2em roboto,Helvetica,Arial,sans-serif;
	width:150px;
	display:inline;
	padding-left:5px;
	padding-top:5px;
	margin-left:15px;
	border-left: 1px solid #427314;

}
input {
	padding: 2px;
	margin-right:2px;
	border:1px solid #6c8d31;
	font: normal 1.2em roboto,Helvetica,Arial,sans-serif;
	color:#777;
	/*background-color: #6c8d31;*/
}

.btn_submit {
	padding: 2px;
	border:1px solid #B6D59A;
	background-color:#6c8d31;
	text-decoration: none;
	font: normal 1.2em roboto,Helvetica,Arial,sans-serif;
	color:white;
}

.btn_submit:hover { background: inherit; color: #babebf; text-decoration: underline; }

/* headers */
h1, h2, h3 { font: bold 1.1em roboto,Helvetica,Arial,sans-serif; }
h1 { font-size: 1.4em; color: #65944A; }
h2 { font-size: 1.2em; text-transform: uppercase; }
h3 { font-size: 1.2em; }
</style>
  
  
</head>
<body>
<br></br><br></br><br></br><br></br>
 <br></br>
             
    <c:url value="/login" var="loginUrl"/>
    <form:form name="f" action="${loginUrl}" method="post">
       <!--  <fieldset> -->
        
             <br></br>
             <br></br>
             <br></br>
            <h1>Reporting Service System - Please Login</h1>
              <br></br>
              <br></br>
             <br></br>
            <c:if test="${param.error != null}">
                <div class="alert alert-error">
                    Invalid username and password.
                </div>
            </c:if>
           <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    You have been logged out.
                </div>
            </c:if>
            <label for="username">Username:  </label>
            <input type="text" id="username" name="username" value="admin"/>
            <label for="password">Password:  </label>
            <input type="password" id="password" name="password" value="admin"/>
            
            <div class="form-actions">
            <br></br>
                <button type="submit" class="btn">Log in</button>
               
            </div>
             <br></br>
             <br></br>
             <br></br>
             <br></br>
             <br></br>
       <!--  </fieldset>   -->
    </form:form>
</body>
</html>
</jsp:root>
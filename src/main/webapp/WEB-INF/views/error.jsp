<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico" />

<meta name="Description" content="Allocation Information." />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Distribution" content="internal" />
<meta name="Author" content="Alvaro Sanchez -alvaro.sanchez@everis.com" />

<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/general.css" type="text/css" />
<link rel="stylesheet" href="css/jquery-confirm.css" type="text/css" />


<script type="text/javascript" src="js/downloadToCSV.js"></script>
<script type="text/javascript" src="js/app-ajax.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="js/validationsAndGenericFunctions.js"></script>
<script type="text/javascript" src="js/jquery-confirm.js"></script>

<!-- Google Loader - Charts -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<!-- DataTable -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

	<!-- Google Charts -->
	<script type="text/javascript" src="js/loader.js"></script>

	<!-- Jquery Functions -->
	<script type="text/javascript" src="js/popUpJQuery.js"></script>
	<script type="text/javascript" src="js/downloadToCSV.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error page</title>
</head>
<body>
<br></br>
<h2><center><b>Error</b></center></h2>
<center>
 <table>
        <tr>
            <td>Date</td>
            <td>${timestamp}</td>
        </tr>
        <tr>
            <td>Error</td>
            <td>${error}</td>
        </tr>
        <tr>
            <td>Status</td>
            <td>${status}</td>
        </tr>
        <tr>
            <td>Message</td>
            <td>${message}</td>
        </tr>
        <tr>
            <td>Cause</td>
            <td>${trace}</td>
        </tr>
       <!--   <tr>
            <td>Trace</td>
            <td>
                <pre>${trace}</pre>
            </td>
        </tr>-->
    </table>
<center>
<br></br>
		<center><a href="javascript:window.history.go(-1)" style='color: #6c8d31; text-decoration: underline;'>Click to back to the previous page</a></center>
</body>
</html>
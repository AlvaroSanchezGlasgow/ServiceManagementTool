<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">


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

	<title>Index</title>

	<style type="text/css" media="print">
@page {
	size: landscape;
}
</style>

	<script type="text/javascript">
		//Function to set Ajax
		function fireAjax() {
			//We validate firstly if any value is empty before send the request to the server	
			if (validateNullsAndEmpty()) {
				setAjax("2018");
			} else {

				$.alert({
					title : 'Validation Error',
					content : 'A valid Reporting Month should be selected',
				});
				//alert("ERROR - Mandatory fields are not populated");
			}

		}

		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		function drawDemandGraph(jsonResponse) {

			document.getElementById('chart_div').innerHTML = "";

			var data = google.visualization.arrayToDataTable(jQuery
					.parseJSON(jsonResponse));

			var options = {
				width : 1450,
				height : 650,
				legend : {
					position : 'top',
					maxLines : 3
				},
				bar : {
					groupWidth : '75%'
				},
				isStacked : true,
				//colors: ['#9AAE04','#707372','#D76734', '#E39F03','#339966','#205390'],
				vAxis : {
					title : 'Hours',
					titleTextStyle : {
						color : '#9AAE04'
					},
					minValue : 0
				}
			};

			var chart = new google.visualization.ColumnChart(document
					.getElementById('chart_div'));

			chart.draw(data, options);

		}

		function drawDemandUtilizationReport(jsonResponse) {

			document.getElementById('chart_div').innerHTML = "";

			var data = google.visualization.arrayToDataTable(jQuery
					.parseJSON(jsonResponse));

			/*var options = {
			     title: '%Demand Commited',
			      curveType: 'function',
			      legend: { position: 'bottom' }
			    };*/

			var options = {
				/* title: '%Demand Commited',*/
				vAxis : {
					title : '%Demand Commited',
					titleTextStyle : {
						color : '#9AAE04'
					}
				},
				hAxis : {
					title : 'Month',
					titleTextStyle : {
						color : '#9AAE04'
					}
				},
				colors : [ '#9AAE04', '#FFFFFF' ],
				vAxis : {
					minValue : 0
				}
			};

			var chart = new google.visualization.AreaChart(document
					.getElementById('chart_div'));
			//  var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

			chart.draw(data, options);

		}

		function drawGadgetCategory(jsonResponse) {
			document.getElementById('chart_div').innerHTML = "";

			var data = google.visualization.arrayToDataTable(jQuery
					.parseJSON(jsonResponse));

			var options = {
				width : 1450,
				height : 650,
				title : 'Gadget Category',
				colors : [ '#9AAE04', '#707372', '#1c417c' ],
				is3D : true
			};

			var chart = new google.visualization.PieChart(document
					.getElementById('chart_div'));

			chart.draw(data, options);
		}

		function drawDemandType(jsonResponse) {
			document.getElementById('chart_div').innerHTML = "";

			var data = google.visualization.arrayToDataTable(jQuery
					.parseJSON(jsonResponse));

			var options = {
				width : 1450,
				height : 650,
				title : 'Demand Type',
				colors : [ '#9AAE04', '#707372', '#1c417c' ],
				is3D : true
			};

			var chart = new google.visualization.PieChart(document
					.getElementById('chart_div'));

			chart.draw(data, options);
		}

		function drawDeliveryModel(jsonResponse) {
			document.getElementById('chart_div').innerHTML = "";

			var data = google.visualization.arrayToDataTable(jQuery
					.parseJSON(jsonResponse));

			var options = {
				width : 1450,
				height : 650,
				title : 'Delivery Model',
				colors : [ '#9AAE04', '#707372', '#FFFFFF' ],
				is3D : true
			};

			var chart = new google.visualization.PieChart(document
					.getElementById('chart_div'));

			chart.draw(data, options);
		}

		function drawTable(jsonResponse) {
			document.getElementById('chart_div').innerHTML = "";
			//$("chart_div").css("height", 1500);

			var data = JSON.parse(jsonResponse);

			$("#chart_div")
					.append(
							"<br></br>"
									+ "<a href=\"javascript:LaunchCSV();\"><b>Export to CSV</b></a>\n"
									+ "<br></br>"
									+ "<table id=\"tableResult\" class=\"display\" style=\"width:100%\">\n"
									+ "<thead>\n" + "<tr>\n"
									+ "<th>Request Type</th>\n"
									+ "<th>Gadget Id</th>\n"
									+ "<th>Delivery Model</th>\n"
									+ "<th>Demand Type</th>\n"
									+ "<th>Hours Type</th>\n"
									+ "<th>Registered Date</th>\n"
									+ "<th>January 2018</th>\n"
									+ "<th>February 2018</th>\n"
									+ "<th>March 2018</th>\n"
									+ "<th>April 2018</th>\n"
									+ "<th>May 2018</th>\n"
									+ "<th>June 2018</th>\n"
									+ "<th>July 2018</th>\n"
									+ "<th>August 2018</th>\n"
									+ "<th>September 2018</th>\n"
									+ "<th>October 2018</th>\n"
									+ "<th>November 2018</th>\n"
									+ "<th>December 2018</th>\n"
									+ "<th>Total 2018</th>\n" + "</tr>\n"
									+ "</thead>\n"
									+ "<tbody style=\"overflow: auto; \">\n");

			for (var i = 0; i < data.length; i++) {
				//var row = $("<tr />");

				$("#tableResult").append(
						"<tr id=\"row_" + i + "\" role=\"row\" class=\"odd\">\n"
								+ "  <td>\n"
								+ data[i].REQUEST_TYPE
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].GADGET_ID
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].DELIVERY_MODEL
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].DEMAND_TYPE
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].HOURS_TYPE
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].REGISTERED_DATE
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].JAN_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].FEB_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].MAR_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].APR_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].MAY_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].JUN_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].JUL_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].AUG_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].SEP_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].OCT_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].NOV_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].DEC_18
								+ "  </td>\n"
								+ "  <td>\n"
								+ data[i].TOTAL
								+ "  </td>\n" + "</tr>\n");

			}

			$("#tableResult").append(
					"</tbody>\n" + "<tfoot>\n" + "<tr>\n"
							+ "<th>Request Type</th>\n"
							+ "<th>Gadget Id</th>\n"
							+ "<th>Delivery Model</th>\n"
							+ "<th>Demand Type</th>\n"
							+ "<th>Hours Type</th>\n"
							+ "<th>Registered Date</th>\n"
							+ "<th>January 2018</th>\n"
							+ "<th>February 2018</th>\n"
							+ "<th>March 2018</th>\n" + "<th>April 2018</th>\n"
							+ "<th>May 2018</th>\n" + "<th>June 2018</th>\n"
							+ "<th>July 2018</th>\n" + "<th>August 2018</th>\n"
							+ "<th>September 2018</th>\n"
							+ "<th>October 2018</th>\n"
							+ "<th>November 2018</th>\n"
							+ "<th>December 2018</th>\n"
							+ "<th>Total 2018</th>\n" + "</tr>\n"
							+ "</tfoot>\n" + "</table>\n");

			//$("#tableResult").DataTable();

			$('#tableResult').DataTable({
				//scrollY:        '80vh',
				//scrollCollapse: true,
				paging : false
			});
		}
	</script>
</head>

<body>


	<form id="form1">

		<input type="hidden" id="action" />
		<input type="hidden" id="reportMonth" />

		<div id="header" class="row">

			<div class="col-md-3 col-sm-4 col-xs-12">
				<a href="http://www.everis.uk.com/" target="_blank"> <img
					src="images/everis_logo.png" class="logo-img" title="everis" />
				</a>

				<p></p>
				<sec:authorize access="hasRole('ADMIN')">
					<a href="/ServiceReporting/admin" title="Administration Page"
						style="font-size: 18px;">Go to Administration Page >></a>
				</sec:authorize>
			</div>
			<div class="col-md-9 col-sm-8 col-xs-12">
				<div id="header-content">
					<h1 class="main-title">
						<span class="green-bar"></span> 2018<span class="font-thin">
							SPW Service</span> Report
					</h1>
				</div>



			</div>
			
			<sec:authentication property="principal.username" />
			<sec:authentication property="principal.authorities" /> - (<a href="<c:url value="/logout" />">Logout</a>)
		</div>

		<div id="content-block" class="row">
			<p></p>
			<a onclick="javascript:window.print();" title="Print"
				class="print-button btn btn-open-readmore">Print</a>


			<div
				class="col-md-offset-3 col-sm-offset-3 col-md-9 col-sm-9 col-xs-4 select-block">
				<div class="months-radio-block">
					<div class="row radio-months">
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="01"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">January</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="02"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">February</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="03"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">March</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="04"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">April</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="05"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">May</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="06"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">June</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="07"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">July</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="08"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">August</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="09"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">September</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="10"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">October</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="11"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">November</span></label>
						</div>
						<div class="col-md-1 col-sm-1 col-xs-12">
							<label> <input type="radio" name="selection"
								class="month-class-radio" id="radioMonth" value="12"
								onclick="javascript:fireAjax();"> <span class="overlay"></span>
									<span class="month-class" accesskey="">December</span></label>
						</div>
					</div>
					<div class="row timeline"></div>

				</div>


			</div>

			<div id="subContent">
				<!-- 
        <div class="col-md-3 col-sm-3 col-xs-8 select-block block2">
              <h2 class="subtitle font-bold">Select Reporting Year:</h2>


              <div id="SelectOptions">
                    <select id="reports" onchange="">
                      <option value="" selected="selected">-SELECT-</option>
                      <option value="2017">2017</option>
                      <option value="2018" selected>2018</option>
                      <option value="2019">2019</option>
                      <option value="2020">2020</option>
                      <option value="2021">2021</option>
                    </select>
              </div>


            </div> -->
				<div class="col-md-3 col-sm-3 col-xs-8 select-block block2">
					<h2 class="subtitle font-bold">Inform Type:</h2>


					<div id="SelectOptions">
						<select id="reports" onchange="javascript:fireAjax();">
							<option value="" selected="selected">-SELECT-</option>
							<option value="01">01. Demand By Type</option>
							<option value="02">02. % Committed Hours</option>
							<option value="03">03. Demand By Delivery Model</option>
							<!-- <option value="04">04. Demand By Detailed Table</option> -->
							<option value="05">04. Demand By Gadget Category</option>
							<option value="06">05. Demand Plan</option>
						</select>
					</div>


				</div>
				<div class="col-md-9 col-sm-9 col-xs-12 main-chart-block">
					<!-- bar charts group -->


					<div id="chart_div">
						<span id="label" class="label-text">Please, select a valid
							reporting month and the type of report you want to display</span>
					</div>
				</div>
			</div>
		</div>
		<!-- Years Drop Down Menu -->

		<!-- /bar charts group -->
	</form>

	<div id="footer">

		<div id="footer-content">
			<span class="font-light">&copy; copyright 2018 everis</span>
		</div>
	</div>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="included/path_lib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${path}/Js/jquery/jquery-3.1.1.min.js"></script>
	<style type="text/css">
	body>table{
		margin: 0 auto;
		padding: 0;
	}
		body table td{
			width: 200px;
			text-align: center;
		}
		body table td,th{
			background: bisque;
		}
		#bookdetail{
			display: none;
			background: #607d8b;
			text-align: center;
			margin-top: 50px;
			border-radius: 5px;
			/* border: 1px solid #ffeb3b; */
			text-shadow: 1px 1px 1px #22629B;
		}
		#bookdetail p:hover{
			color: #00bcd4;
			font-size: 18px;
		}
	</style>
  </head>
  
  <body>
    <table>
    	<thead>
    		<tr>
    			<th style="width:200px;">书名</th>
    			<th style="width:200px;">数量</th>
    			<th colspan="2">操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="book" items="${booklist}">
    			<tr>
    				<td>${book.name }</td>
    				<td>${book.number }</td>
    				<td><a href="javascript:;" onclick="bookdetail(${book.bookId })">查看</a></td>
    				<td><a href="javascript:;" onclick="querybook(${book.bookId})">预约</a></td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    <div id="bookdetail">
    </div>
    <script type="text/javascript">
    	function bookdetail(bookid){
    		var url="${path}/book/bookdetail.html";
    		$.ajax({
    			url: url,
    			data: {"bookid": bookid},
    			type: "get",
    			success: function(data){
    				$("#bookdetail").show();
    				$("#bookdetail").html(data);
    			}
    		});	
    	}
    	function closeDetail(){
    		if(!$("#bookdetail").is(":hidden")){
    			$("#bookdetail").hide();
    		}
    	}
    	function querybook(bookid){
    		var url="${path}/book/appointbook.action";
    		//var studentid=2;
    		var max=1000,min=1;
    		var num=Math.ceil(Math.random()*(max-min)+min);
    		$.ajax({
    			url: url,
    			cache: false,
    			data: {"bookid": bookid,"studentid": num},
    			contenType: "application/json;charset=utf-8",
    			type: "post",
    			dataType: "json",
    			success: function(data){
    				if(data.success==true){
    					alert(data.data.stateInfo);
    					location.reload(true);
    				}
    				if(data.success==false){
    					alert(data.error);
    				}
    			}
    		});
    	}
    </script>
  </body>
</html>

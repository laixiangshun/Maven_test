<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${book.name}详情</title>

	<%-- <script type="text/javascript" src="${path}/Js/jquery/jquery-3.1.1.min.js"></script> --%>
	<style type="text/css">
		button {
			width: 100px;
			height: 50px;
			/* background: #00bcd4; */
			margin-bottom: 10px;
			font-size: 18px;
			color: #fff;
			/*文本阴影，颜色为白色，文本阴影为向右向下各1px,0.5px大小   */
			text-shadow: 1px 1px 0.5px #22629B;
			/*字体间间隔  */
			letter-spacing: 8px;
			border-radius: 5px;
			border: 1px solid #2576A8;
			/*加上渐变色   */
			background: -webkit-linear-gradient(top,#00bcd4,#2e88c0);
			background: -mos-linear-gradient(top,#00bcd4,#2e88c0);
			background: linear-gradient(top,#00bcd4,#2e88c0);
			background: -ms-linear-gradient(top,#00bcd4,#2e88c0);
			/*内阴影  */
			/*0 1px 2px #B8DCF1 inset 是内高光  */
			/*0 -1px 0 #316F96 inset 是内阴影  */
			box-shadow: 0 1px 2px #8AC1E2 inset,0 -1px 0 #316F96 inset;
		}
		button:hover{
			background: -webkit-linear-gradient(top,#8DC9EF,#4E9FD1);
			background: -mos-linear-gradient(top,#8DC9EF,#4E9FD1);
			background: linear-gradient(top,#8DC9EF,#4E9FD1);
			background: -ms-linear-gradient(top,#8DC9EF,#4E9FD1);
		}
		.show p{
			height: auto;
			overflow: hidden;
			display: inline-block;
		}
		.show > p:first-child{
			margin-top:30px;
			/* background: red; */
		}
	</style>
  </head>
  
  <body>
  	<div class="show">
  		<p><span>书名：${book.name}</span></p></br>
     	<p><span>库存：${book.number}</span></p>
  	</div>
    <div><button onclick="closeDetail();">关闭</button></div>
  </body>
</html>

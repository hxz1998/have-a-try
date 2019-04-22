<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成绩单</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<link href="css/mui.min.css" rel="stylesheet" />
	<script src="js/mui.min.js"></script>
  </head>
  
  <body>
	<header class="mui-bar mui-bar-nav">
	    <h1 class="mui-title">成绩单</h1>
	</header>
	
	<div class="mui-content" id="transcripts">
	    <ul class="mui-table-view">
	        <li class="mui-table-view-cell" v-for="(value, key) in map">
	            <span>{{ key }} --- </span>{{ value }}
	        </li>
	    </ul>
	</div>
    
    <script type="text/javascript" src="js/vue.min.js" ></script>
    <script>
		mui.ready(
			initData
		);
    	
    	var vm = new Vue({
			el:'#transcripts',
			data:{"map":{}}
		});
    	
    	function initData() {
    		var response = ${request.getTranscript};
			vm.$data.map = response.map;
		}
    </script>
  </body>
</html>

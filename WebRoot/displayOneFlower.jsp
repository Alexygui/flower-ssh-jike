<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/jkxyflower.css">
	
</head>

<body>
	
	 <div class="content">
		<div class="left">
		</div>
		<div class="right">
		<div style="padding-left:200px;width: 600px;">
		<s:action name="browseCatalog" executeResult="false"/>
		<s:set value="#request.flower" id="flower"></s:set>
		  <s:form action="addOrUpdateFlower.action" method="post" enctype="multipart/form-data">
		 <tr><td></td><td>请在此修改花品的信息</td></tr>
  
  <s:textfield label="品名"  name="flower.flowername" value="%{#flower.flowername}"></s:textfield>
   <tr><td>价格</td><td><input type="text" name="flower.price" value="<s:property value="#flower.price"/>"> <label>元</label></td></tr>
    <s:set value="#request.catalogs" id="catalog"></s:set> 
    <s:select label="分类" list="#catalog"  listKey="catalogid" listValue="catalogname" name="flower.catalog.catalogid" value="%{#flower.catalog.catalogid}"></s:select>
      <tr> <td></td><td><input type="file" name="upload" value="<s:property value="#flower.picture"/>"/></td><td  >

<img  alt=""   src="pic/<s:property value="#flower.picture"/>">
</td></tr>
       <s:hidden name="flower.flowerid" value="%{#flower.flowerid}"></s:hidden>
        <s:hidden name="picture" value="%{#flower.picture}"></</s:hidden>>

   <s:submit value="修改"></s:submit>
  
    </s:form> 
    </div>
			</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>

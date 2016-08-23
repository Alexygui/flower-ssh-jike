<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
		<div class="left"></div>
		<div class="right">
			<div style="padding-left:200px;width: 600px;">
				<s:form action="addOrUpdateFlower" method="post"	enctype="multipart/form-data">
					<tr>
						<td></td>
						<td>请输入新的花品的信息</td>
					</tr>

					<s:textfield label="品名" name="flower.flowername"></s:textfield>
					<tr>
						<td>价格</td>
						<td><input type="text" name="flower.price"><label>元</label></td>
					</tr>
					<s:action name="browseCatalog" executeResult="false"></s:action>
					<!-- 测试代码 -->
					<%-- <s:set value="#request.catalogs" id="catalog"></s:set>
					<s:property value="#catalog.size"/> --%>
					<!-- list用于取值，key和value是对应的键和值，name和value是返回给java程序的字段名称和值 -->
					<s:select label="分类" list="#request.catalogs" listKey="catalogid"
						listValue="catalogname" name="flower.catalog.catalogid"
						value="3"></s:select>
						
					<s:file name="upload" label="图片"></s:file>	
					<s:submit value="添加"></s:submit>
				</s:form>
<%-- <s:debug></s:debug> --%>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>

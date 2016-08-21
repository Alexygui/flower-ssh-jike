<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">

			<s:action name="browseCatalog" executeResult="true"></s:action>


		</div>
		<div class="right">
		<s:set value="#session.cart.items" id="items"></s:set>	
		<!-- 如果购物车的items对象不为空，则取出其中的值并显示 -->
		<s:if test="#items.size!=0">
			<s:iterator value="#items" id="item">
				<div style="text-align: left">
					<s:form action="updateAction" method="post">
						<div class="flowercheck">花名:<s:property value="value.flower.flowername"/></div>	
						<div class="flowercheck">价格:<s:property value="value.flower.price"/></div>
						<div class="flowercheck">数量:<input size="4" type="text" name="quantity" value="<s:property value="value.quantity"/>"/></div>
						<input type="hidden" name="flowerid" value='<s:property value="value.flower.flowerid"/>'>
						<div class="flowercheck"><input type="submit" value="更新"></div>
					</s:form>
				</div>
			</s:iterator>
		</s:if>
		<!-- 在另一个表单中提交整个页面的修改，不与上面表单当中的提交冲突 -->
		<div style="clear:both;">
			<s:form action="checkOut" method="post">
				<s:submit value="提交订单"></s:submit>
			</s:form>	
		</div>
		<!-- 如果购物车中为空，则打印无商品的信息 -->
		<s:else>
		您的购物车空空如也~
		</s:else>
		</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>

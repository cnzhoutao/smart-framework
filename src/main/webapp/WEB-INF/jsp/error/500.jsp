<%@ page pageEncoding="UTF-8" %>
<%@ include file="../common/header.jsp" %>

<div id="header">
    <div class="logo">
        <a href="${BASE}/"><f:message key="common.title"/></a>
    </div>
</div>

<div id="content">
    <div id="main">
        <h3>500 - <f:message key="error.page.500"/></h3>
        <a href="javascript:history.back();"><f:message key="common.back"/></a>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>
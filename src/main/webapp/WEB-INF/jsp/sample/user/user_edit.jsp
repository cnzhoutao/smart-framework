<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../common/header.jsp" %>

<%@ taglib prefix="security" uri="/security" %>
<%@ include file="../../common/top.jsp" %>

<c:set var="user" value="${userBean.user}"/>
<c:set var="userRoleList" value="${userBean.roleList}"/>

<input type="hidden" id="id" value="${user.id}">

<div id="content">
    <form id="user_edit_form" class="css-form">
        <div class="css-form-header">
            <h3><f:message key="user.edit_user"/></h3>
        </div>
        <div class="css-form-row">
            <label for="username"><f:message key="user.username"/>:</label>
            <input type="text" id="username" value="${user.username}" class="css-readonly" readonly>
        </div>
        <div class="css-form-row">
            <label for="password"><f:message key="user.password"/>:</label>
            <input type="text" id="password" name="password">
            <span class="css-tip"><f:message key="user.password.tip"/></span>
        </div>
        <div class="css-form-row">
            <label><f:message key="user.role"/>:</label>
            <div class="css-form-cell">
                <tag:role roleList="${roleList}" userRoleList="${userRoleList}"/>
            </div>
        </div>
        <div class="css-form-footer">
            <button type="submit"><f:message key="common.save"/></button>
            <button type="button" id="back"><f:message key="common.back"/></button>
        </div>
    </form>
</div>

<%@ include file="../../common/footer.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/user_edit.js"></script>
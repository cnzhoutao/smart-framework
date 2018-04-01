<%@ page pageEncoding="UTF-8" %>
<%@ include file="../../common/header.jsp" %>
<%@ taglib prefix="security" uri="/security" %>
<%@ include file="../../common/top.jsp" %>

<div id="content">
    <div id="main">
        <div class="css-panel">
            <div class="css-panel-header">
                <h3><f:message key="user.user_list"/></h3>
            </div>
            <div class="css-panel-content">
                <div class="css-row">
                    <div class="css-left">
                        <form id="user_search_form">
                            <div class="css-search">
                                <input type="text" name="username" placeholder="<f:message key="user.username"/>">
                                <span class="css-search-button">
                                    <button type="submit"><f:message key="common.search"/></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <div class="css-right">
                        <a href="${BASE}/user"><f:message key="user.create_user"/></a>
                    </div>
                </div>
                <div id="user_list">
                    <%@ include file="user_list.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../common/footer.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/user.js"></script>
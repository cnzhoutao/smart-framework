<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<c:set var="BASE_COMMON" value="${BASE}/WEB-INF/jsp/common" />
<f:setBundle basename="i18n.i18n_${system_language}"/>
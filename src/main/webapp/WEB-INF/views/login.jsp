
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp" %>
<body>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <form action ="/login" method ="post" id="login">
        <div class="form-group">
            <input type="email" name="username" id="username" placeholder="Email">
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło">
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="#" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</section>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<%@include file="header.jsp" %>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="#">Zaloguj</a></li>
            <li class="highlighted"><a href="#">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="index.html" class="btn btn--without-border active">Start</a></li>
            <li><a href="index.html#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="index.html#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="index.html#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="index.html#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="registerForm" action="registration" method="post">
        <div class="form-group">
            <form:input path="firstName" type="text" name="firstName" placeholder="Name"/>
            <label style="color: red">   <form:errors path="firstName" element="div" cssClass="error"></form:errors></label>
        </div>
        <div class="form-group">
            <form:input path="lastName" type="text" name="lastName" placeholder="Last name"/>
            <label style="color: red">  <form:errors path="lastName" element="div" cssClass="error"></form:errors></label>
        </div>
        <div class="form-group">
            <form:input path="email" type="email" name="email" placeholder="Email"/>
           <label style="color: red"> <form:errors path="email" element="div" cssClass="error"></form:errors></label>
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password" placeholder="Hasło"/>
            <label style="color: red"> <form:errors path="password" element="div" cssClass="error"></form:errors></label>
        </div>
        <div class="form-group">
            <form:input path="retypePassword" type="password" name="password2" placeholder="Powtórz hasło"/>
            <label style="color: red"> <form:errors path="retypePassword" element="div" cssClass="error"></form:errors></label>
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/menu.js"/>"></script>
</body>
</html>

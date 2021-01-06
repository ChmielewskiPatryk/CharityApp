<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form:form class="form-contact" modelAttribute="contactMessage" action="/sendMessage" method="post" >
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię"/></div>
            <div class="form-group form-group--50"><input type="email" name="email" placeholder="Email"/></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form:form> <%-- wysyłanie po formularzu na adres email wiadomości.--%>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2021</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="<c:url value="/resources/images/icon-facebook.svg"/> "/></a>
            <a href="#" class="btn btn--small"><img src="<c:url value="/resources/images/icon-instagram.svg"/> "/></a>
        </div>
    </div>
</footer>

<script src="<c:url value="/resources/js/app.js"/>"></script>
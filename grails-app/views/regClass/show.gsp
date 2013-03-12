
<%@ page import="uk.ac.shu.webarch.eRegister.RegClass" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regClass.label', default: 'RegClass')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-regClass" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-regClass" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list regClass">
			
				<g:if test="${regClassInstance?.classInstructor}">
				<li class="fieldcontain">
					<span id="classInstructor-label" class="property-label"><g:message code="regClass.classInstructor.label" default="Class Instructor" /></span>
					
						<span class="property-value" aria-labelledby="classInstructor-label"><g:link controller="instructor" action="show" id="${regClassInstance?.classInstructor?.id}">${regClassInstance?.classInstructor?.instructorName.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${regClassInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="regClass.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${regClassInstance?.course?.id}">${regClassInstance?.course?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${regClassInstance?.sheets}">
				<li class="fieldcontain">
					<span id="sheets-label" class="property-label"><g:message code="regClass.sheets.label" default="Sheets" /></span>
					
						<g:each in="${regClassInstance.sheets}" var="s">
						<span class="property-value" aria-labelledby="sheets-label"><g:link controller="registerSheet" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${regClassInstance?.id}" />
					<g:link class="edit" action="edit" id="${regClassInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

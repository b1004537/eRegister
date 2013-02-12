<%@ page import="uk.ac.shu.webarch.eRegister.Course" %>



<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="course.code.label" default="Code" />
		
	</label>
	<g:textField name="code" value="${courseInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="course.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${courseInstance?.name}"/>
</div>


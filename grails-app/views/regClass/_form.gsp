<%@ page import="uk.ac.shu.webarch.eRegister.RegClass" %>



<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'classCode', 'error')} ">
	<label for="classCode">
		<g:message code="regClass.classCode.label" default="Class Code" />
		
	</label>
	<g:textField name="classCode" value="${regClassInstance?.classCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'classInstructor', 'error')} required">
	<label for="classInstructor">
		<g:message code="regClass.classInstructor.label" default="Class Instructor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="classInstructor" name="classInstructor.id" from="${uk.ac.shu.webarch.eRegister.Instructor.list()}" optionKey="id" required="" value="${regClassInstance?.classInstructor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="regClass.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${uk.ac.shu.webarch.eRegister.Course.list()}" optionKey="id" required="" value="${regClassInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: regClassInstance, field: 'sheets', 'error')} ">
	<label for="sheets">
		<g:message code="regClass.sheets.label" default="Sheets" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${regClassInstance?.sheets?}" var="s">
    <li><g:link controller="registerSheet" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registerSheet" action="create" params="['regClass.id': regClassInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registerSheet.label', default: 'RegisterSheet')])}</g:link>
</li>
</ul>

</div>


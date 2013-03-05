<%@ page import="uk.ac.shu.webarch.eRegister.Instructor" %>



<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'classTaught', 'error')} ">
	<label for="classTaught">
		<g:message code="instructor.classTaught.label" default="Class Taught" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${instructorInstance?.classTaught?}" var="c">
    <li><g:link controller="regClass" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="regClass" action="create" params="['instructor.id': instructorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'regClass.label', default: 'RegClass')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'instructorName', 'error')} ">
	<label for="instructorName">
		<g:message code="instructor.instructorName.label" default="Instructor Name" />
		
	</label>
	<g:textField name="instructorName" value="${instructorInstance?.instructorName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: instructorInstance, field: 'staffId', 'error')} ">
	<label for="staffId">
		<g:message code="instructor.staffId.label" default="Staff Id" />
		
	</label>
	<g:textField name="staffId" value="${instructorInstance?.staffId}"/>
</div>


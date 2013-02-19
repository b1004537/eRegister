<%@ page import="uk.ac.shu.webarch.eRegister.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'fullStudentName', 'error')} ">
	<label for="fullStudentName">
		<g:message code="student.fullStudentName.label" default="Full Student Name" />
		
	</label>
	<g:textField name="fullStudentName" value="${studentInstance?.fullStudentName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'studentNumber', 'error')} ">
	<label for="studentNumber">
		<g:message code="student.studentNumber.label" default="Student Number" />
		
	</label>
	<g:textField name="studentNumber" value="${studentInstance?.studentNumber}"/>
</div>


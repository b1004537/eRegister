package uk.ac.shu.webarch.eRegister

class Course {

	
	String courseName
	String courseCode
	String courseDescription


Set classes



    static constraints = {
	courseCode maxSize: 20
    }


static hasMany = [classes: RegClass]
static mappedBy = [classes: 'course']


static mapping = {

	table 'course'
	courseName colum: 'course_name'
	courseCode column: 'mapped_course_code'
	courseDescription column: 'course_desc', type:'text'
	}
}

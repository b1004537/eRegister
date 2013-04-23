package uk.ac.shu.webarch.eRegister

class RegClass {

	String classCode	
	Instructor classInstructor
	Course course
	Set sheets


    static constraints = {


}


static hasMany = [sheets: RegisterSheet]
static mappedBy = [sheets: 'regclass']


	
}

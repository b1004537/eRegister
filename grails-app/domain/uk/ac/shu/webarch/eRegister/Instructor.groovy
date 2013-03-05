package uk.ac.shu.webarch.eRegister

class Instructor {

	String instructorName
	String staffId
	Set classTaught
	

	static hasMany = [classTaught:RegClass]
	static mappedBy = [classTaught:'classInstructor']


    static constraints = {
    }
}

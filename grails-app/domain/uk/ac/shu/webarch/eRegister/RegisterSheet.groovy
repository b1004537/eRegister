package uk.ac.shu.webarch.eRegister

class RegisterSheet {

	RegClass regclass



    static constraints = {
	
    }


static hasMany = [classes: RegisterEntry]
static mappedBy = [classes: 'regSigned']


static mapping = {

	table 'registersheet'
	// regclass colum: 'student_name', type 'text'
	}







}

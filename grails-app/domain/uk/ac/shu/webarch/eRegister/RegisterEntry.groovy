package uk.ac.shu.webarch.eRegister

class RegisterEntry {

	 Student studentSigningRegister 
	 RegisterSheet regSigned

    static constraints = {
    }


	static hasOne = [sheets: RegisterSheet]
	static mappedBy = [sheets: 'regEntry']


}

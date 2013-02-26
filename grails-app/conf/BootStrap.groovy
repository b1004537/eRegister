import uk.ac.shu.webarch.eRegister.*


class BootStrap {

    def init = { servletContext ->
    

    	println("BootStrap::init");

	def tom_instructor = Instructor.findByInstructorName('64535d'); 

	println("Result of kind by staffid for tom: ${tom_instructor}");
	
    }

    def destroy = {
    }
}

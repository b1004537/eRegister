import uk.ac.shu.webarch.eRegister.*


class BootStrap {

    def init = { servletContext ->
    

    	println("BootStrap::init");

	def tom_instructor = Instructor.findByStaffId('646345d') ?: new Instructor(staffId:'646345d', 			instructorName:'Tom Presbury').save();
	
	def matthew_instructor = Instructor.findByStaffId('333333') ?: new Instructor(staffId:'333333', 			instructorName:'Matthew Love').save();

	def web_arch_course = Course.findByCourseCode('44334dd') ?: new Course(courseCode:'44334dd',
										courseName: 'Web Architectures',
										courseDescription: ' So boring')
													.save();
	
    }

    def destroy = {
    }
}

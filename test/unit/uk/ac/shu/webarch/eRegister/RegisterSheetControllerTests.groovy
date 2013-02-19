package uk.ac.shu.webarch.eRegister



import org.junit.*
import grails.test.mixin.*

@TestFor(RegisterSheetController)
@Mock(RegisterSheet)
class RegisterSheetControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/registerSheet/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.registerSheetInstanceList.size() == 0
        assert model.registerSheetInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.registerSheetInstance != null
    }

    void testSave() {
        controller.save()

        assert model.registerSheetInstance != null
        assert view == '/registerSheet/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/registerSheet/show/1'
        assert controller.flash.message != null
        assert RegisterSheet.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/registerSheet/list'

        populateValidParams(params)
        def registerSheet = new RegisterSheet(params)

        assert registerSheet.save() != null

        params.id = registerSheet.id

        def model = controller.show()

        assert model.registerSheetInstance == registerSheet
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/registerSheet/list'

        populateValidParams(params)
        def registerSheet = new RegisterSheet(params)

        assert registerSheet.save() != null

        params.id = registerSheet.id

        def model = controller.edit()

        assert model.registerSheetInstance == registerSheet
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/registerSheet/list'

        response.reset()

        populateValidParams(params)
        def registerSheet = new RegisterSheet(params)

        assert registerSheet.save() != null

        // test invalid parameters in update
        params.id = registerSheet.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/registerSheet/edit"
        assert model.registerSheetInstance != null

        registerSheet.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/registerSheet/show/$registerSheet.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        registerSheet.clearErrors()

        populateValidParams(params)
        params.id = registerSheet.id
        params.version = -1
        controller.update()

        assert view == "/registerSheet/edit"
        assert model.registerSheetInstance != null
        assert model.registerSheetInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/registerSheet/list'

        response.reset()

        populateValidParams(params)
        def registerSheet = new RegisterSheet(params)

        assert registerSheet.save() != null
        assert RegisterSheet.count() == 1

        params.id = registerSheet.id

        controller.delete()

        assert RegisterSheet.count() == 0
        assert RegisterSheet.get(registerSheet.id) == null
        assert response.redirectedUrl == '/registerSheet/list'
    }
}

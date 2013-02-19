package uk.ac.shu.webarch.eRegister

import org.springframework.dao.DataIntegrityViolationException

class RegisterSheetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [registerSheetInstanceList: RegisterSheet.list(params), registerSheetInstanceTotal: RegisterSheet.count()]
    }

    def create() {
        [registerSheetInstance: new RegisterSheet(params)]
    }

    def save() {
        def registerSheetInstance = new RegisterSheet(params)
        if (!registerSheetInstance.save(flush: true)) {
            render(view: "create", model: [registerSheetInstance: registerSheetInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), registerSheetInstance.id])
        redirect(action: "show", id: registerSheetInstance.id)
    }

    def show(Long id) {
        def registerSheetInstance = RegisterSheet.get(id)
        if (!registerSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), id])
            redirect(action: "list")
            return
        }

        [registerSheetInstance: registerSheetInstance]
    }

    def edit(Long id) {
        def registerSheetInstance = RegisterSheet.get(id)
        if (!registerSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), id])
            redirect(action: "list")
            return
        }

        [registerSheetInstance: registerSheetInstance]
    }

    def update(Long id, Long version) {
        def registerSheetInstance = RegisterSheet.get(id)
        if (!registerSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (registerSheetInstance.version > version) {
                registerSheetInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'registerSheet.label', default: 'RegisterSheet')] as Object[],
                          "Another user has updated this RegisterSheet while you were editing")
                render(view: "edit", model: [registerSheetInstance: registerSheetInstance])
                return
            }
        }

        registerSheetInstance.properties = params

        if (!registerSheetInstance.save(flush: true)) {
            render(view: "edit", model: [registerSheetInstance: registerSheetInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), registerSheetInstance.id])
        redirect(action: "show", id: registerSheetInstance.id)
    }

    def delete(Long id) {
        def registerSheetInstance = RegisterSheet.get(id)
        if (!registerSheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), id])
            redirect(action: "list")
            return
        }

        try {
            registerSheetInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'registerSheet.label', default: 'RegisterSheet'), id])
            redirect(action: "show", id: id)
        }
    }
}

package name.stokito.listParamsExample

import grails.validation.Validateable

@Validateable
class UserListFilter extends ListParams {
    String email
    String name
    Date dateCreatedFrom
    Date dateCreatedTo
}

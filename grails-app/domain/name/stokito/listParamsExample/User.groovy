package name.stokito.listParamsExample

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = 'email')
class User {
    String email
    String name
    static constraints = {
    }
}

import name.stokito.listParamsExample.User

class BootStrap {

    def init = { servletContext ->
        30.times {
            User user = new User(email: "user${it}@example.com", name: "User${it}")
            user.save(flush: true, failOnError: true)
        }
    }
    def destroy = {
    }
}

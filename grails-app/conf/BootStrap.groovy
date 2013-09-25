import name.stokito.listParamsExample.User

class BootStrap {

    def init = { servletContext ->
        10.times {
            User user = new User(email: "user${it}@example.com", name: "User${it}")
            user.save(flush: true, failOnError: true)
        }
    }
    def destroy = {
    }
}

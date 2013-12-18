package name.stokito.listParamsExample

import grails.plugin.fixtures.Fixture
import grails.plugin.fixtures.FixtureLoader
import grails.test.spock.IntegrationSpec
import spock.lang.Shared

class ListParamsSpec extends IntegrationSpec {

    FixtureLoader fixtureLoader

    void testMax() {
        given:
        Fixture fixture = fixtureLoader.load {
            build {
                user1(User, email: 'user1@example.com')
                user2(User, email: 'user2@example.com')
                user3(User, email: 'user3@example.com')
            }
        }
        ListParams listParams = new ListParams(max: 1, sort: 'email')
        when:
        List<User> users = User.list(listParams.params)
        then:
        users.size() == 1
        users[0] == fixture.user1
    }

    void testOffset() {
        given:
        Fixture fixture = fixtureLoader.load {
            build {
                user1(User, email: 'user1@example.com')
                user2(User, email: 'user2@example.com')
                user3(User, email: 'user3@example.com')
            }
        }
        ListParams listParams = new ListParams(max: 1, offset: 1, sort: 'email')
        when:
        List<User> users = User.list(listParams.params)
        then:
        users.size() == 1
        users[0] == fixture.user2
    }

}

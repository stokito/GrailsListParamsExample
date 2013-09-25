package name.stokito.listParamsExample

import spock.lang.Specification

class ListParamsCorrectMaxSpec extends Specification {
    void 'if max is not set then correct max will be by default'() {
        when:
        ListParams listParams = new ListParams(max: null)
        then:
        listParams.correctMax == 10
    }

    void 'if max is less than 1 then correct max will 1'() {
        when:
        ListParams listParams = new ListParams(max: 0)
        then:
        listParams.correctMax == 1
    }

    void 'if max is more than high limit then correct max will be as high limit'() {
        when:
        ListParams listParams = new ListParams(max: 101)
        then:
        listParams.correctMax == 100
    }

    void 'if max is in bound then correct max is same'() {
        given:
        ListParams listParams = new ListParams()
        when:
        listParams.max = 1
        then:
        listParams.correctMax == 1
        when:
        listParams.max = 10
        then:
        listParams.correctMax == 10
        when:
        listParams.max = 100
        then:
        listParams.correctMax == 100
    }

}

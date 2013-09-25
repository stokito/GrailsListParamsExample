package name.stokito.listParamsExample

import grails.validation.Validateable

@Validateable
class ListParams {

    public static final int MAX_DEFAULT = 10
    public static final int MAX_HIGH_LIMIT = 100
    public static final int MAX_LOW_LIMIT = 1

    Integer max = MAX_DEFAULT
    Integer offset
    String sort
    String order

    static constraints = {
        max(nullable: true, min: MAX_LOW_LIMIT, max: MAX_HIGH_LIMIT)
        offset(nullable: true, min: 0)
        sort(nullable: true, blank: false)
        order(nullable: true, blank: false, inList: ['asc', 'desc'])
    }

    Map <String, String> getParams() {
        Map <String, String> listParam = [:]
        if (correctMax != null) {
            listParam.max = correctMax.toString()
        }
        if (sort != null) {
            listParam.sort = sort.toString()
        }
        if (order != null) {
            listParam.order = order.toString()
        }
        if (offset != null) {
            listParam.offset = offset.toString()
        }
        return listParam
    }

    Integer getCorrectMax() {
        def correctMax = max != null ? max : MAX_DEFAULT
        correctMax = correctMax < MAX_LOW_LIMIT ? MAX_LOW_LIMIT: correctMax
        correctMax = correctMax > MAX_HIGH_LIMIT ? MAX_HIGH_LIMIT: correctMax
        return correctMax
    }
}

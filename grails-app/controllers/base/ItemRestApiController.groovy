package base

import grails.rest.RestfulController
import groovy.sql.Sql

class ItemRestApiController extends RestfulController {

    def dataSource
    ItemService itemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static responseFormats = ['json', 'xml']

    ItemRestApiController(){
        super(Item)
    }


    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond itemService.list(params), model:[itemCount: itemService.count()]
    }


    def getItem(){

        respond itemService.list(params), model:[itemCount: itemService.count()]

    }



    def getItem2(){

        // def returnJSON = [:]
        def returnJSON = []

        String userQueryP1 = params.uq1
        String userQueryP2 = params.uq2

        // 1. query
        String queryStr = """
        SELECT 
            ID, CODE, DESCRIPTION
        FROM
            bas_item
        WHERE
            (1=1)
                AND DESCRIPTION LIKE '%"""+userQueryP1+"""%'
        ORDER BY ID
        """
        println(queryStr)

        // 2. execute
        def conn = Sql.newInstance(dataSource)
        def queryResultList = conn.rows(queryStr)
        conn.close()


        // 3. process JSON data for response
        if( queryResultList.size() > 0) {
            queryResultList.each { thisRow ->
                String id = thisRow["ID"]
                String code = thisRow["CODE"]
                String description = thisRow["DESCRIPTION"]

                def lineBean = [:]
                lineBean['id'] = id
                lineBean['code'] = code
                lineBean['description'] = description
                lineBean['codeDescription'] = code + "-" + description
                // push
                returnJSON.add(lineBean)
            }
        }

        respond returnJSON

    }



    def getItem3(){

        respond itemService.list(params), model:[itemCount: itemService.count()]

    }



}

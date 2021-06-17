package base

class Item {

    Long id

    String code
    String description

    // System log fields
    Date creationDateTime
    String creationUser
    Date lastUpdateDateTime
    String lastUpdateUser


    static mapping = {
        table 'bas_item'
        version false
        id generator: 'increment'
        id column: 'ID'

        code column: "CODE", sqlType: "varchar(25)"
        description column: 'DESCRIPTION'

        creationDateTime column: 'CREATION_DATETIME'
        creationUser column: 'CREATION_USER'
        lastUpdateDateTime column: 'LAST_UPDATE_DATETIME'
        lastUpdateUser column: 'LAST_UPDATE_USER'
    }


    static constraints = {
        code nullable: false
        description nullable: false

        creationDateTime nullable: true
        creationUser nullable: true
        lastUpdateDateTime nullable: true
        lastUpdateUser nullable: true
    }


}
